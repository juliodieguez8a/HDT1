/**
 * Jose Ramon Corona  14417
 * Samuel Diaz
 * Julio Dieguez Ochoa   14475 16/7/15
 * HDT1
 */
public interface InterfazRadio {
	
	final int CONST_CAMBIO_AM = 10;
	final double CONST_CAMBIO_FM = 0.2;
	final int MAX_AM = 1610;
	final int MIN_AM = 530;
	final double MAX_FM = 107.9;
	final double MIN_FM = 87.9;


	/**
	 * Metodo que permite encender y apagar la radio cambiando el
	 * estado de su variable boolean (true=encendido, false=apagado)
	 */
	public void encenderApagar();

	/**
	 * Metodo que permite cambiar la frecuencia entre AM y FM.
	 */
	public void cambiarFrec();

	/**
	 *  Carga la emisora almacena en uno de los 12 botones
	 * @param posicion Entero de 1 a 12 
	 */
	public void cargarEmisora(int posicion);

	/**
	 * Metodo que permite cambiar a frecuencias mayores
	 */
	public void adelantarEmisora();

	/**
	 * Metodo que permite cambiar a frecuencias menores
	 */
	public void atrasarEmisora();

	/**
	 * Metodo que permite guardar emisoras
	 * @param emisora
	 * @param posicion
	 */
	public void guardarEmisora(double emisora, int posicion);

	/**
	 * Metodo que permite subir el volumen
	 */
	public void subirVolumen();

	/**
	 * Metodo que permite bajar el volumen
	 */
	public void bajarVolumen();

	//Retorna la emisora actual seleccionada (dependiendo si es AM o FM)
	public double getEmisora();
	//Retorna el estado actual de Encendido (true=encendido, false=apagado)
	public boolean getEncendido();
	//Retorna la frecuencia actual AM o FM
    public String getFrec();

    public int getVolumen();
    
    public String toString();

}
