#include<jni.h>
#include<stdio.h>
#include<stdlib.h>
#include<cjson/cJSON.h>
#include"libinverso_JavaInverso.h"

int mcd(int a, int b){
	int r;
	while(b != 0){
		r = a % b;
		a = b;
		b = r;
		}
	return a;
}

int calcularInverso(int a, int m) {
	int r, q, x0 = 1, x1 = 0, temp;
	int original_m = m;

	while (m != 0) {
		q = a / m;
		r = a % m;
		temp = x1;
		x1 = x0 - q * x1;
		x0 = temp;
		a = m;
		m = r;
	}

	if (x0 > 0) {
		x0 = x0 - original_m;
	}
	return x0;
}

JNIEXPORT jstring JNICALL Java_libinverso_JavaInverso_inversoJSON
  (JNIEnv *env, jobject obj, jint a, jint m){
	int inverso = 0;
	if (mcd(a, m) == 1) {
		inverso = calcularInverso(a, m);
	}

	cJSON *root = cJSON_CreateObject();
	cJSON_AddNumberToObject(root, "a", a);
	cJSON_AddNumberToObject(root, "m", m);

	if (inverso != 0) {
		cJSON_AddNumberToObject(root, "inverso", inverso);
	} else {
		cJSON_AddStringToObject(root, "error", "No existe inverso");
	}

	char *jsonString = cJSON_PrintUnformatted(root);
	cJSON_Delete(root);

	jstring result = (*env)->NewStringUTF(env, jsonString);
	free(jsonString);

	return result;
}

