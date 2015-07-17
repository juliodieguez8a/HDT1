/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja1;

import Radio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Poner en el mismo paquete todas las clases para que funcione la prueba al crear un objeto radio
 */
public class RadioTest2 {
    
    public RadioTest2() {
    }
    Radio instance = new Radio();
    @Test
    public void testencenderApagar() {
        System.out.println("encenderApagar");
        Radio instance = new Radio();
        instance.encenderApagar();
        asserEquals(true,instance.getEncendido() );
    }




}
