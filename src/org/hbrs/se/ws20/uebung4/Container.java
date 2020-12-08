package org.hbrs.se.ws20.uebung4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Container {

    private List<UserStory> liste = null;

    private static Container instance = new Container();

    public final static String LOCATION = "Users/g-for/Documents/Bachelor_Wirtschaftsinformatik/3.Semester/Software Engineering 1/Übung/Lösungen/04";


    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }
    private Container(){
        liste = new ArrayList<UserStory>();
    }
    public void addUserStory ( UserStory r ) throws ContainerException {
        if ( contains(r) == true ) {
            ContainerException ex = new ContainerException("ID bereits vorhanden!");
            throw ex;
        }
        liste.add(r);

    }

    private boolean contains(UserStory r) {
        int ID = r.getId();
        for ( UserStory rec : liste) {
            if ( rec.getId() == ID ) {
                return true;
            }
        }
        return false;
    }

    public int getAnzahl(){
        return liste.size();
    }
    public List<UserStory> getCurrentList() {
        return this.liste;
    }
    private UserStory getUserStory(int id) {
        for ( UserStory rec : liste) {
            if (id == rec.getId() ){
                return rec;
            }
        }
        return null;
    }
    public void store() {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( Container.LOCATION );
            oos = new ObjectOutputStream(fos);

            try {
                oos.writeObject( liste );
                System.out.println(this.getAnzahl() + " User Stories wurden erfolgreich gespeichert!");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null) try { oos.close(); } catch (IOException e) {}
            if (fos != null) try { fos.close(); } catch (IOException e) {}
        }

    }
    public void load() {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream( Container.LOCATION );
            ois = new ObjectInputStream(fis);


            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                this.liste = (List) obj;

            }
            System.out.println("Es wurden " + this.getAnzahl() + " User Stories erfolgreich reingeladen!");
        }
        catch (IOException e) {
            System.out.println("FEHLER: Datei konnte nicht gefunden werden!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("FEHLER: Liste konnte nicht extrahiert werden (ClassNotFound)!");
        }
        finally {
            if (ois != null) try { ois.close(); } catch (IOException e) {}
            if (fis != null) try { fis.close(); } catch (IOException e) {}
        }
    }


}
