package com.study.br.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import com.study.br.R;

/**
 * Created by adventurer on 17-1-7.
 */

public class StatusBarCompat {
    private static final int INVALID_VAL = -1;

    public static View compat(Activity activity,int statusColor){
        int color = ContextCompat.getColor(activity, R.color.colorPrimaryDark);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            if(statusColor != INVALID_VAL){
                color = statusColor;
            }
            activity.getWindow().setStatusBarColor(color);
            return null;
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
            if(statusColor != INVALID_VAL){
                color = statusColor;
            }
            View statusBarView = contentView.getChildAt(0);
            if(statusBarView != null && statusBarView
                    .getMeasuredHeight() == getStatusBarHeight(activity)){
                statusBarView.setBackgroundColor(color);
                return statusBarView;
            }
            statusBarView = new View(activity);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(activity));
            statusBarView.setBackgroundColor(color);
            contentView.addView(statusBarView,lp);
            return statusBarView;
        }
        return null;
    }

    public static void compat(Activity activity){
        compat(activity,INVALID_VAL);
    }


    public static int getStatusBarHeight(Context context){
        int result = 0;
        int resourseId = context.getResources().getIdentifier("status_bar_height","dimen","android");
        if(resourseId > 0){
            result = context.getResources().getDimensionPixelSize(resourseId);
        }
        return result;

    }

}
