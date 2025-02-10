/**
 * 
 */
package version_2;

import java.util.Scanner;


/**
 * 
 */
public class PartidaBolos {

	/**
	 * @param args
	 */
	public static final int NUMERO_RONDAS = 10;
	public static int record = 0;// puntuacion


	public static void main(String[] args) {
		String respuesta = "";
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("¡Bienvenidos a la bolera! ¿Cómo te llamas?");
			Jugador jugador1 = new Jugador(sc.nextLine());
			System.out.println("Dime el nombre de tu segundo acompañante");
			Jugador jugador2 = new Jugador(sc.nextLine());

			for (int i = 0; i < NUMERO_RONDAS; i++) {
				System.out.println("------RONDA "+(i+1)+"------");
				jugador1.jugarTurno(i);
		
				jugador2.jugarTurno(i);
				sc.nextLine();

			}

			System.out.println();
			jugador1.mostrarPuntuacion();
			System.out.println("La puntuación total es " + jugador1.calcularPuntuacion());
			jugador2.mostrarPuntuacion();
			System.out.println("La puntuación total es " + jugador2.calcularPuntuacion());

			System.out.println();
			if (jugador1.calcularPuntuacion() > jugador2.calcularPuntuacion()) {
				System.out.println("El ganador es " + jugador1 + " con " + jugador1.calcularPuntuacion() + " puntos.");
				comprobarRecord(jugador1);
			} else {
				System.out.println("El ganador es " + jugador2 + " con " + jugador2.calcularPuntuacion() + " puntos.");
				comprobarRecord(jugador2);
			}

			System.out.println("¿Quieres volver a jugar? (s/n)");
			respuesta = sc.nextLine();

		} while (respuesta.equals("s"));

		System.out.println("Gracias por jugar");
	}

	/**
	 * @param ganador
	 */
	public static void comprobarRecord(Jugador ganador) {

		if (ganador.calcularPuntuacion() > record) {
			System.out.println("¡Nuevo record!");
			record = ganador.calcularPuntuacion();
			System.out.println(ganador + " con " + record + " puntos");
		}

	}

}
