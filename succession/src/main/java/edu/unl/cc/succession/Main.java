package edu.unl.cc.succession;

import edu.unl.cc.succession.business.PrimeNumberCalculatorUpToNTerm;
import edu.unl.cc.succession.domain.Successionable;

import java.util.Scanner;

import java.util.Scanner;
/*
    Authors: Miguel Armas, Soledad Buri, Sebastian Orellana, Steven Perez y Derick Vargas
*/

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {


        private static int readOptionsMenu(Scanner sc){
            int opcion;
            System.out.println("Elija la opción de la serie que desea calcular:");
            System.out.println("Serie de primos elevados a impares hasta n térmimos");
            System.out.println("1. Ingrese la cantidad de terminos que desee imprimir ");
            System.out.println("2. Imprimir la serie");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println("Choose an option:");
            return opcion;
        }



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Programa de calculadora de sucesiones%n%n");
            int opcionMenu = readOptionsMenu(sc);
            System.out.println("Elija el límite/N términos  de la serie: ");
            int limite = sc.nextInt();
            Successionable successionable = null;
            switch (opcionMenu){
                case 1:
                    successionable = new PrimeNumberCalculatorUpToNTerm(limite);
                    System.out.println("Ingresado correctamente");
                    break;
                case 2:
                    System.out.println("La serie ingresada es:");
                    try{
                        Long result = successionable.calculate().longValue();
                        System.out.println(successionable.print());
                    }catch (Exception e){
                        System.out.println("Debe ingresar una opcion antes de imprimir la serie");
                    }

                    break;
                default:
                    System.out.println("Opción no deseda");
            }
            if (successionable != null){
                Long result = successionable.calculate().longValue();
                System.out.println(successionable.print());
                System.out.println("S = " + result + "\n");
            }

        }

    }

