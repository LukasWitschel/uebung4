package org.hbrs.se.ws20.uebung4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyConsole {
    private BufferedReader input = null;


    public MyConsole(){
        input = new BufferedReader( new InputStreamReader(System.in ) );
    }

    public String readLine(String prompt){
        String strInput = null;

        System.out.print( prompt );
        try {

            strInput = input.readLine();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return strInput;
    }

    public String readLine() {
        return this.readLine("> ");
    }

    public int readLineInt(String prompt){
        String strInput = null;
        System.out.print(prompt);

        try {
            strInput = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int id = 0;
        try {
            id = new Integer( strInput ).intValue();
        } catch (java.lang.NumberFormatException e){
            System.out.println("Nur Zahlen sind erlaubt.");
            return this.readLineInt(prompt);
        }
        return id;
    }


}