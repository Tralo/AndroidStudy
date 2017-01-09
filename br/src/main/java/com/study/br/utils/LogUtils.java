package com.study.br.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by adventurer on 17-1-9.
 */

public class LogUtils {
    private static Boolean LOG_SWITCH = true;
    private static Boolean LOG_TO_FILE = false;
    private static String LOG_TAG = "BookReader";
    private static char LOG_TYPE = 'v';
    private static int LOG_SAVE_DAYS = 7;

    private final static SimpleDateFormat LOG_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat FILE_SUFFIX = new SimpleDateFormat("yyyy-MM-dd");
    private static String LOG_FILE_PATH;
    private static String LOG_FILE_NAME;

    public static void init(Context context){
        LOG_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator
                 +
    }





}
