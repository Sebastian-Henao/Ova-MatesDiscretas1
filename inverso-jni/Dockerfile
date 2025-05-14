FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y libjson-c-dev && apt-get clean && rm -rf /var/lib/apt/lists/*

# Registrar la ruta /usr/lib para que el linker encuentre libcjson.so.1
RUN apt-get update && \
    apt-get install -y libjson-c-dev && \
    ln -s /usr/lib/x86_64-linux-gnu/libjson-c.so /usr/lib/x86_64-linux-gnu/libcjson.so.1 && \
    echo "/usr/lib/x86_64-linux-gnu" > /etc/ld.so.conf.d/libjson.conf && \
    ldconfig && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

COPY target/inverso-jni-0.0.1-SNAPSHOT.jar /app.jar
COPY libinv.so /usr/lib/

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.library.path=/usr/lib", "-jar", "/app.jar"]
