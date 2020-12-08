package org.hbrs.se.ws20.uebung4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EingabeDialog {

    public void startEingabe() {

        String strInput = null;

        System.out.println("Prio-Tool V38.0 by Lukas and the internet");

        BufferedReader input = new BufferedReader( new InputStreamReader(System.in ) );

        while ( true ) { // unendliche Schleife

            try {
                System.out.print("> ");
                strInput = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] strings = strInput.split(" ");

            if ( strings[0].equals("help") ) {
                System.out.println("Folgende Befehle stehen zur Verfuegung:");
                System.out.println("help-------Hilfe für Befehle.");
                System.out.println("dump-------Befehl zum löschen von einer Ausgabe.");
                System.out.println("load-------Befehl zum Laden einer Instance.");
                System.out.println("store-------Befehl um eine Instance zu laden.");
                System.out.println("enter-------Befehl um eine Eingabe zu erstellen.");
            }

            if ( strings[0].equals("dump") ) {
                this.startAusgabe();
            }

            if ( strings[0].equals("load") ) {
                Container.getInstance().load();
            }

            if ( strings[0].equals("store") ) {
                Container.getInstance().store();
            }

            if (  strings[0].equals("enter")  ) {

                MyConsole console = new MyConsole();
                System.out.println("Bitte geben Sie folgende Informationen zu User Storys ein:");

                int id = console.readLineInt("ID der neuen User Story: ");

                String beschreibung = console.readLine("Beschreibung der neuen User Story: ");

                String akzeptanzkriterien = console.readLine("Akzeptanzkriterien der neuen User Story: ");

                int aufwand = console.readLineInt("Aufwand der neuen User Story: ");

                int risk = console.readLineInt("Risiko der neuen User Story: ");

                int mehrwert = console.readLineInt("Mehrwert der neuen User Story: ");

                int strafe = console.readLineInt("Strafe der Uneuen ser Story: ");

                double prio =  ( (mehrwert + strafe ) / ( aufwand + risk ) );
                System.out.println("User Story mit ID: " + id + " hat die Prio: " + prio);

                UserStory us = new UserStory( id, beschreibung,akzeptanzkriterien, mehrwert, strafe, aufwand, risk , prio );

                try {
                    Container.getInstance().addUserStory( us );
                } catch (ContainerException e) {
                    System.out.println("Error. Fehler beim adden der User Story!");
                }

            }
        }
    }

    private void startAusgabe() {
        AusgabeDialog dialog = new AusgabeDialog( Container.getInstance().getCurrentList() );
        dialog.dump();
    }

}
