package org.hbrs.se.ws20.uebung2;
/*
*Die Klasse ContainerException bitte selber implementieren!
* Der StackTrace dieser Exception sollte folgendes exakt ausgeben:
* „Das Member-Objekt mit der ID [hier die ID des Objekts] ist bereits vorhanden!“
 */

public class ContainerException extends Exception{

    private int id; // ID muss hinzugefügt werden für die StackTrace Ausgabe

    public void addID(int id) {
        this.id = id;
    }

    @Override // Überschreiben des vorhandenen printStackTrace()
    public void printStackTrace() {
        // void printStackTrace()
        // Schreibt das Throwable und anschließend den Stack-Inhalt in den Standardausgabestrom.
        System.out.println("Das Member-Objekt mit der ID " + this.id + " ist bereits vorhanden!");
    }



}
