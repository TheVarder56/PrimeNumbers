package edu.unl.cc.succession.business;

public class Sos {
    public static void main(String[] args) {
        PrimeNumberCalculatorUpToNTerm pm=new PrimeNumberCalculatorUpToNTerm(15);
        pm.calculate();
        System.out.println(pm.print());
    }
}
