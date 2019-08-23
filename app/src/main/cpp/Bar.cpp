#include "Bar.hpp"

#include "omp.h"
#include "android/log.h"

int doBar() {
    __android_log_print(ANDROID_LOG_DEBUG, __FUNCTION__, " ");

    #pragma omp parallel for
    for (int i = 0; i < 24; i++) {
        __android_log_print(ANDROID_LOG_DEBUG, __FUNCTION__, "idx %02d thread %02d", i, omp_get_thread_num());
    }

    return omp_get_num_threads();
}
