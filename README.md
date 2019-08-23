
Android's NDK OpenMP implementation has a problem.

If you have two NDK .so's that both use OpenMP, it will crash.

NDK [issue 1028](https://github.com/android-ndk/ndk/issues/1028) documents the problem.

This project reproduces the problem by having a libFoo and libBar that are called into
with JNI.  In the app gui, tap on the "FOO" or "BAR" buttons.

