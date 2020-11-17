package org.hbrs.se.ws20.uebung2;
/*
 *lwitsc2s
 */

/*
* @overwrite Methode nicht in Member möglich, daher auslagerung in eigene Klasse
 */

public class MemberOverwrite implements Member{
    private Integer id;

    public MemberOverwrite (Integer id){ // Konstruktor erstellen für getID() Methode
        this.id = id;
    }
    public Integer getID() { // ansonsten MemberOverwrite als abstrakt definieren
        return this.id;
    }
    public void setID(Integer id){
       this.id = id;
    }

    @Override // nicht in Container/Member möglich
    public String toString() {
        return "Member (ID = " + id + ")";
    }

}
