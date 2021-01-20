import java.util.ArrayList;

public class radio {
	private boolean FmOAm;//False indica que esta en Fm; True, Am.
	private boolean energia;//False indica que esta apagado; True, encendido.  
	private String emisoraEnReproduccion; 
	private ArrayList<emisoras> listaEmisorasFav; 
	public void radio() {
		listaEmisorasFav = new ArrayList<emisoras>(); 
		energia=false; 
		FmOAm =false; 
		emisoraEnReproduccion= "87.9";
		
	}
	
}
