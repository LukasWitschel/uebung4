package org.hbrs.se.ws20.uebung1.view;

import org.hbrs.se.ws20.uebung1.control.*;
import org.hbrs.se.ws20.uebung1.control.factory.Factory;

public class Client {
	// public um zugriff gestatten

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	private Translator translator = null;
	public Client() {}


	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!
		GermanTranslator translator = Factory.createGermanTranslator();
		String result = translator.translateNumber(aNumber);

		System.out.println("Das Ergebnis der Berechnung: " + "[das Ergebnis an dieser Stelle]" + result);
	}

	public void setTranslator(Translator translator) {
		this.translator = translator;
	}
}




