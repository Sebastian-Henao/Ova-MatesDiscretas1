#include <jni.h>
#include "libinverso_JavaInverso.h"

int mcd(int a, int b){
    int r;
    while(b != 0){
        r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int calcularInverso(int a, int m){
    int r, q, x0 = 1, x1 = 0, temp;

    while(m != 0){
        q = a / m;

        r = a % m;
        temp = x1;
        x1 = x0 - q * x1;
        x0 = temp;

        a = m;
        m = r;
    }

    return x0;
}

// Implementación JNI
JNIEXPORT jint JNICALL Java_libinverso_JavaInverso_inverso
  (JNIEnv *env, jobject obj, jint a, jint m) {

    if (mcd(a, m) != 1) {
        return 0; // No tiene inverso, retornamos 0 (puedes usar otro valor para indicar error)
    }

    return calcularInverso(a, m);
}

