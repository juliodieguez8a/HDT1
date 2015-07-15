/**
 * 
 */

/**
 * @author Julio
 *
 */



public class Radio implements InterfazRadio{

//=====================
// **** VARIABLES ****
//=====================
	
private double emisora = MIN_AM;
private double emisora_m = MIN_FM;
private String estado = "OFF";
private String frecuencia= "AM";
private int volumen=0;

double[] memoria_AM = new double [11];
double[] memoria_FM = new double [11];

public Radio(){

	for (int i=0; i>11; i++){
		memoria_AM[i]=0;
		memoria_FM[i]=0;
	}
}

//===================
// **** Getters ****
//===================

public double getEmisora() {
	return emisora;
}

public String getEstado() {
	return estado;
}

public String getFrecuencia() {
	return frecuencia;
}

public int getVolumen() {
	return volumen;
}

//===================
// **** METODOS ****
//===================


	@Override
	public void encenderApagar() {
		// cambia estado de radio (ON-OFF)
		if (estado=="ON"){
			estado="OFF";
		}
		else {
			estado="ON";
		}
	}

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
	}

	@Override
	public void cargarEmisora(double emisora) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adelantarEmisora() {
		// Adelanta la emisora segun se encuentre en AM o FM
		if (frecuencia=="AM" && emisora != MAX_AM){
			emisora += 10;
		}
		if (frecuencia=="FM" && emisora != MAX_FM){
			emisora += 0.2;
		}
	}

	@Override
	public void atrasarEmisora() {
		// Adelanta la emisora segun se encuentre en AM o FM
		if (frecuencia=="AM" && emisora != MIN_AM){
			emisora -= 10;
		}
		if (frecuencia=="FM" && emisora != MIN_FM){
			emisora -= 0.2;
		}	
	}

	@Override
	public void guardarEmisora(double emisora, int posicion) {
		// TODO Auto-generated method stub
		if (frecuencia=="AM"){
			memoria_AM[posicion-1]=this.emisora;
		}
		if (frecuencia=="FM"){
			memoria_FM[posicion-1]=this.emisora;
		}
	}


	@Override
	public void subirVolumen() {
		// Aumenta el volumen (maximo 10)
		if (volumen<10){
			volumen+=1;
		}
	}

	@Override
	public void bajarVolumen() {
		// Disminuye el volumen (minimo 0)
		if (volumen>0){
			volumen-=1;
		}
	}



}
