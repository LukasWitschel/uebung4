package org.hbrs.se.ws20.uebung1.control.factory;

import org.hbrs.se.ws20.uebung1.control.*;

public class Factory {
    // Zentrale stelle zum anklopfen
    // dezentrale Stelle zur erstellung von Objekten
    public static GermanTranslator createGermanTranslator(){
        GermanTranslator gt = new GermanTranslator();
        gt.setDate("Nov/2020");
        return gt;
    }

}
