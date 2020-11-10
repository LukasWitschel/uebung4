package org.hbrs.se.ws20.uebung1.test;

import org.hbrs.se.ws20.uebung1.view.*;
import org.hbrs.se.ws20.uebung1.control.*;

public class Assembler {

    private Client client = null;
    private Translator translator = null;

    public Assembler() {

        translator = new GermanTranslator();
        client = new Client();
        client.setTranslator(translator);

    }
    public void test(){
        client.display( 1 );
        client.display( 5 );
        client.display( 10 );

        client.display( 11 );
        client.display( -1 );
        client.display( 1000 );
        client.display( -1000 );
        client.display( 0 );
    }

    public static void main(String[] args) {
        Assembler ver = new Assembler();
        ver.test();
    }

}
