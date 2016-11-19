package com.example.taotao.mvp_study.view;

/**
 * Created by taotao on 16-5-27.
 */
public interface IDownloadView {

    void startDownload();

    void downloading(int process);

    void finishDownload();

}
