package org.hbrs.se.ws20.uebung4;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AusgabeDialog {

    List<UserStory> liste = null;

    public AusgabeDialog(List<UserStory> currentList) {
        this.liste = currentList;
    }

    public void dump(){
        if ( liste.isEmpty() ) {
            System.out.println("Es sind kein User Stories vorhanden");
            return;
        }
        this.dumpLambdaWithFilter();

    }

    private void dumpIterator() {

        Collections.sort(   this.liste );

        Iterator<UserStory> i = liste.iterator();
        while (  i.hasNext() ) {
            UserStory p = i.next();
            System.out.println("ID: " + p.getId() );
            System.out.println("Beschreibung: " + p.getBeschreibung());
            System.out.println("Akzeptanzkriterien: " + p.getAkzeptanzkriterien());
            System.out.println("Prio: " + p.getPrio());
            System.out.println("Aufwand: " + p.getAufwand());
            System.out.println("Risiko: " + p.getRisk());
            System.out.println("Mehrwert: " + p.getMehrwert());
            System.out.println("Risiko: " + p.getRisk());
            System.out.println("\n");
        }
        System.out.println("Anzahl der User Stories: " + liste.size() );
    }

    private void dumpForEach() {
        for ( UserStory us : liste ) {
            System.out.println( us.toString() );
        }
    }
    private void dumpFunctionInterface() {
        liste.forEach( new Consumer<UserStory>() {
            @Override
            public void accept(UserStory us) {
                System.out.println( us.toString() );
            }
        }  );
    }

    private void dumpLambdaInFunctionalInterface() {
        liste.forEach( us  -> System.out.println( us.toString() ) );
    }

    private void dumpLambdaInStream() {
        liste.stream().forEach( us  -> System.out.println( us.toString() ) );
    }
    private void dumpLambdaWithFilter() {
        liste.stream().filter( us -> us.getRisk() > 4)   // Filter
                .forEach( us  -> System.out.println( us.toString() ) );
    }
}
