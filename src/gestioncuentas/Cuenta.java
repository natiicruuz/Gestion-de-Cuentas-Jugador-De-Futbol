package gestioncuentas;

import java.util.*;

public class Cuenta { // Aca se gestionan los movimento de ingresos y gastos
	
	
	private double saldo;
	private List<Gastos> gastos; // Lista de gastos
	private List<Ingreso> ingresos; // Lista de ingresos
	private List<Bonos> bonos;
	private List<Filantropia> filantropia;
	private List<Ahorros> ahorros;
	private List<Inversion> inversion;

	
	private static Scanner scanner = new Scanner(System.in);

	private static String tipoBonoString = "";
	private static int tipoBonoInt = -1;
	private static boolean bonoAceptado = false;

	private static String tipoAporteString = "";
	private static int tipoAporteInt = -1;
	private static boolean aporteAceptado = false;
	private static double porcentajeFilantropiaBasadoEnSaldo = 0;
	
	private static String tipoAhorroString = "";
	private static double tipoAhorroDouble = -1;
	private static boolean ahorroAceptado = false;
	private static double porcentajeAhorroBasadoEnSaldo = 0;

	private static String tipoInversionString = "";
	private static double tipoInversionDouble = -1;
	private static boolean inversionAceptada = false;
	private static double porcentajeInversionBasadoEnSaldo = 0;


	public Cuenta(double saldo) { // Constructor
		this.saldo = 0;// el saldo inicial es 0
		this.gastos = new ArrayList<Gastos>();
		this.ingresos = new ArrayList<Ingreso>();
		this.bonos = new ArrayList<Bonos>();
		this.filantropia = new ArrayList<Filantropia>();
		this.ahorros = new ArrayList<Ahorros>();
		this.inversion = new ArrayList<Inversion>();
		
	}
	
	
	// establece el saldo de la cuenta recibiendo por parámetro un valor llamado
	// saldo
	public void setSaldo(double saldo) {
		this.saldo = saldo;

	}

	// devuelve el saldo de la cuenta
	public double getSaldo() {
		return saldo;
	}

	// Devuelve la lista de gastos
	public List<Gastos> getGastos() {
		return gastos;
	}

	// Devuelve la lista de ingresos
	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	// Devuelve la lista de Bonos
	public List<Bonos> getBonos() {
		return bonos;
	}

	public List<Filantropia> getFilantropia() {
		return filantropia;

	}
	
	public List<Ahorros> getAhorros() {
		return ahorros;
	}
	
	
	public List<Inversion> getInversion() {
		return inversion;
	}

	

	// Agrega un ingreso a la lista.
	public double addIngresos(double cantidad, String descripcion, int fecha) {

		// Se crea el ingreso y se pasa el importe y la descripcion.
		Ingreso nuevoIngreso = new Ingreso(cantidad, descripcion, fecha);
		// Se agrega el nuevoIngreso a la lista "ingresos"
		this.ingresos.add(nuevoIngreso);
		// Se suma el saldo
		this.saldo = this.saldo + cantidad;
		// se devuelve el saldo
		return saldo;
	}

	public double addGastos(double cantidad, String descripcion, int fecha) {

		try {
			// Se resta el saldo
			this.saldo = this.saldo - cantidad;

			if (this.getSaldo() < 0) { // Si al restar da menor que 0 vamos al bloque de catch
				throw new ExcepcionDeGastos();
			}
		} catch (ExcepcionDeGastos e) {
			return -1;
		}

		// Si no pasa por el bloque de catch, sigue aca abajo

		Gastos nuevoGasto = new Gastos(cantidad, descripcion, fecha); // Se crea el ingreso y se pasa el importe y la
																		// descripcion.

		this.gastos.add(nuevoGasto); // Se agrega el nuevoGasto a la lista "gastos"

		return saldo; // se devuelve el saldo
	}

	// ----------------------------------------------------//

