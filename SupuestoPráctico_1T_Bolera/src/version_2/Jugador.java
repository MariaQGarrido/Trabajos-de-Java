/**
 * 
 */
package version_2;

/**
 * 
 */
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
		int bolos1 = (int) (Math.random() * 11);
	
		if (bolos1 == 10) {
			puntos[turno] = 10;
			System.out.println(nombre + " ha tirado " + puntos[turno] + " bolos");
			puntosLetra[turno]="X";
		} else {
			int bolos2 = (int) (Math.random() * (11 - bolos1));
			int sumaBolos = bolos1 + bolos2;
			if (sumaBolos == 10) {
				puntos[turno] = 10;
				puntosLetra[turno]="/";
			} else {
				puntos[turno] = sumaBolos;
				puntosLetra[turno]="-";
			}
			System.out.println();
			System.out.println(nombre + " ha tirado en la primera tirada " + bolos1+" bolos");
			System.out.println(nombre + " ha tirado en la segunda tirada " + bolos2 + " bolos");
		}

	}

	public int calcularPuntuacion() {
		int puntuacionTotal = 0;

		for (int i = 0; i < puntos.length; i++) {
			puntuacionTotal = puntuacionTotal + puntos[i];

			if (puntosLetra[i].equals("X")) {
				puntuacionTotal = puntuacionTotal + 10;
			} else if (puntosLetra[i].equals("/")) {
				puntuacionTotal = puntuacionTotal + 5;
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
			

			System.out.print(puntosLetra[i] + " ");
		}

		System.out.println("]");

	}

	public String toString() {
		return nombre;
	}

}
