/**
 * Jose Ramon Corona  14417
 * Samuel Diaz
 * Julio Dieguez Ochoa   14475 16/7/15
 * HDT1
 */
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.text.*;
import java.lang.*;
/**---------------------------Se crea la Clase-------------------------------
*
*/
public class gui extends JPanel{
	
/**--------------------------Variables---------------------------------------
*
*/
        private JLabel jLCambioEmisora, jLNombreEmisora, jLNumeroEmisora, jLVolumen, jLMemorias, jLApagado, jLNumVolumen, jLVol;  
	private JButton jBEmisoraMas, jBEmisoraMenos, jBVolMas, jBVolMenos, jBApagado,jBFrecuencia, jBGuardar;
	private JPanel panelC, panelW, panelE, panelVol, panelApagado, panelCEmisora,panelMemorias, panelNomEmi, panelNom;
	private Color Mycolor;
	private JButton [] matrizJBMemorias = new JButton[12];
	private Radio radio= new Radio();
	private boolean guardar=false;
	
	public gui() {
		setLayout(new BorderLayout());
/**------------------------Componentes de la GUI---------------
                *
                */
		jLCambioEmisora = new JLabel ("Emisora"); 	//Se crean e inicializan los labels 
		jLNombreEmisora = new JLabel ("Emisora:"); 	//Se crean e inicializan los labels 
		jLNumeroEmisora = new JLabel (); 			//Se crean e inicializan los labels 
		jLVolumen = new JLabel ("Volumen"); 		//Se crean e inicializan los labels 
		jLMemorias = new JLabel ("Memoria"); 		//Se crean e inicializan los labels 
		jLApagado = new JLabel ("Power"); 			//Se crean e inicializan los labels   
		jLNumVolumen= new JLabel (); 			//Se crean e inicializan los labels   
		jLVol= new JLabel ("Volumen:"); 			//Se crean e inicializan los labels   
		jBEmisoraMas = new JButton("+");			//Aqui se crea un objeto tipo boton
		jBEmisoraMenos = new JButton("-");			//Aqui se crea un objeto tipo boton
		jBVolMas = new JButton("+");				//Aqui se crea un objeto tipo boton
		jBVolMenos = new JButton("-");				//Aqui se crea un objeto tipo boton
		jBApagado = new JButton("o/- OFF ");				//Aqui se crea un objeto tipo boton
		jBFrecuencia = new JButton(radio.getFrec());				//Aqui se crea un objeto tipo boton
		jBGuardar = new JButton("Guardar");				//Aqui se crea un objeto tipo boton
		
		for (int i = 0; i< matrizJBMemorias.length; i++){	// se recorre la matriz de Jlabel, esta matriz contiene solo casillas para formar el calendario grafico
			matrizJBMemorias[i]= new JButton(""+i);
		}
		
		Mycolor = new Color(50,150,243);		//Color del Radio
/**------------------Paneles---------------------------------------------
                *
                */

		//------------------Paneles----------------------
			panelW= new JPanel();							//este panel contien todos los objetos que se colocaran para mostrar la informacion del doctor y enfermera
			panelW.setBackground (Mycolor);				//se le asigana un color, para diferenciar el panel
			panelW.setPreferredSize (new Dimension(110, 0));//se le asigna una dimension especifica
			panelCEmisora= new JPanel();
			panelCEmisora.setPreferredSize (new Dimension(70, 100));
			panelCEmisora.setBackground (Color.red);
			panelCEmisora.add(jLCambioEmisora);
			panelCEmisora.add(jBEmisoraMas);
			panelCEmisora.add(jBEmisoraMenos);
			panelW.add(panelCEmisora);
		//------------------Paneles----------------------
			panelE= new JPanel();							//este panel contiene todos los objetos necesarios para mostrar la informacion del doctor y cambiar de dia.
			panelE.setBackground (Mycolor);				//se le asigana un color, para diferenciar el panel
			panelE.setPreferredSize (new Dimension(180, 0));//se le asigna una dimension especifica al panel principal	
			panelVol= new JPanel();
			panelVol.setBackground (Color.red);
			panelVol.setPreferredSize (new Dimension(70, 100));
			panelVol.add(jLVolumen);
			panelVol.add(jBVolMas);
			panelVol.add(jBVolMenos);
			panelApagado= new JPanel();
			panelApagado.setBackground (Color.red);
			panelApagado.setPreferredSize (new Dimension(90, 70));
			panelApagado.add(jLApagado);
			panelApagado.add(jBApagado);
			panelE.add(panelVol);
			panelE.add(panelApagado);
			
		//------------------Paneles----------------------
			panelC = new JPanel();
			panelC.setLayout(new BorderLayout());			//se le da layout de borderlayout al panel para que permite colocar los demas objetos en las 5 posiciones			
			panelC.setBackground (Mycolor);
			panelMemorias= new JPanel();
			panelMemorias.setBackground (Mycolor);
			//panelMemorias.add(jLMemorias);
			JPanel panelBMemoria = new JPanel ();				
			GridLayout gl4 = new GridLayout(2, 6);			//se crea una tabla para colocar los numeros del calendario
			panelBMemoria.setLayout(gl4);						//se adiere la tabla al panel
			for (int i = 0; i< matrizJBMemorias.length; i++){	// se recorre la matriz de Jlabel, esta matriz contiene solo casillas para formar el calendario grafico
				panelBMemoria.add(matrizJBMemorias[i]);
			}
			panelMemorias.add(panelBMemoria);
			panelNom= new JPanel();
			panelNom.setLayout(new BorderLayout());			//se le da layout de borderlayout al panel para que permite colocar los demas objetos en las 5 posiciones			
			JPanel panelEspacio= new JPanel();
			panelEspacio.add(jBFrecuencia);
			panelEspacio.add(new JLabel ("                                "));
			panelEspacio.add(jBGuardar);
			panelEspacio.setBackground (Mycolor);
			panelNomEmi= new JPanel();
			panelNomEmi.setBackground (Mycolor);
			panelNomEmi.add(jLNombreEmisora);
			panelNomEmi.add(jLNumeroEmisora);
			panelNomEmi.add(new JLabel ("                     "));
			panelNomEmi.add(jLVol);
			panelNomEmi.add(jLNumVolumen);
			panelNom.add(panelEspacio, BorderLayout.NORTH);
			panelNom.add(panelNomEmi, BorderLayout.CENTER);
			panelC.add(panelNom, BorderLayout.NORTH);
			panelC.add(panelMemorias, BorderLayout.SOUTH);
		//----------------------------------------
			add(panelW, BorderLayout.WEST); 
			add(panelE, BorderLayout.EAST); 
			add(panelC, BorderLayout.CENTER);
		//------------------Linseners----------------------
			MemoriaButtonListener blistener1 = new MemoriaButtonListener();	//se crea un objeto detipo listener
			for (int i = 0; i< matrizJBMemorias.length; i++){		//
				matrizJBMemorias[i].addActionListener(blistener1);		//s
			}
			
			ButtonListenerVol blistener2 = new ButtonListenerVol();	//se crea un objeto detipo listener
			jBVolMas.addActionListener(blistener2);
			jBVolMenos.addActionListener(blistener2);
			
			ButtonListenerEmisora blistener3 = new ButtonListenerEmisora();	//se crea un objeto detipo listener
			jBEmisoraMenos.addActionListener(blistener3);
			jBEmisoraMas.addActionListener(blistener3);
			
			ButtonListener blistener4 = new ButtonListener();	//se crea un objeto detipo listener
			jBApagado.addActionListener(blistener4);
			jBFrecuencia.addActionListener(blistener4);
			jBGuardar.addActionListener(blistener4);
	}	
/**---------------------------- Inner classs:Botton litener------------------------------------- 
        *
        */
        /**
        * Esta clase se utliza para detectar cuando se presiona un botton de la memoria
        */
	private class MemoriaButtonListener implements ActionListener{	
		
