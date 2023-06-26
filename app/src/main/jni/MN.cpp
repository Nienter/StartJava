#include <jni.h>

//
// Created by niu on 2022/4/17.
//


extern "C"
JNIEXPORT void JNICALL
Java_com_myjava_javatest_Mn_sayHello(JNIEnv *env, jobject thiz) {
    // TODO: implement sayHello()
    env->NewStringUTF("ff");
}