package com.example.taotao.mvp_study.model;

import com.example.taotao.mvp_study.model.impl.DownloadModelImpl;

/**
 * Created by taotao on 16-5-30.
 */

public interface IDownloadModel {


    void startDownload(DownloadModelImpl.DownloadListener listener);
}