		public void actionPerformed (ActionEvent event){
			JButton b = (JButton) event.getSource();
                        if( radio.getEncendido()== true){
                            String n = b.getText();
                            if (guardar==true){
                                radio.guardarEmisora(radio.getEmisora(),Integer.parseInt(n));
                                    System.out.print("guardo ");
                            }
                            else{
                                    radio.cargarEmisora(Integer.parseInt(n));
                                    System.out.print("cargo ");
                                    jLNumeroEmisora.setText(String.valueOf(radio.getEmisora()));
                            }
                            guardar=false;	
                        }
		}
	}
        /**
        * Esta clase se utliza para detectar cuando se presiona un botton del volumen
        */
	private class ButtonListenerVol implements ActionListener{	

		public void actionPerformed (ActionEvent event){
			JButton b = (JButton) event.getSource();
                        if( radio.getEncendido()== true){  
                            String n = b.getText();
                            if(n.equals("+")){
                                    radio.subirVolumen();
                            }
                            if(n.equals("-")){
                                    radio.bajarVolumen();
                            }
                            jLNumVolumen.setText(String.valueOf(radio.getVolumen()));
                        }
		}
	}
        /**Esta clase se utliza para detectar cuando se presiona un botton para cambiar de emisora
        *
        */
	private class ButtonListenerEmisora implements ActionListener{	
		public void actionPerformed (ActionEvent event){
			JButton b = (JButton) event.getSource();
                        if( radio.getEncendido()== true){ 
                            String n = b.getText();
                            if(n.equals("+")){
                                    radio.adelantarEmisora();
                            }
                            if(n.equals("-")){
                                    radio.atrasarEmisora();
                            }
                            jLNumeroEmisora.setText(String.valueOf(radio.getEmisora()));
                            guardar=false;
                         }
		}
	}
	/**
        * Esta clase se utliza para detectar cuando se presiona un botton para apagar la radio, cambar fm o am, guardar estacion
        */
	private class ButtonListener implements ActionListener{	
		public void actionPerformed (ActionEvent event){
			JButton b = (JButton) event.getSource();
			String n = b.getText();
			// apgar y encender
			if(n.equals("o/- OFF ")){
				radio.encenderApagar();
				jBApagado.setText("o/- ON "); 
                                jLNumeroEmisora.setText(String.valueOf(radio.getEmisora()));
                                jLNumVolumen.setText(String.valueOf(radio.getVolumen()));
			}
                        if(n.equals("o/- ON ")){
                            radio.encenderApagar();
                            jBApagado.setText("o/- OFF ");
                            jLNumVolumen.setText("");
                            jLNumeroEmisora.setText("");
                        }
                        if( radio.getEncendido()== true){ 
                            // cambio de frecuencia
                            if(n.equals("AM") || n.equals("FM")){
                                    radio.cambiarFrec();
                                    jBFrecuencia.setText(radio.getFrec());
                                    jLNumeroEmisora.setText(String.valueOf(radio.getEmisora()));
                            }
                            // Guardar
                            if(n.equals("Guardar")){
                                    guardar=true;
                            }
                            else{
                                    guardar=false;
                            }	
                        }
		}
	}
}

