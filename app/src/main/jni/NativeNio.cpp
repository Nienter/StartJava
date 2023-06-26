#include <jni.h>

//
// Created by niu on 2022/2/25.
//


extern "C"
JNIEXPORT jstring JNICALL
Java_com_myjava_javatest_hello_Nie_sayNie(JNIEnv *env, jobject thiz) {
    // TODO: implement sayNie()
    return env->NewStringUTF("nit");
}