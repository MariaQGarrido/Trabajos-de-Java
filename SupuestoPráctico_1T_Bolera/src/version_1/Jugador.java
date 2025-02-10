/**
 * 
 */
package version_1;

 /*
  * 
  * 
  * */
public class Jugador {
	private String nombre;
	private int[] puntos;
	private String[] puntosLetra;

	public String getJugador() {
		return nombre;
	}

	public void setJugador(String jugador) {
		this.nombre = jugador;

	}

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntos = new int[PartidaBolos.NUMERO_RONDAS];
		this.puntosLetra = new String[PartidaBolos.NUMERO_RONDAS];
	}

	public void jugarTurno(int turno) {
		int bolos = (int) (Math.random() * 11);
		puntos[turno] = bolos;
		System.out.println(nombre + " ha tirado " + puntos[turno] + " bolos");

	}

	public int calcularPuntuacion() {
		int puntuacionTotal = 0;

		for (int i = 0; i < puntos.length; i++) {
			puntuacionTotal = puntuacionTotal + puntos[i];

			if (puntos[i] == 10) {
				puntosLetra[i].equals("X");
				puntuacionTotal = puntuacionTotal + 10;
			}

		}
		return puntuacionTotal;

	}

	public void mostrarPuntuacion() {
		System.out.println();
		System.out.println("Los bolos tirados en cada ronda de " + nombre + " son: ");
		System.out.print("[ ");
		for (int i = 0; i < puntos.length; i++) {
			System.out.print(puntos[i] + " ");
		}
		System.out.println("]");

		System.out.print("[ ");

		for (int i = 0; i < puntosLetra.length; i++) {

			if (puntos[i] == 10) {
				puntosLetra[i] = "X";
			} else {
				puntosLetra[i] = "-";

			}
			System.out.print(puntosLetra[i] + " ");
		}

		System.out.println("]");

	}

	public String toString() {
		return nombre;
	}

}
