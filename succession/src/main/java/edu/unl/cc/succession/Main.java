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
            System.out.println("Serie de primos elevados a impares hasta n térmimos");
            System.out.println("1. Ingrese la cantidad de terminos que desee imprimir ");
            System.out.println("2. Imprimir la serie");
            System.out.println("0. Salir");

            System.out.println("Elija una opcion:");
            opcion = sc.nextInt();
            return opcion;
        }
        
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //por defecto entra a ingresar datos
            int opcionMenu=1;
            Successionable successionable = null;
            do {
                try {
                    System.out.printf("Programa de calculadora de sucesiones%n%n");
                    opcionMenu = readOptionsMenu(sc);
                    successionable=switchOpciones(opcionMenu,sc,successionable);
                } catch (Exception e) {
                    System.out.println("Ingrese un numero valido");
                    sc.nextLine();
                }
            }while(opcionMenu!=0);

        }
        private static Successionable switchOpciones(int opcionMenu,Scanner sc,Successionable successionable) {
            switch (opcionMenu){
                case 1:
                    try {
                        System.out.println("Elija el límite/N términos  de la serie: ");
                        int limite = sc.nextInt();
                        successionable = new PrimeNumberCalculatorUpToNTerm(limite);
                        System.out.println("Ingresado correctamente");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        sc.nextLine();
                    }finally {
                        break;
                    }
                case 2:
                    System.out.println("La serie ingresada es:");
                    try{
                        Long result = successionable.calculate().longValue();
                        System.out.println(successionable.print());
                        System.out.println("El resultado de la serie es: \nS = " + result);
                    }catch (Exception e){
                        System.out.println("Debe ingresar una opcion antes de imprimir la serie");
                    }
                    break;
                    case 0:
                        System.out.println("Gracias por Usar");
                        System.out.println("Autores:\nMiguel Armas \nSoledad Buri \nSebastian Orellana \nSteven Perez  \nDerick Vargas");
                default:

                    System.out.println("Opción no deseda");
            }
            return successionable;
        }
    }

