package gestioncuentas;

public class ExcepcionDeGastos extends Exception{
    private String error="";


	public ExcepcionDeGastos() {
		 this.error="No hay saldo suficiente para poder generar el cobro.";
	}
	
	@Override
    public String getMessage(){
        return error;
    }    

}
