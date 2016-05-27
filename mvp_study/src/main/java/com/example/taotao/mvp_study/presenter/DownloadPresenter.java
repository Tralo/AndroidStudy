package com.example.taotao.mvp_study.presenter;

import android.os.Handler;
import android.os.Message;

import com.example.taotao.mvp_study.view.IDownloadView;


/**
 * Created by taotao on 16-5-27.
 */
public class DownloadPresenter {

    private IDownloadView iDownloadView;
    private boolean isStart = false;
    private boolean isFinish = false;



    public DownloadPresenter(IDownloadView iDownloadView){
        this.iDownloadView = iDownloadView;
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(isStart){
                iDownloadView.startDownload();
                isStart = false;
            } else if(isFinish){
                iDownloadView.finishDownload();
            } else {
                int process = msg.arg1;
                iDownloadView.downloading(process);
            }
        }
    };

    public void startDownload(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int process = 5;
                while(process <= 100){
                    Message msg = mHandler.obtainMessage();
                    msg.arg1 = process;
                    mHandler.sendMessage(msg);
                    process += 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isFinish = true;

            }
        }).start();

    }


}
