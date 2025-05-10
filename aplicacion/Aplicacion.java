package aplicacion;

import libinverso.JavaInverso;

public class Aplicacion {
	JavaInverso inversor = null;
	static {
		System.loadLibrary("inv"); // usa libinv.so
	}

	public Aplicacion() {
		this.inversor = new JavaInverso();
		int a = 235;
		int m = 37;
		String resultadoJson = inversor.inversoJSON(a, m);
		System.out.println("Resultado en JSON: " + resultadoJson);
	}

	public static void main(String[] args) {
		new Aplicacion();
    }
}
