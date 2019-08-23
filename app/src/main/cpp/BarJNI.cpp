#include "Bar.hpp"
#include "jni.h"

extern "C"
jint Java_org_paleozogt_openmptest_Bar_doBar(JNIEnv *env, jobject jobj) {
    return doBar();
}
