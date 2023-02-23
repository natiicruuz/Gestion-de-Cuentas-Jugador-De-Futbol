package gestioncuentas;

public class Bonos {
	
	String porcentaje;
	String tipoBono;
	
	public Bonos(String tipoBono,String porcentaje) {
		this.tipoBono = tipoBono;
		this.porcentaje = porcentaje;
		
	}

	@Override
	public String toString() {
		return "\nTipo de bono: "+ tipoBono + "\nPorcentaje / cantidad del Bono sobre los ingresos: " + porcentaje+"\n";
	}
	
	

}
