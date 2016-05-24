package com.example.taotao.aidl_demo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by taotao on 16-5-24.
 */
public class MusicService extends Service {

    private IMusicPlay.Stub mBinder = new IMusicPlay.Stub() {
        @Override
        public String next() throws RemoteException {
            return "播放下一手";
        }

        @Override
        public void play() throws RemoteException {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                public void run() {
                    Toast.makeText(MusicService.this, "play,play", Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public void pause() throws RemoteException {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                public void run() {
                    Toast.makeText(MusicService.this, "pause,pause", Toast.LENGTH_SHORT).show();
                }
            });


        }
    };

    private static final String TAG = "tt";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }



    public void onDestroy()
    {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent)
    {
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent)
    {
        Log.e(TAG, "onRebind");
        super.onRebind(intent);
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
