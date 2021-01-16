import java.util.Scanner;
import java.security.SecureRandom;


public class AdivinaElNumero {
	
	public static int orquillaNumRandom() {
		SecureRandom randNum = new SecureRandom();
		
		return randNum.nextInt(100 - 1) + 1;
	}
	
	
	public static void adivinarRandom(int numRand) {
		Scanner teclado = new Scanner(System.in);
		int intento = 6;
		int numParticipante = 0;
		for(int i = 0; i < 6; i++) {
			System.out.println("Intentos restantes " + intento + "\n" + "Introduce un numero.");
			numParticipante = teclado.nextInt();
			if(numParticipante == numRand) {
				break;
			}else if (numParticipante < numRand) {
				System.out.println("El numero es demasiado bajo");
			}else if (numParticipante > numRand) {
				System.out.println("El numero es demasiado alto");
			}
			intento -= 1;
		}
		if (numParticipante == numRand){
			System.out.println("Enhorabuena has acertado el número");
		}else {
			System.out.println("Lastima, te has quedado sin intentos, prueba de nuevo");
		}
		System.out.println("¿Deseas volver a jugar?");
		String newChance = teclado.next().toUpperCase();
		if (newChance.equals("SI")) adivinarRandom(orquillaNumRandom());
	}
	
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Hola concursante,bienvenido a Adivina el Numero");
		System.out.println("¿Deseas Participar?");
		String participarAnswer = teclado.next().toUpperCase();
		if (participarAnswer.equals("SI")) {
			System.out.println("Por favor, ¿como te llamas?");
			String nomParticipante = teclado.next();
			System.out.println("Bienvenido " + nomParticipante + " vamos a jugar" + "\n" 
					+ "Tienes 6 intentos" + "\n" + "Has de introducir un numero entre 1 y 100");
			adivinarRandom(orquillaNumRandom());
		}
		teclado.close();
	}

}
