/**
 * Jose Ramon Corona  14417
 * Samuel Diaz
 * Julio Dieguez Ochoa   14475 16/7/15
 * HDT1
 */

public class Radio implements InterfazRadio{

/** =====================
*  **** VARIABLES ****
*  =====================
*/
	
private double emisora = MIN_AM;
private double emisora_m = MIN_FM;
private boolean estado = false;
private String frecuencia= "AM";
private int volumen=0;
double[] memoria_AM = new double [12];
double[] memoria_FM = new double [12];
/**
*Constructor 
*inicializa las memorias del radio
*/
public Radio(){
	for (int i=0; i<12; i++){
		memoria_AM[i]=0;
		memoria_FM[i]=0;
	}
}

/**===================
** **** Getters ****
** ===================
**/
@Override
public double getEmisora() {
	return emisora;
}

@Override
public String getFrec() {
	return frecuencia;
}

@Override
public int getVolumen() {
	return volumen;
}
@Override
public boolean getEncendido(){
    return estado; 
}
/**===================
* **** METODOS ****
* ===================
*/
/**
* Metodo Utilizado para Encender o Apagar la radio
*/
	@Override
	public void encenderApagar() {
		// cambia estado de radio (ON-OFF)
		if (estado==true){
			estado=false;
		}
		else {
			estado=true;
		}
	}
        /**
        * Se utiliza para cambiar frecuencia de am a fm
        */
	@Override
	public void cambiarFrec() {
		// cambia la frecuencia (AM-FM)
		
		if (frecuencia=="AM"){
			frecuencia="FM";
		}
		else {
			frecuencia="AM";
		}	
		
		// cambio de emisora y memoria de emisora
		emisora += emisora_m;
		emisora_m = emisora - emisora_m;
		emisora -= emisora_m;
		
		//redondear
		int cifras=(int) Math.pow(10,2);
	    emisora=Math.rint(emisora*cifras)/cifras;
	}
        
        /**
        *Adelanta la emisora, dependiendo si es am o fm
        */
	@Override
	public void adelantarEmisora() {
		// Adelanta la emisora segun se encuentre en AM o FM
		if (frecuencia=="AM" && emisora != MAX_AM){
			emisora += 10;
		}
		if (frecuencia=="FM" && emisora < MAX_FM){
			emisora += 0.2;
			
			//redondear
			int cifras=(int) Math.pow(10,2);
		    emisora=Math.rint(emisora*cifras)/cifras;
		}
	}
        /**
        *Atrasa la emisora, depende si es am o fm
        */
	@Override
	public void atrasarEmisora() {
		// Adelanta la emisora segun se encuentre en AM o FM
		if (frecuencia=="AM" && emisora != MIN_AM){
			emisora -= 10;
		}
		if (frecuencia=="FM" && emisora > MIN_FM){
			emisora -= 0.2;
			//redondear
			int cifras=(int) Math.pow(10,2);
		    emisora=Math.rint(emisora*cifras)/cifras;
		}	
	}
        /**
        *Guarda la emisora, utiliza una variable de tipo doble para guardar el numero de la emisora y una variable int para 
        *la memoria en la que se quiere guardar
        */
	@Override
	public void guardarEmisora(double emisora, int posicion) {
		// guarda emisora actual en la posicion especificada
		if (frecuencia=="AM"){
			memoria_AM[posicion]=this.emisora;
		}
		if (frecuencia=="FM"){
			memoria_FM[posicion]=this.emisora;
		}
	}
	/**
        *Carga la emisora, utiliza un int para la identifacar la memoria
        */
	public void cargarEmisora(int posicion) {
		// carga la emisora guardada en memoria segun posicion
		// si no hay emisora guardada no hace nada
		if (frecuencia=="AM" && memoria_AM[posicion] > 1){
			emisora = memoria_AM[posicion];
		}
		if (frecuencia=="FM" && memoria_FM[posicion] > 1){
			emisora = memoria_FM[posicion];
		}
	}
        /**
        *Sube el volumen de uno en uno, mas 10
        */
	@Override
	public void subirVolumen() {
		// Aumenta el volumen (maximo 10)
		if (volumen<10){
			volumen+=1;
		}
	}
        /**
        *Baja el volimen de uno en uno, min 0
        */
	@Override
	public void bajarVolumen() {
		// Disminuye el volumen (minimo 0)
		if (volumen>0){
			volumen-=1;
		}
	}

    /**
     * fin
     */
        
}
