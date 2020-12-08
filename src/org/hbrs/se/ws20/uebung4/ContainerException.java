package org.hbrs.se.ws20.uebung4;

public class ContainerException extends Exception {

    private String modus;
    private Integer id;

    public ContainerException( String s ) {
        super ( s );
    }

    @Override
    public void printStackTrace() {
        System.out.println("Das Person-Objekt mit der ID " + this.id + " ist bereits vorhanden!");
    }

    public void addID(Integer id) {
        this.id = id;
    }


}