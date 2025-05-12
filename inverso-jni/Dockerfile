FROM openjdk:23
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=targer/inverso-jni-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
COPY libinv.so /lib64
ENV LD_LIBRARY_PATH=/usr/local/lib/jni:$LD_LIBRARY_PATH
ENTRYPOINT ["java", "-jar", "app.jar"]
