#include "Foo.hpp"
#include "jni.h"

extern "C"
jint Java_org_paleozogt_openmptest_Foo_doFoo(JNIEnv *env, jobject jobj) {
    return doFoo();
}
