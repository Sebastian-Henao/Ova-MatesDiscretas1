FROM openjdk:17-slim-bullseye

# Instalar GCC y cJSON
RUN apt-get update && \
    apt-get install -y gcc libcjson-dev make && \
    apt-get clean

# Crear directorio de trabajo
WORKDIR /app

# Copiar archivos fuente al contenedor
COPY . /app

# Compilar la biblioteca compartida desde C
RUN gcc -c -fPIC -I/usr/local/openjdk-17/include -I/usr/local/openjdk-17/include/linux libinverso/libinverso_JavaInverso.c -o libinverso_JavaInverso.o && \
    gcc -shared -o libinv.so libinverso_JavaInverso.o -lcjson

# Establecer la librería en el path
ENV LD_LIBRARY_PATH=/app/libinverso

# Compilar la aplicación Java
RUN javac aplicacion/Aplicacion.java libinverso/JavaInverso.java

# Ejecutar la aplicación Java
CMD ["java", "-Djava.library.path=/app/libinverso", "aplicacion.Aplicacion"]

