package com.example.taotao.aidl_demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.Image;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

public class Client extends Activity {

    private IMusicPlay iMusicPlay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
    }


    ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMusicPlay = IMusicPlay.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMusicPlay = null;
        }
    };

    public void play(View v) throws RemoteException {
        iMusicPlay.play();
    }

    public void pause(View v) throws RemoteException {
        iMusicPlay.pause();
    }
    public void next(View v) throws RemoteException {
        iMusicPlay.next();
    }



    /**
     * 点击BindService按钮时调用
     */
    public void bindService()
    {
        Log.i("tt","bindService");
        Intent intent = new Intent(this,MusicService.class);
        intent.setAction("com.example.taotao.service");
        bindService(intent, con, Context.BIND_AUTO_CREATE);
    }
    /**
     * 点击unBindService按钮时调用
     */
    public void unbindService()
    {
        Log.i("tt","unbindService");
        unbindService(con);
    }




    @Override
    protected void onStop() {
        super.onStop();
        unbindService();
    }
}
