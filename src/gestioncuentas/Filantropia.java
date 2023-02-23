package gestioncuentas;

public class Filantropia {
	
	String porcentaje;
	String tipoAporte;
	
	public Filantropia(String tipoAporte,String porcentaje) {
		this.tipoAporte = tipoAporte;
		this.porcentaje = porcentaje;
		
	}

	@Override
	public String toString() {
		return "\nTipo de aporte: "+ tipoAporte + "\nPorcentaje del aporte filantropico sobre los ingresos: " + porcentaje;
	}
	
	


}
