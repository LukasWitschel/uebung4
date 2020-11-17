package org.hbrs.se.ws20.uebung2;

/*
 * Klasse Container soll folgende (funktionale) Anforderungen erfüllen
 */

import java.util.ArrayList; // new ArrayList<Member>()
import java.util.List; // List<Member> liste

public class Container {
/*
  * Es soll möglich sein, Objekte vom Typ Member in einem instanziierten Objekt der
  * Klasse Container zur Laufzeit abzuspeichern. geprüfte Exception vom Typ ContainerException
  * ausgeworfen werden
  *
  * + addMember( member : Member ) : void {throws ContainerException}
  * Bemerkung: streng genommen kennt die UML keine Exceptions
*/
    // Internes Array zur Speicherung der Member Objekte
    private List<Member> liste = new ArrayList<Member>();

    public void addMember (Member m) throws ContainerException {
        if (contains(m) == true) {
            ContainerException ce = new ContainerException();
            ce.addID (m.getID()); // ID beziehen aus Member und der ExceptionKlasse übergeben
            throw ce;
        }
        liste.add(m);
    }
    /*
    * Es soll mit der Methode deleteMember möglich sein, Objekte vom Typ Member in
    * einem instanziierten Objekt der Klasse Container zur Laufzeit zu löschen. Dazu muss
    * die eindeutige ID des Objekts vom Typ Member dem Container-Objekt übergeben
    * werden. Falls zu der übergebenen ID kein Member-Objekt gespeichert ist, sollte über
    * einen von ihnen freiwählbaren Rückgabewert eine entsprechende Fehlermeldung ausgegeben
    * werden. Welche Nachteile ergeben sich aus ihrer Sicht für ein solchen Fehlerbehandlung
    * gegenüber einer Lösung mit Exceptions? Kurzes Statement!
    * Spezifikation der Methode nach der UML:
    * + deleteMember( id : Integer ) : String
     */

    // Interne Methode zur überprüfen ob ein Member-Objekt in der Liste vorhanden ist (Falls zu der übergebenen ID kein Member-Objekt gespeichert ist)
    private boolean contains(Member m) {
        Integer ID = m.getID(); //ID des Member Objekts hinzufügen
        for (Member lt : liste) { // Member Liste per -for Schleife durchlaufen
            // autoboxing durch intValue(); fordert sie auf, die ganze Zahl als Typ int zurück
            //  Umwandlung eines int zu Integer
            // sonst keine Überprüfung möglich
            if (lt.getID().intValue() == ID.intValue()) {
                return true;
            }
        }
        return false;
    }
    // Interne Methode zum überprüfen ob ein Member Objekt vorhanden ist, dieses dann zurückgeben
    private Member get(Integer id) {
        for (Member lt : liste) {
            if (id == lt.getID().intValue()){
                return lt;
            }
        }
        return null; // Kein Member gefunden, Rückgabe null
    }

    // Methode zur löschung von Member-Einträgen
    public String deleteMember(Integer id) {
        Member lt = get(id);
        if (lt == null) // falls keine ID übergeben wurde
            return "Member mit der folgenden ID: " + id + " wurde nicht geloescht - FEHLER";
        else {
            liste.remove(lt); // remove entfernt den Eintrag aus dem liste Array
            return "Member mit der folgenden ID: " + id + " wurde geloescht";
        }
    }

    /*
    *Es soll mit einer Methode dump möglich sein, die IDs der aktuell abgespeicherten
    * Objekte vom Typ Member auszugeben (hier: direkt auf der Console.). Für die Ausgabe
    * der ID eines einzelnen Member-Objekts soll innerhalb der Methode dump die Methode
    * toString() des jeweiligen Member-Objekts verwendet werden, die dazu aus der Klasse
    * java.lang.Object überschrieben werden muss. Die Ausgabe, die bei
    * toString() erfolgt, sollte wie folgt für ein Member-Objekt aussehen:
    * „Member (ID = [hier die ID des Members])“
    * Spezifikation der Methode nach UML:
    * + dump( ) : void
     */

    public void dump(){
        for (Member l : liste) {
            System.out.println(l.toString()); // Aufruf der Methode toString() aus der Klasse MemberOverwrite.
        }
    }

    /*
    *Es soll möglich sein, die Anzahl der aktuell abgespeicherten Objekte vom Typ
    * Member in einem Container-Objekt mittels der Methode size zu ermitteln und an ein
    * aufrufendes Objekt als Rückgabeparameter zu übergeben.
    * Spezifikation der Methode nach UML:
    * + size( ) : int
     */

    public int size(){
        return liste.size(); //Rückgabe der Größe des Arrays liste per Listen-Funktion size()
    }

}
