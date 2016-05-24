// IMusicPlay.aidl
package com.example.taotao.aidl_demo;

// Declare any non-default types here with import statements

interface IMusicPlay {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String next();
    void play();
    void pause();
}
