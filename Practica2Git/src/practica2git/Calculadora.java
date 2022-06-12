/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2git;

import java.util.Scanner;

/**
 *
 * @author monre
 */
public class Calculadora {

    private String operacion;
    private double n1;
    private double n2;
    private double resultado;
    private static Scanner lector = new Scanner(System.in);

    public void setNum1(String texto) {
        String numero1;
        do {
            System.out.println(texto);
            numero1 = lector.nextLine();
        } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
        n1 = new Double(numero1);
    }

    public void seleccionarOperacion() {
        boolean comprobar = false;
        do {
            System.out.println("\n Operacion? Indica el signo");
            System.out.println("Signo Operacion seleccionada\n"
                    + " '+' sumar \n" + " '-' restar \n"
                    + " 'x' multiplicar \n" + " '/' dividir \n"
                    + " '%' resto.\n"
                    + " 'L' logaritmo");
            operacion = lector.nextLine();
            comprobar = operacion.equals("+") || operacion.equals("-")
                    || operacion.equalsIgnoreCase("X") || operacion.equals("/")
                    || operacion.equals("%") || operacion.equalsIgnoreCase("L");
            if (comprobar == false) {
                System.err.println("Opcion incorrecta");
            }
        } while (comprobar != true);
    }

    public void setNum2(String texto) {
        String numero2;
        do {
            System.out.println(texto);
            numero2 = lector.nextLine();
        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
        n2 = new Double(numero2);
    }

    public void realitzarOperacio() {
        boolean comprobar = true;
        do {

            switch (operacion) {
                case "+":
                    resultado = n1 + n2;
                    break;
                case "-":
                    resultado = n1 - n2;
                    break;
                case "x":
                case "X":
                    resultado = n1 * n2;
                    break;
                case "/":
                    while (n2 == 0) {
                        setNum2(" La operacion contiene un 0 \n"
                                + "para evitar fallas coloca otro numero.");
                    }
                    resultado = n1 / n2;
                    break;
                case "%":
                    while (n2 == 0) {
                        setNum2(" La operacion contiene un 0 \n"
                                + "para evitar fallas coloca otro numero.");
                    }
                    resultado = n1 % n2;
                    break;
                case "L":
                case "l":
                    while (n1 <= 0 || n1 == 1) {
                        setNum1(" La base (n1) ha de ser positiva i diferent de 1, \n"
                                + "para evitar fallas coloca otro numero.");

                    }
                    while (n2 <= 0) {
                        setNum2("El num ha de ser positivo, \n"
                                + "para evitar fallas coloca otro numero.");

                    }
                    resultado = Math.log(n2) / Math.log(n1);
                    break;
            }
        } while (comprobar != true);
    }

    @Override
    public String toString() {
        return "Operacion " + n1 + "  " + operacion
                + "  " + n2 + " " + " = " + resultado;
    }

    public String preguntarContinuarCalculant(String seleccion) {
        boolean comprobar = true;
        System.out.println(seleccion);
        do {
            seleccion = lector.nextLine();
            if (!(seleccion.equalsIgnoreCase("S") || seleccion.equalsIgnoreCase("N"))) {

                System.err.println("\n Error valor incorrecto. \n");
                comprobar = false;
            }

        } while (comprobar != true);
        return seleccion;
    }

}
