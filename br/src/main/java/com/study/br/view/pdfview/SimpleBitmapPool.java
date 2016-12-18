package com.study.br.view.pdfview;

import android.graphics.Bitmap;

/**
 * Created by adventurer on 16-12-14.
 */

public class SimpleBitmapPool implements BItmapContainer{

    Bitmap[] bitmaps;

    private int poolSize;
    private int width;
    private int height;

    private Bitmap.Config config;

    public SimpleBitmapPool(PdfRendererParams params){
        this.poolSize = getPoolSize(params.getOffScreenSize());
        this.width = params.getWidth();
        this.height = params.getHeight();
        this.config = params.getConfig();
        this.bitmaps = new Bitmap[poolSize];

    }

    private int getPoolSize(int offScreenSize) {
        return offScreenSize * 2 + 1;
    }




    @Override
    public Bitmap get(int position) {
        return null;
    }

    @Override
    public void remove(int position) {

    }

    @Override
    public void clear() {
        recycleAll();

    }

    private void recycleAll() {
        for(int i = 0; i < poolSize; i++){
            if(bitmaps[i] != null){
                bitmaps[i].recycle();
                bitmaps[i] = null;
            }
        }
    }
}
