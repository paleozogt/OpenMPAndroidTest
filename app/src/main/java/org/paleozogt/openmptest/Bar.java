package org.paleozogt.openmptest;

public class Bar {
    public static void init() {
        System.loadLibrary("barJNI");
    }

    public Bar() {
        init();
    }

    public native int doBar();
}
