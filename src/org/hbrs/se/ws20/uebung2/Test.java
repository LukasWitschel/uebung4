package org.hbrs.se.ws20.uebung2;

public class Test {
    /*
    * Testen sie die Implementierung der Klasse Container mit Hilfe einer externen Testklasse
    * (JUnit4 oder JUnit5 kann verwendet werden, falls bekannt). Erzeugen sie dabei
    * drei verschiedene Member -Objekte und testen sie ihre Implementierung hinreichend.
    * Hinweis dazu: formulieren sie ihre Testfälle auf Basis der Anzahl von intern gespeicherten
    * Member –Objekten (= den Zustand des Container-Objekts), die beim Hinzufügen /
    * Löschen von Objekten variieren kann (weitere Hinweise dazu in der Übung). Dokumentieren
    * sie ihre Testfälle zusätzlich mit dem Excel-Template (LEA à Kapitel 1 à Material,
    * Tab „Simple Test Suite“). Bitte auch Äquivalenzklassen definieren.
     */

    public void test() {
        // drei Member Objekte erstellen
        Member m1 = new MemberOverwrite(1);
        Member m2 = new MemberOverwrite(50);
        Member m3 = new MemberOverwrite(100);

        // Container anlegen, in dass die Member geschreiben werden.
        Container cont = new Container();

        // addMember überprüfen -> ContainerException mit try catch abfangen
        try{
            cont.addMember(m1);
            cont.addMember(m2);
            cont.addMember(m3);
        }
        catch(ContainerException e){
            e.printStackTrace();
        }
        expected(1, m1.getID());
        expected(10, m1.getID());
        expected(-1, m1.getID());
        // deleteMember überprüfen
            cont.deleteMember(1);
            expected(1,0);

        // size überprüfen
            expected(3, cont.size());

        // dump überprüfen


    }

    // ausgabenvergleich zwischen gegeben und erwartet ID
    private void expected(int given, int expected){
        if(given == expected) System.out.println("Gegebener Wert " + given + " erwarteter Wert " + expected + " sind gleich. Test succesed");
        else System.out.println("Gegebener Wert " + given + " erwarteter Wert " + expected + " stimmen nicht überein. Test failed");
    }

}
