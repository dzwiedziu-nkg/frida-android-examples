#include <jni.h>
#include <string>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_testndk_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_testndk_MainActivity_logDirectBufferAddress(JNIEnv* env, jobject, jobject buf) {
    void* p = env->GetDirectBufferAddress(buf);
    jlong cap = env->GetDirectBufferCapacity(buf);

    __android_log_print(ANDROID_LOG_DEBUG, "MEMDEMO","buffer addr=%p capacity=%lld", p, (long long) cap);
}
