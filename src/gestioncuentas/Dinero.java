package gestioncuentas;

public abstract class Dinero {
	
	//Atributos
	protected double dinero;
	protected String descripcion;
	protected int fecha;
	
	
	//Metodos 
	public void setDinero(double dinero) {
        this.dinero = dinero;
    }
	
	  public double getDinero() {
	        return dinero;
	    }
	 
     
    public void setDescription(String description) {
        this.descripcion = description;
    }
 
  
    public String getDescription() {
        return descripcion;
    }
    
    public void setFecha(int fecha) {
		this.fecha = fecha;
	}
    

	public int getFecha() {
		return fecha;
	}

	
    
}
	
