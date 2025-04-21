package aplicacion;

import libinverso.JavaInverso;

public class Aplicacion {

    // Declaramos un objeto que representa la clase JavaInverso
    JavaInverso inversor = null;

    // Cargar la librería compartida generada (libinverso.so o inverso.dll)
    static {
        System.loadLibrary("inv");
    }

    public Aplicacion() {
        this.inversor = new JavaInverso();

        // Aquí puedes probar varios casos
        int a = 3;
        int m = 7;

        int resultado = inversor.inverso(a, m);

        if (resultado == 0) {
            System.out.println("No existe inverso de " + a + " mod " + m);
        } else {
            System.out.println("El inverso de " + a + " mod " + m + " es: " + resultado);
        }
    }

    public static void main(String[] args) {
        new Aplicacion();
    }
}
