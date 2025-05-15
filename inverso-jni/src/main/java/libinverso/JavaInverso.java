package libinverso;

/**
 *  Clase que representa las funciones de la biblioteca dinamica JNI
 */
public class JavaInverso {
    public native String inversoJSON(int a, int m);

    public JavaInverso() {
        try{
            System.loadLibrary("inv");
            System.out.println("Biblioteca cargada exitosamente!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Carga de la biblioteca fallida: " + e.getMessage());
        }
    }
}
