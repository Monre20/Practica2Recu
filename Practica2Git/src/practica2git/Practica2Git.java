/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2git;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica2Git {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String seleccio;
        Calculadora calculadora = new Calculadora();
        do {
            calculadora.setNum1("Calculadora\n Introduce un numero ");
            calculadora.seleccionarOperacion();
            calculadora.setNum2("\n Introduce otro");
            calculadora.realitzarOperacio();
            System.out.println(calculadora);
            seleccio = calculadora.preguntarContinuarCalculant("\n Quieres seguir operando? \n [s/n]");
        } while (seleccio.equalsIgnoreCase("S"));
    }
}
