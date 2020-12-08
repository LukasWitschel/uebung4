package org.hbrs.se.ws20.uebung4;

import java.io.Serializable;


public class UserStory implements Comparable<UserStory>, Serializable {

    @Override
    public String toString() {
        return "UserStory [beschreibung=" + beschreibung + ", akzeptanzkriterien=" + akzeptanzkriterien + ", aufwand=" + aufwand + ", id=" + id + ", mehrwert=" + mehrwert
                + ", risk=" + risk + ", strafe=" + strafe + ", prio=" + prio + "]";
    }

    private String beschreibung;
    private String akzeptanzkriterien;
    private int aufwand = 0;
    private int id = 0;
    private int mehrwert = 0;
    private int risk = 0;
    private int strafe = 0;
    private double prio = 0.0;


    // Konstruktor zur Erzeugung (Beschreibung ausgelassen)
    public UserStory(int id, String beschreibung, String akzeptanzkriterien, int mehrwert, int strafe,
                     int aufwand, int risk, double prio) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.beschreibung = akzeptanzkriterien;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risk = risk;
        this.prio = prio;
    }

    public double getPrio() {
        return prio;
    }

    public void setPrio(double prio) {
        this.prio = prio;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public String getAkzeptanzkriterien() {
        return akzeptanzkriterien;
    }
    public void setAkzeptanzkriterien(String akzeptanzkriterien) {
        this.akzeptanzkriterien = akzeptanzkriterien;
    }
    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }
    public int getRisk() {
        return risk;
    }
    public void setRisk(int risk) {
        this.risk = risk;
    }
    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }


    public int compareTo(UserStory input) {
        if ( input.getPrio() == this.getPrio() ) {
            return 0;
        }

        if ( input.getPrio() > this.getPrio() ) {
            return 1;
        }
        else return -1;
    }



}
