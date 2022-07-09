package clases;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	boolean ctrl=true;
		
		while (ctrl) {
		System.out.println("Sistema de gestión de biblioteca \nElija una opción:");
		System.out.println("1.- Para ingresar como usuario");
		System.out.println("2.- Para ingresar como visitante");
		System.out.println("3.- Para registrarse");
		System.out.println("9.- Para salir");
		
		Scanner teclado = new Scanner(System.in);
		int res = teclado.nextInt();
		switch (res) {
			case 1: System.out.println("Ingresar como usuario");
					break;
			case 2: System.out.println("Ingresar como visitante");
					break;
			case 3: System.out.println("Ingresar datos para registrarse");
					break;
			case 9:
				ctrl = false;
				break;
			}
		}
		
		
	}

}
