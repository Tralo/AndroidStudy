package com.example.taotao.mvp_study.presenter;

import android.os.Handler;
import android.os.Message;

import com.example.taotao.mvp_study.model.IDownloadModel;
import com.example.taotao.mvp_study.model.impl.DownloadModelImpl;
import com.example.taotao.mvp_study.view.IDownloadView;


/**
 * Created by taotao on 16-5-27.
 */
public class DownloadPresenter {


    private IDownloadView iDownloadView;
    private IDownloadModel downloadModel;



    public DownloadPresenter(IDownloadView iDownloadView){
        this.iDownloadView = iDownloadView;
        downloadModel = new DownloadModelImpl();
    }

    public void startDownload(){
        downloadModel.startDownload(new DownloadModelImpl.DownloadListener() {
            @Override
            public void startDownload() {
                iDownloadView.startDownload();
            }

            @Override
            public void downloading(int process) {
                iDownloadView.downloading(process);
            }

            @Override
            public void finishDownload() {
                iDownloadView.finishDownload();
            }
        });


    }


}
