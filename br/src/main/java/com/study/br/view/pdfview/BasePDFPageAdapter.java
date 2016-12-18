package com.study.br.view.pdfview;

import android.app.Activity;
import android.content.Context;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

/**
 * Created by adventurer on 16-12-14.
 */

public class BasePDFPageAdapter extends PagerAdapter {

    protected static final int FIRST_PAGE = 0;
    protected static final float DEFAULT_QUALITY = 2.0f;
    protected static final int DEFAULT_OFFSCREENSIZE = 1;

    String pdfPath;
    Context context;
    PdfRenderer renderer;
    BItmapContainer bItmapContainer;
    LayoutInflater inflator;

    protected float renderQuality;
    protected int offScreenSize;

    public BasePDFPageAdapter(Context context,String pdfPath){
        this.pdfPath = pdfPath;
        this.context = context;
        this.renderQuality = DEFAULT_QUALITY;
        this.offScreenSize = DEFAULT_OFFSCREENSIZE;

        init();
    }

    public BasePDFPageAdapter(Context context,String pdfPath,int offScreenSize){
        this.pdfPath = pdfPath;
        this.context = context;
        this.renderQuality = DEFAULT_QUALITY;
        this.offScreenSize = offScreenSize;
        init();
    }

    @SuppressWarnings("NewApi")
    private void init() {
        try {
            renderer= new PdfRenderer(getSeekableFileDescriptor(pdfPath));
            inflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            PdfRendererParams params = extractPdfParamsFromFirstPage(renderQuality,renderQuality);
        }catch (Exception e){

        }

    }

    private PdfRendererParams extractPdfParamsFromFirstPage(float renderQuality, float renderQuality1) {
        return null;
    }

    private ParcelFileDescriptor getSeekableFileDescriptor(String pdfPath) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptor;
        File pdfCopy = new File(pdfPath);
        if(pdfCopy.exists()){
            parcelFileDescriptor = ParcelFileDescriptor.open(pdfCopy,ParcelFileDescriptor.MODE_READ_ONLY);
            return parcelFileDescriptor;
        }
        if(isAnAnsset(pdfPath)){
            pdfCopy = new File(context.getCacheDir(),pdfPath);
            parcelFileDescriptor = ParcelFileDescriptor.open(pdfCopy,ParcelFileDescriptor.MODE_READ_ONLY);
        } else{
            URI uri = URI.create(String.format("file://%s",pdfPath));
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(uri.toString()),"rw");
        }
        return parcelFileDescriptor;



    }

    private boolean isAnAnsset(String pdfPath) {
        return !pdfPath.startsWith("/");
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
