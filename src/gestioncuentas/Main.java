package gestioncuentas;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	// Varibale que almacenara la opcion que el user ingrese, ya sea
	// ingresos,gastos...
	private static String opcion = " ";
	private static byte opcionByte = -1;

	// VARIABLES DE METODO INTRODUCIR INGRESO
	private static String nuevoImporte; // Variable para guardar el nuevo importe String
	private static double nuevoImporteDouble; // Variable para guardar el nuevo importe double
	private static boolean datoAcceptado = false;
	private static String descripcionNuevoIngreso = "";
	private static String fechaNuevoIngreso;
	private static int fechaNuevoIngresoInt;

	private static String tipoIngreso = "";
	private static int tipoIngresoInt = -1;

	private static String tipoContrato = "";
	private static boolean contratoAceptado = false;

	private static Cuenta miCuenta = new Cuenta(nuevoImporteDouble);

	// VARIBALES DE METODO INTRODUCIR GASTO
	private static String gasto = "";
	private static double gastoDouble = 0;
	private static String descripcionNuevoGasto = "";
	private static String fechaNuevoGasto;
	private static int fechaNuevoGastoInt;

	private static String tipoGasto = "";
	private static int tipoGastoInt = -1;

	// -------------------------//
	// Movimientos visual

	public static ArrayList<String> listaMovimientos = new ArrayList<String>();

	public static ArrayList<String> getMovimientos() {
		return listaMovimientos;
	}

	// -----------------------------------//
	static IngresosVisual ingresoVisual = new IngresosVisual();
	static MovimientosVisual movim = new MovimientosVisual();
	// -------------------------------------//

	public static void menuPrincipal() {

		// mostrar las opciones siempre que las condiciones del while se cumplan.

		do {
			opcion = ""; // Reinciamos variable "opcion"

			System.out.println("\n1.Introducir nuevo ingreso");
			System.out.println("2.Introducir Bono");
			System.out.println("3.Introducir nuevo gasto");
			System.out.println("4.Introducir nuevo ahorro");
			System.out.println("5.Introducir nueva inversion");
			System.out.println("6.Introducir aporte de Filantropia");
			System.out.println("7.Mostrar balance completo");
			System.out.println("8.Mostrar saldo");
			System.out.println("9.Salir\n");

			try { // Intentamos pasar de String a int
				System.out.println("Seleccione una opcion: ");
				opcion = scanner.nextLine();
				opcionByte = Byte.parseByte(opcion);

			} catch (NumberFormatException e) { // Si no, muestra exception
				System.out.println("La opcion elegida debe ser un numero entre 1 y 9");
				JOptionPane.showMessageDialog(null, "La opcion elegida debe ser un numero entre 1 y 9");
			}

		} while (opcionByte < 0 && opcionByte > 9);

	}

	public static void introducirIngresos() { // Metodo para introducir ingresos

		// REINICIAR VARIBALES

		nuevoImporte = "";
		nuevoImporteDouble = 0;
		datoAcceptado = false;
		descripcionNuevoIngreso = "";
		fechaNuevoIngreso = " ";
		tipoIngresoInt = 0;

		// Do while - es para que se pueda desplegar la opcion de
		// ingresar un nuevo monto sin que se termine el programa

		// Valor de ingreso
		
		do {
			System.out.println("Por favor introduzca el ingreso: ");
			nuevoImporte = scanner.nextLine();

			try {
				nuevoImporteDouble = Double.parseDouble(nuevoImporte);
				datoAcceptado = true;

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El valor del ingreso debe ser numerico.");
				System.out.println("El valor del ingreso debe ser numerico.");
				datoAcceptado = false;
			}

		} while (nuevoImporte.isEmpty() || nuevoImporte == " " || datoAcceptado == false);

		// Descripcion de ingreso
		do {

			do {
				System.out.println("Seleccione el tipo de ingreso: ");
				System.out.println("1.Ingreso por contrato");
				System.out.println("2.Ingreso por publicidad");

				try {
					tipoIngreso = scanner.nextLine();
					tipoIngresoInt = Integer.parseInt(tipoIngreso);
					datoAcceptado = true;

				} catch (Exception e) {
					System.out.println("La opcion elegida debe ser un numero entre 1 y 3");
					datoAcceptado = false;
				}

			} while (tipoIngresoInt < 0 || tipoIngreso.isEmpty() || datoAcceptado == false);

			switch (tipoIngresoInt) {

			case 1:
				ingresoPorContratos(); // Creamos una nueva clase porque los contratos
				break; // se dividen en 2(anual,multianual)

			case 2:
				descripcionNuevoIngreso = "Contrato de Publicidad";

				break;

			default:
				System.out.println("La opcion elegida debe ser un numero entre 1 y 2");
				break;
			}

		} while (descripcionNuevoIngreso.isEmpty());

		// Ingresar fecha
		do {
			System.out.println("Agregue el a\u00F1o(o la cantidad de a\u00F1os) del ingreso: ");
			fechaNuevoIngreso = scanner.nextLine();
			fechaNuevoIngresoInt = Integer.parseInt(fechaNuevoIngreso);

		} while (fechaNuevoIngreso.isEmpty());

		// Agregamos el ingreso a la lista
		miCuenta.addIngresos(nuevoImporteDouble, descripcionNuevoIngreso, fechaNuevoIngresoInt);
		System.out.println("Monto ingresado correctamente.\n");

	}

	public static void ingresoPorContratos() {

		// Pedimos el tipo de contrato siempre que contratoAceptado == false
		do {
			System.out.println("Ingrese el tipo de contrato anual(a) o multianual(m): ");
			tipoContrato = scanner.nextLine();

			// Ponemos dos tipos de formas en la que el cliente puede ingresar la opcion
			// deseada
			// Mayuscula o minuscula. En caso contrario, repetira el bucle do-while

			if (tipoContrato.equals("a") || tipoContrato.equals("A")) {
				descripcionNuevoIngreso = "Contrato Anual";
				contratoAceptado = true;

			}

			else if (tipoContrato.equals("m") || tipoContrato.equals("M")) {
				descripcionNuevoIngreso = "Contrato Multianual";
				contratoAceptado = true;
			}

		} while (contratoAceptado == false);
	}

	public static void introducirGastos() { // Metodo para introducir gastos

		datoAcceptado = false; // Reiniciamos variable "datoAcceptado"
		descripcionNuevoGasto = "";
		fechaNuevoGasto = " ";

		do {
			System.out.println("Por favor introduzca el nuevo gasto: ");
			gasto = scanner.nextLine();

			try {// Intentamos pasar el valor a double
				gastoDouble = Double.parseDouble(gasto);
				datoAcceptado = true;

			} catch (NumberFormatException e) { // Si no es un valor que se pueda convertir a double,
				System.out.println("El valor ingresado debe ser numerico");// muestra exception

			}

		} while (gasto.isEmpty() || datoAcceptado == false);

		// Si la cuenta esta vacia, imprimir:
		if (miCuenta.getSaldo() == 0 || miCuenta.getSaldo() < gastoDouble) {

			System.out.println(
					"Primero se debe realizar un ingreso para poder registrar un gasto o \nel valor que ingresaste es mayor a la cantidad en la cuenta.\n");
			System.out.println("Tu saldo actual es: " + miCuenta.getSaldo());

		} else {

			// Mostramos los tipos de gastos mientras que la descripcion(tipo) este vacia
			do {

				do {
					System.out.println("Seleccione el tipo de gasto: ");
					System.out.println("1.Perdida por impuesto");
					System.out.println("2.Perdida por multas");
					System.out.println("3.Perdida por inactividad");

					try { // Intentamos pasar de String a int
						tipoGasto = scanner.nextLine();
						tipoGastoInt = Integer.parseInt(tipoGasto);
						datoAcceptado = true;

					} catch (Exception e) { // Si no se puede pasar a int, mostrar exception
						System.out.println("La opcion elegida debe ser un numero entre 1 y 3");
						datoAcceptado = false;
					}

					// mostrar menu de tipos de gastos mientras que estas condiciones sucedan
				} while (tipoGastoInt < 0 || tipoGasto.isEmpty() || datoAcceptado == false);

				// Switch- case para cada uno de los tipos de gastos

				switch (tipoGastoInt) {

				case 1:
					descripcionNuevoGasto = "Perdida por impuestos"; // Aca declaramos el valor (tipo)de
					break; // la descripcion del gasto

				case 2:
					descripcionNuevoGasto = "Perdida por multas";
					break;
				case 3:
					descripcionNuevoGasto = "Perdida por inactividad";
					break;

				default:
					System.out.println("La opcion elegida debe ser un numero entre 1 y 3");
					break;
				}

			} while (descripcionNuevoGasto.isEmpty());

			// Ingresar fecha
			do {
				System.out.println("Agregue el a\u00F1o de la perdida: ");
				fechaNuevoGasto = scanner.nextLine();
				fechaNuevoGastoInt = Integer.parseInt(fechaNuevoGasto);

			} while (fechaNuevoGasto.isEmpty());

			// Agregamos el gasto a la lista
			miCuenta.addGastos(gastoDouble, descripcionNuevoGasto, fechaNuevoGastoInt);

			System.out.println("Gasto ingresado correctamente.\n");

		}

	}

	public static void mostrarSaldo() {// Mostrar solo saldo de la cuenta
		System.out.println("El saldo total de tu cuenta es: " + miCuenta.getSaldo());
		String mostrarSaldoEnVisual = miCuenta.toString();
		JOptionPane.showMessageDialog(null, mostrarSaldoEnVisual);

	}

	public static void mostrarMovimientos() {// Muestra el balance de la cuenta

		if (!miCuenta.getIngresos().isEmpty()) { // Si miCuenta NO esta vacia entonces mostrar los movimientos

			// Mostramos toda la lista de ingresos
			System.out.println("INGRESOS");
			for (int i = 0; i < miCuenta.getIngresos().size(); i++) {
				String ingreso = miCuenta.getIngresos().get(i).toString();
				System.out.println(ingreso);
				listaMovimientos.add(ingreso);
			}
			
				// Mostramos toda la lista de gastos (perdidas)
			System.out.println("PERDIDAS");
			for (int j = 0; j < miCuenta.getGastos().size(); j++) {
				String gasto = miCuenta.getGastos().get(j).toString();
				System.out.println(gasto);
				listaMovimientos.add(gasto);

			}

				// Mostramos toda la lista de bonos
			System.out.println("BONOS");
			for (int k = 0; k < miCuenta.getBonos().size(); k++) {
				String bonos = miCuenta.getBonos().get(k).toString();
				System.out.println(bonos);
				listaMovimientos.add(bonos);

			}

			System.out.println("AHORROS");
			for (int l = 0; l < miCuenta.getAhorros().size(); l++) {
				String ahorros = miCuenta.getAhorros().get(l).toString();
				System.out.println(ahorros);
				listaMovimientos.add(ahorros);

			}

			System.out.println("INVERSIONES");
			for (int m = 0; m < miCuenta.getInversion().size(); m++) {

				String inversiones = miCuenta.getInversion().get(m).toString();
				System.out.println(inversiones);
				listaMovimientos.add(inversiones);

			}

			// Mostramos toda la lista de aportes de filantropia
			System.out.println("APORTES FILANTROPICOS");
			for (int u = 0; u < miCuenta.getFilantropia().size(); u++) {
				String filantropia = miCuenta.getFilantropia().get(u).toString();
				System.out.println(filantropia);
			}
			
		}else { // Si no hay ningun dato en la cuenta imprimimos:
			System.out.println("No hay movimientos en esta cuenta.");
		}
	
	}

	public static void main(String[] args) {

		System.out.println("Gestion de cuentas personal");
		System.out.println("----------------------------");

		do {
			VisualMain visualMain = new VisualMain();
			visualMain.setVisible(true);
			menuPrincipal();
			switch (opcionByte) {

			case 1: // Introducir nuevo ingreso

				introducirIngresos();
				break;

			case 2:
				miCuenta.addBonos();
				break;

			case 3:// Introducir nuevo gasto
				introducirGastos();
				break;

			case 4: // Introducir nuevo ahorro
				miCuenta.addAhorros();
				break;

			case 5: // Introducir nueva inversion
				miCuenta.addInversion();
				break;

			case 6:
				miCuenta.addFilantropia();
				break;

			case 7: // Mostrar movimientos(INGRESOS, EGRESOS, **AHORROS**)
				mostrarMovimientos();
				break;

			case 8: // // Mostrar registro general ACA MUESTRO TOTAL DEL SALDO " TIENES XX EN LA
				// TARJETA"

				mostrarSaldo();
				break;
			case 9:
				System.out.println("Programa finalizado. Gracias por utilizar la aplicacion.");
				break;

			default: // Con cualquier otro número, muestra un mensaje
				System.out.println("Introduce el valor correcto");
				break;
			}

			visualMain.setVisible(false);
		} while (opcionByte != 9);

		scanner.close();
	}
}
