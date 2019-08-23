package org.paleozogt.openmptest;

public class Foo {
    public static void init() {
        System.loadLibrary("fooJNI");
    }

    public Foo() {
        init();
    }

    public native int doFoo();
}
