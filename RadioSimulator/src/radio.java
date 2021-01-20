import java.util.ArrayList;

/**
 * @author Luis P Gonzalez
 *
 */
public class radio {
	private boolean FmOAm;//False indica que esta en Fm; True, Am.
	private boolean energia;//False indica que esta apagado; True, encendido.
	private emisoras emisoraEnReproduccion;
	private ArrayList<emisoras> todasLasEmisoras;
	private ArrayList<emisoras> listaEmisorasFav;
	/**
	 * un constructor cualquiera
	 */
	public void radio() {
		listaEmisorasFav = new ArrayList<emisoras>();
		todasLasEmisoras = new ArrayList<emisoras>();
		energia=false;
		FmOAm =false;
		emisoraEnReproduccion= new emisoras("FM", 87.9);

	}
	/**
	 * Con llamar este metodo el dispositivo pasa de encendido a apagado o viceversa.
	 *
	 * Digamos que funciona cual boton de encendido de una radio analogica; si esta apagada y lo
	 * presionas se va a encender, si esta encendida y lo presionas se apaga.
	 */
	public void botonEncendido() {
		energia = !energia;
	}
	/**
	 * @param AdelanteOAtras tenes que ingresar 1 si el usuario desea avanzar en las emisoras, o
	 * -1 si desea ir hacia atras; es importante que no ingreses otro numero pues de eso depende
	 * el buen funcionamiento del metodo
	 * @param ponerCeroAqui pone un 0 aqui, confia en mi; solo agregue este parametro para poder sobreecribir el metodo abajoa
	 * en el que lo uso cambiar la emisora pero a una favorita.
	 * @return devuelve detalles de como resulto la operacion.
	 */
	public String cambiarEmisora(int AdelanteOAtras, int ponerCeroAqui) {//+1 es ir hacia delante, -1 es ir hacia atr�s
		double nuevaEstacion;
		double limiteSuperior;
		double limiteInferior;
		double cambioDeFrecuencia;
		String tipoDeEmisora;
		if(FmOAm) {//Caso True es equivalente a que este en AM
			tipoDeEmisora="AM";
			limiteSuperior=1610;
			limiteInferior=530;
			cambioDeFrecuencia=10*AdelanteOAtras;
		}else {//En caso sea una radio FM
			tipoDeEmisora="FM";
			limiteSuperior=107.9;
			limiteInferior=87.9;
			cambioDeFrecuencia=0.2*AdelanteOAtras;
		}
		nuevaEstacion= emisoraEnReproduccion.getNumeroDeEmisora()+(cambioDeFrecuencia);
		if((nuevaEstacion<=limiteSuperior)&&(nuevaEstacion>=limiteInferior)) {
			if(!(nuevaEstacion<=limiteSuperior)) nuevaEstacion=limiteInferior+(nuevaEstacion-limiteSuperior);
			if(!(nuevaEstacion>=limiteInferior)) nuevaEstacion=limiteSuperior+(nuevaEstacion-limiteInferior);
		}
		for (emisoras emisoraRegistrada:todasLasEmisoras ) {
			if(emisoraRegistrada.getNumeroDeEmisora()==nuevaEstacion) {
				return "Emisora "+ emisoraRegistrada.getNumeroDeEmisora()+" sintonizada";
			}
		}
		emisoras LaNuevaEmisora = new emisoras(tipoDeEmisora, nuevaEstacion);
		return "Emisora "+LaNuevaEmisora.getNumeroDeEmisora()+" sintonizada";


	}
	/**
	 * @param posFav
	 * @return
	 *
	 * Este metodo es directamente para poner en reproduccion una de las emisoaras favoritas
	 * El unico problema que te podria causar este es el que el usuario ingrese una posicion que
	 * esta vacia, es decir, nullpointerexception. De cualquier forma intente preverlo en la linea 85.
	 */
	public String cambiarEmisora (int posFav) {//Se ingresa la posicion favorita (numeros del 1 al 12)
		if((listaEmisorasFav.size()>=posFav)&&(posFav<=12)&&(posFav>=1)){
			posFav=posFav-1;
			if(listaEmisorasFav.get(posFav)!=null){
				emisoraEnReproduccion=listaEmisorasFav.get(posFav);
				return "Emisora cambiada a: "+emisoraEnReproduccion.getNumeroDeEmisora();
			}else return "Ups... parece que la posicion favorita que buscas esta vacia";
		}else return "Ups... parece que la posicion favorita que buscas esta vacia";

	}
	/**
	 * @param NuevaEmisoraFavorita se ingresa la emisora que se desea anadir como favorita.
	 * @param numeroDeFav se ingresa la posicion a la que se desesa ingrese la emisora (del 1 al 12)
	 * @return Devuelve String detallando el resultado de la operacion
	 * Considerar que solo procesa como posiciones correctas para agregar favoritas las siguientes: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
	 * Imaginaras que una lista toma en cuenta desde el 0 y esto puede ser problema pero esta contemplado dentro del metodo
	 * asi que no hay problema.
	 * Otra cosa importante es que en el primer parametro acepta ojetos de tipo emisoras; y pues, solo recordar que
	 * tendrias que haberlo construido ya en el main; considero que con que lo crees utilizando con el segundo constructor basta, no es necesario utilizar
	 * todas los atributos de las emisoras.
	 */
	public String GuardarComoFavorita(emisoras NuevaEmisoraFavorita, int numeroDeFav) {//Mi sugerencia para el main sobre esto
		//seria ponerle como parametro la emisora que tiene puesta acutalmente
		//utilizando "nombre que la pongas al objeto radio".getEmisoraEnReproduccion(),
		//y con eso ya sale
		//Se espera recibir numeros del 1 al 12 de la lista de favoritas NO 0
		if((numeroDeFav<=12)&&(numeroDeFav>=1)) {
			numeroDeFav=numeroDeFav-1;
			listaEmisorasFav.add(numeroDeFav, NuevaEmisoraFavorita);
			return "Emisora "+NuevaEmisoraFavorita.getNumeroDeEmisora()+" agregada a la posicion"
					+(listaEmisorasFav.indexOf(NuevaEmisoraFavorita)+1)+" de la lista de favoritos";
		}else return "No existe esa posicion disponible para establecer como favorito";
	}
	/**
	 * @return devuelve detalles de como resulto la operacion
	 *
	 * Sencillamente invocando este metodo se cambia de fm a am o viceversa
	 * si el estado actual es fm pasa a am y lo mismo, si esta en am pasa a fm
	 */
	public String cambiarDeFmAAm() {
		FmOAm = !FmOAm;
		String tipoDeRadio = FmOAm?"AM":"FM";
			for(emisoras emi: todasLasEmisoras) {
				if ((emi.getTipoDeEmisora()==tipoDeRadio)) {
					emisoraEnReproduccion=emi;
					break;
				}
			}

		String res = FmOAm?"Frecuencia de busqueda cambiado de FM a AM":"Frecuencia de busqueda cambiado de AM a FM";
		return res;
	}
}
