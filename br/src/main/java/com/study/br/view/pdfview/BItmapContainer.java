package com.study.br.view.pdfview;

import android.graphics.Bitmap;

/**
 * Created by adventurer on 16-12-14.
 */

public interface BItmapContainer {

    Bitmap get(int position);

    void remove(int position);

    void clear();

}
