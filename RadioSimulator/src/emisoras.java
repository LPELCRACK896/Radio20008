/**
 * @author Luis P Gonzalez
 *
 */
public class emisoras {
	private String tipoDeEmisora;
	private double numeroDeEmisora;
	private String apodo;
	private int numeroDeFav;

	public emisoras(String tipoDeEmisora, double numeroDeEmisora, String apodo, int numeroDeFav) {
		super();
		this.tipoDeEmisora = tipoDeEmisora;
		this.numeroDeEmisora = numeroDeEmisora;
		this.apodo = apodo;
		this.numeroDeFav = numeroDeFav;
	}
	/**
	 * @param tipoDeEmisora ingresa el tipo de emisora: Solo "FM" o "AM" (siempre en mayusculas)
	 * @param numeroDeEmisora ingresa el numero que identidfica la emisora
	 *
	 * este es el constructor que tenes que usar si o si. Con el minimo de parametros. Podes usar el de arriba pero
	 * para el funcionamiento de la clase radio solo es necesario hacer uso de este.
	 */
	public emisoras(String tipoDeEmisora, double numeroDeEmisora) {
		super();
		this.tipoDeEmisora = tipoDeEmisora;
		this.numeroDeEmisora = numeroDeEmisora;

	}
	public void favorita (int posicionEnLista) {
		numeroDeFav=posicionEnLista-1;
	}

	public String getTipoDeEmisora() {
		return tipoDeEmisora;
	}

	public void setTipoDeEmisora(String tipoDeEmisora) {
		this.tipoDeEmisora = tipoDeEmisora;
	}

	public double getNumeroDeEmisora() {
		return numeroDeEmisora;
	}

	public void setNumeroDeEmisora(double numeroDeEmisora) {
		this.numeroDeEmisora = numeroDeEmisora;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public int getNumeroDeFav() {
		return numeroDeFav;
	}

	public void setNumeroDeFav(int numeroDeFav) {
		this.numeroDeFav = numeroDeFav;
	}

}
