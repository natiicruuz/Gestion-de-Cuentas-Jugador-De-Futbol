package gestioncuentas;

public class Ahorros {

	
	double porcentaje;
	
	public Ahorros(double porcentaje) {
		this.porcentaje = porcentaje;
		
	}

	@Override
	public String toString() {
		return "\nPorcentaje del ahorro sobre los ingresos: " + porcentaje+"%\n";
	}
	
}
