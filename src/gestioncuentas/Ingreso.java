package gestioncuentas;

public class Ingreso extends Dinero {
	
	// Atributos de Ingreso
	
	public Ingreso(double dinero, String descripcion, int fecha) { //Constructor que recibe 3 parametros
		this.dinero = dinero;
		this.descripcion = descripcion;
		this.fecha = fecha;
		
	}
	
	
	

	@Override
	public String toString() {
		return "\nDescripcion del ingreso: " + this.descripcion + "\n Monto: " + this.dinero
				+ "\n A\u00F1o: "+this.fecha+"\n";
	}
}
