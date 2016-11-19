package com.example.taotao.mvp_study;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.taotao.mvp_study.presenter.DownloadPresenter;
import com.example.taotao.mvp_study.view.IDownloadView;

public class MainActivity extends Activity implements IDownloadView{

    private DownloadPresenter presenter;
    private ProgressBar pb_progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new DownloadPresenter(this);
    }

    private void initView() {
        pb_progress = (ProgressBar) findViewById(R.id.pb_process);
        pb_progress.setMax(100);
        pb_progress.setProgress(0);
    }

    @Override
    public void startDownload() {
        Toast.makeText(this,"开始下载...",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void downloading(int process) {
        pb_progress.setProgress(process);

    }

    @Override
    public void finishDownload() {
        Toast.makeText(this,"下载完成",Toast.LENGTH_SHORT).show();
    }

    public void download(View view){
        presenter.startDownload();

    }

}
