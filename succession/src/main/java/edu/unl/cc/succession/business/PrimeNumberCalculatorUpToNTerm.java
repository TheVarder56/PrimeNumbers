package edu.unl.cc.succession.business;

import edu.unl.cc.succession.domain.Successionable;
/*
    Authors: Miguel Armas, Soledad Buri, Sebastian Orellana, Steven Perez y Derick Vargas
*/

public class PrimeNumberCalculatorUpToNTerm implements Successionable {
    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public PrimeNumberCalculatorUpToNTerm(Integer limit) {
        this(limit, 0);
    }

    public PrimeNumberCalculatorUpToNTerm(Integer limit, Integer currentTerm) {
        //EL limite de terminos que se imprimiran no sean negativos o 0
        //Lanza una excepcion de no ser así
        if (limit.intValue() < 0){
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        //El inicio de la serie es 1
        this.currentTerm = 1;
        setLimit(limit);
        printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number nextTerm(Number currentPrimeTerm) {
        while(true){
            currentPrimeTerm = currentPrimeTerm.intValue()+1;
            if(isPrime(currentPrimeTerm)){
                return currentPrimeTerm;
            }

        }
    }

    private boolean isPrime(Number currentPrimeTerm){
        if(currentPrimeTerm.intValue() == 1){
            return true;
        }
        if(currentPrimeTerm.intValue() == 2){
            return true;
        }
        if(currentPrimeTerm.intValue()%2 == 0){
            return false;
        }
        for(int i=3; i<currentPrimeTerm.intValue()/2; i+=2){
            if(currentPrimeTerm.intValue() % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setLimit(Number limit) {
        this.limit=limit.intValue();
    }

    @Override
    public Number calculate() {
        Integer result=0;
        Integer exponent;
        Number currentPrimeTerm=1;
        while(currentTerm<=limit){
            exponent=(2*currentTerm)-1;
            this.printableTerms.append(currentPrimeTerm).append("^").append(exponent).append(" + ");
            currentPrimeTerm=nextTerm(currentPrimeTerm);
            this.currentTerm= currentTerm +1;
            result=(int)Math.pow(currentPrimeTerm.doubleValue(),exponent);
        }
        //Siempre al final de cada termino se concatena " + "
        //Elimina el ultimo '+' y ' ' de la cadena final a presentar
        printableTerms.delete(printableTerms.length() - 2, printableTerms.length());
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}