	public double addBonos() {

		do {

			try {
				System.out.println("Ingrese el tipo de bono: \n" + "\n(1) Campeon Goleador"
						+ "\n(2) Campeon con el equipo" + "\n(3) Campeon con el pais" + "\n(4) Bola de plata\n ");

				tipoBonoString = scanner.nextLine();
				tipoBonoInt = Integer.parseInt(tipoBonoString);

			} catch (Exception e) {
				System.out.println("La opcion elegida debe ser un numero entre 1 y 4");
				bonoAceptado = false;
			}

			if (tipoBonoInt == 1) {
				saldo = ((saldo * 5) / 100) + saldo;

				Bonos nuevoBono = new Bonos("Campeon Goleador", "5.0% ");
				this.bonos.add(nuevoBono);

				bonoAceptado = true;

			}

			else if (tipoBonoInt == 2) {
				saldo = ((saldo * 10) / 100) + saldo;

				Bonos nuevoBono = new Bonos("Campeon con el equipo", "10.0%");
				this.bonos.add(nuevoBono);

				bonoAceptado = true;
			}

			else if (tipoBonoInt == 3) {
				saldo = 40000 + saldo;

				Bonos nuevoBono = new Bonos("Campeon con el pais", "40000");
				this.bonos.add(nuevoBono);

				bonoAceptado = true;
			}

			else if (tipoBonoInt == 4) {
				saldo = 20000 + saldo;

				Bonos nuevoBono = new Bonos("Bola de plata", "20000");
				this.bonos.add(nuevoBono);

				bonoAceptado = true;
			}

		} while (bonoAceptado == false);

		System.out.println("Bono ingresado correctamente.");

		return saldo;
	}

	public double addFilantropia() {

		do {

			try {
				System.out.println("Ingrese el tipo de aporte filantropico: \n(1) Donacion Anual\n(2) Evento especial\n ");

				tipoAporteString = scanner.nextLine();
				tipoAporteInt = Integer.parseInt(tipoAporteString);

			} catch (Exception e) {
				System.out.println("La opcion elegida debe ser un numero entre 1 y 2");
				aporteAceptado = false;
			}

			if (tipoAporteInt == 1) {
				
				porcentajeFilantropiaBasadoEnSaldo = saldo * 0.05;
				saldo = saldo - porcentajeFilantropiaBasadoEnSaldo ;

				Filantropia nuevoAporte = new Filantropia("Donacion Anual", "5% ");
				this.filantropia.add(nuevoAporte);

				aporteAceptado = true;


			}

			else if (tipoAporteInt == 2) {
				
				porcentajeFilantropiaBasadoEnSaldo = saldo * 0.03;
				saldo = saldo - porcentajeFilantropiaBasadoEnSaldo ;

				Filantropia nuevoAporte = new Filantropia("Evento Especial", "3% ");
				this.filantropia.add(nuevoAporte);

				aporteAceptado = true;
			}

		} while (aporteAceptado == false);

		System.out.println("Aporte Filantropico ingresado correctamente.");

		return saldo;

	}

	public double addAhorros() {

		do {

			try {
				System.out.println("Ingrese el porcentaje del ahorro");

				tipoAhorroString = scanner.nextLine();
				tipoAhorroDouble = Integer.parseInt(tipoAhorroString);
				
				
			} catch (Exception e) {
				System.out.println("La opcion elegida debe ser un numero valido.");
				ahorroAceptado = false;
			}
			
			
			porcentajeAhorroBasadoEnSaldo = saldo * (tipoAhorroDouble/100);
			
			
			Ahorros nuevoAhorro = new Ahorros(tipoAhorroDouble);
			this.ahorros.add(nuevoAhorro);
			
			System.out.println("El porcentaje ingresado ("+tipoAhorroDouble+"%) en terminos de dinero es: "+porcentajeAhorroBasadoEnSaldo);
			
			saldo = saldo - porcentajeAhorroBasadoEnSaldo;
			ahorroAceptado = true;
			
		} while (ahorroAceptado == false);

		System.out.println("Ahorro ingresado correctamente.");

		return saldo;

	}
	
	public double addInversion() {
		do {

			try {
				System.out.println("Ingrese el porcentaje de inversion: ");

				tipoInversionString = scanner.nextLine();
				tipoInversionDouble = Integer.parseInt(tipoInversionString);
				
				
			} catch (Exception e) {
				System.out.println("La opcion elegida debe ser un numero valido.");
				inversionAceptada = false;
			}
			
			
			porcentajeInversionBasadoEnSaldo = saldo * (tipoInversionDouble/100);
			
			
			Inversion nuevaInversion = new Inversion(tipoInversionDouble);
			this.inversion.add(nuevaInversion);
			
			System.out.println("El porcentaje ingresado ("+tipoInversionDouble+"%) en terminos de dinero es: "+porcentajeInversionBasadoEnSaldo);
			
			saldo = saldo - porcentajeInversionBasadoEnSaldo;
			inversionAceptada = true;
			
		} while (inversionAceptada == false);

		System.out.println("Inversion ingresada correctamente.");

		return saldo;
	}
	// ----------------------------------------------------//

	// Imprime saldo total
	@Override
	public String toString() {
		return "El saldo de tu cuenta es: " + this.saldo;
	}
}