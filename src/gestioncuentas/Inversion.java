package gestioncuentas;

public class Inversion {

	double porcentaje;

	public Inversion(double porcentaje) {
		this.porcentaje = porcentaje;
		
	}

	@Override
	public String toString() {
		return "\nPorcentaje de inversion sobre los ingresos: " + porcentaje + "%";
	}
}
