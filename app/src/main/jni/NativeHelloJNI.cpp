#include <jni.h>
#include <android/log.h>
#include <string.h>
#include <pthread.h>
#include <unistd.h>

//
// Created by niu on 2022/2/21.
//
#define TAG "SayHelloJNi"
#define LOGE(...) __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)


extern "C"
JNIEXPORT jstring
Java_com_myjava_javatest_hello_SayHello_sayHello(JNIEnv *env, jclass clazz) {
    // TODO: implement sayHello()
    return env->NewStringUTF("Hello Jni");
}

jstring nativeTojstring(JNIEnv *env, const char *str) {
    //定义java String类 strClass
    jclass strClass = (env)->FindClass("java/lang/String");
    //获取java String类方法String(byte[],String)的构造器,用于将本地byte[]数组转换为一个新String
    jmethodID ctorID = (env)->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");
    //建立byte数组
    jbyteArray bytes = (env)->NewByteArray((jsize) strlen(str));
    //将char* 转换为byte数组
    (env)->SetByteArrayRegion(bytes, 0, (jsize) strlen(str), (jbyte *) str);
    //设置String, 保存语言类型,用于byte数组转换至String时的参数
    jstring encoding = (env)->NewStringUTF("utf-8");
    //将byte数组转换为java String,并输出
    return (jstring) (env)->NewObject(strClass, ctorID, bytes, encoding);
}

extern "C"
JNIEXPORT jint

Java_com_myjava_javatest_hello_SayHello_sum(JNIEnv *env, jclass clazz, jint a, jint b) {
    // TODO: implement sum()
    return a + b;
}
extern "C"
JNIEXPORT void JNICALL
Java_com_myjava_javatest_hello_SayHello_callSuperInstanceMethod(JNIEnv *env, jclass clazz) {
    // TODO: implement callSuperInstanceMethod()
    jclass jclass1 = NULL;
    jmethodID jmethodId = NULL;

    jclass1 = env->FindClass("com/myjava/javatest/hello/SayHello");
    jmethodId = env->GetStaticMethodID(jclass1, "test", "(I)I");
    jint jint1 = 7;
    jint jint2 = env->CallStaticIntMethod(jclass1, jmethodId, jint1);
    LOGE("dff=%d", jint2);


    exit:
    env->DeleteLocalRef(jclass1);
}

//JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved){
//
//}
extern "C"
JNIEXPORT jintArray JNICALL
Java_com_myjava_javatest_hello_SayHello_operateIntArray(JNIEnv *env, jclass clazz) {
    // TODO: implement operateIntArray()
//    jint *intArray;
//    intArray = env->GetIntArrayElements(arrays, NULL);
//    if (intArray == NULL) {
//        return NULL;
//    }
//    const int length = env->GetArrayLength(arrays);
//    for (int i = 0; i < length; i++) {
//        LOGE("%d,", intArray[i]);
//    }
//    env->ReleaseIntArrayElements(arrays, intArray, 0);
//
    jintArray intArray_out;
    const int len_out = 10;
    intArray_out = env->NewIntArray(len_out);
    jint buf_out[len_out] = {0};
    for (int j = 0; j < len_out; j++) {
        buf_out[j] = j * 2;
    }
    env->SetIntArrayRegion(intArray_out, 0, len_out, buf_out);

    return intArray_out;
}
extern "C"
JNIEXPORT jobjectArray JNICALL
Java_com_myjava_javatest_hello_SayHello_operateStringArray(JNIEnv *env, jclass clazz) {
    // TODO: implement operateStringArray()
//    jsize  size = env->GetArrayLength()
    jclass clas = env->FindClass("java/lang/String");
    jobjectArray objectArray_out;

    char *char_out[] = {"dvfdsf", "frf", "fdsfg", "gfg"};
    const int len_out = 4;
    objectArray_out = env->NewObjectArray(len_out, clas, NULL);
    jstring temp_string;
    for (int i = 0; i < len_out; i++) {
        if (char_out[i] == NULL) {
            break;
        }
        temp_string = nativeTojstring(env, char_out[i]);
        env->SetObjectArrayElement(objectArray_out, i, temp_string);
    }
    return objectArray_out;
}
extern "C"
JNIEXPORT jobjectArray JNICALL
Java_com_myjava_javatest_hello_SayHello_operateObjectArray(JNIEnv *env, jclass clazz) {
    // TODO: implement operateObjectArray()
    jclass jclass1 = env->FindClass("com/myjava/javatest/hello/Person");
    jfieldID mAge = env->GetFieldID(jclass1, "age", "I");
    jfieldID mName = env->GetFieldID(jclass1, "name", "Ljava/lang/String;");

    jmethodID jmethodId = env->GetMethodID(jclass1, "<init>", "(ILjava/lang/String;)V");
    jobject jobject1 = env->NewObject(jclass1, jmethodId, 13, env->NewStringUTF("dgfg"));
    jobjectArray mArray_out = env->NewObjectArray(1, jclass1, NULL);
    env->SetObjectArrayElement(mArray_out, 0, jobject1);
    return mArray_out;
}
struct Person {
    int age;
    char *name;
};
extern "C"
JNIEXPORT void JNICALL
Java_com_myjava_javatest_hello_SayHello_throwException(JNIEnv *env, jclass clazz) {
    // TODO: implement throwException()
    jthrowable jthrowable1;
    jmethodID jmethodId = env->GetStaticMethodID(clazz, "callBack", "()V");
    if (jmethodId == NULL) {
        LOGE("Faileed");
        return;
    }
    env->CallStaticVoidMethod(clazz, jmethodId);
    //4.捕获异常方式一,调用ExceptionOccurred判断是否有异常发生
    jthrowable1 = env->ExceptionOccurred();
    if (env->ExceptionCheck()) {
        LOGE("ExceptionCheck has exception\n");
    }
    if (jthrowable1) {
        jclass newException;
//        //7.打印异常信息堆栈
        env->ExceptionDescribe();
        env->ExceptionClear();
        newException = env->FindClass("java/lang/IllegalArgumentException");
        if (newException == NULL) {
            LOGE("Find Class Failed");
            return;
        }
        env->ThrowNew(newException, "sorry,java");
//
    }

    env->DeleteLocalRef(jthrowable1);

}
//JNI中抛异常工具代码:
void
JNI_ThrowByName(JNIEnv *env, const char *name, const char *msg)
{
    //查找异常类
    jclass cls = env->FindClass(name);
    //判断是否找到该异常类
    if (cls != NULL) {
        env->ThrowNew(cls, msg);//抛出指定名称的异常
    }
    //释放局部变量
    env->DeleteLocalRef(cls);
}
//JNI中检测工具代码:
int checkExecption(JNIEnv *env) {
    if(env->ExceptionCheck()) {//检测是否有异常
        env->ExceptionDescribe(); // 打印异常信息
        env->ExceptionClear();//清除异常信息
        return 1;
    }
    return -1;
}
//测试代码
//if (checkExecption(env)) {//检测是否有异常
//LOGE(TAG, "jni exception happened at p1");
//JNU_ThrowByName(env, "java/lang/Exception", "exception from jni: jni exception happened at p1");//抛出异常
//return -1;
//}

JavaVM *gJavaVM =NULL;//全局JavaVM 变量
jobject gJavaObj=NULL;//全局Jobject变量
JNIEnv * gEnv=NULL;	//全局的JNIEnv变量
jmethodID nativeCallback=NULL;//全局的方法ID
jclass jclass1=NULL;
static int count = 0;
static void* native_thread_exec(void *arg)
{
    JNIEnv *env;
    //从全局的JavaVM中获取到环境变量
    gJavaVM->AttachCurrentThread(&env,NULL);
    //线程循环
    for(int i = 0 ; i < 5; i++)
    {
        usleep(2);
        //跨线程回调Java层函数
        env->CallStaticVoidMethod(jclass1,nativeCallback,count++);
    }
    gJavaVM->DetachCurrentThread();
    LOGE(TAG,"thread stoped");
    return ((void *)0);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_myjava_javatest_hello_SayHello_nativeInit(JNIEnv *env, jclass clazz) {
    // TODO: implement nativeInit()
    jclass1 = static_cast<jclass>(env->NewGlobalRef(clazz));
    nativeCallback = env->GetStaticMethodID(clazz, "onNativeCallBack", "(I)V");
    LOGE("HAFFF");
    env->GetJavaVM(&gJavaVM);
    if(gJavaVM!=NULL) {
        LOGE("HAFFF");
    }
    pthread_t id;
    LOGE("thread init");
    if(pthread_create(&id,NULL,native_thread_exec,NULL)!=0){
        LOGE("native thread create fail");
        return;
    }
//    //主线程
//    for(int i = 0 ; i < 5; i++)
//    {
//        usleep(20);
//        //跨线程回调Java层函数
//        gEnv->CallStaticVoidMethod(clazz,nativeCallback,count++);
//    }
    LOGE("native thread creat success");

}
//JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {
//    LOGE(TAG,"JNI_OnLoad\n");
//    JNIEnv* env = NULL;
//    //获取JNI_VERSION版本
//    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
//        LOGE(TAG,"checkversion error\n");
//        return -1;
//    }
//
//    //操作方式一，通过SO加载时保存全局JavaVM
//    //gJavaVM = vm;
//
//    //返回jni 的版本
//    return JNI_VERSION_1_6;
//}

