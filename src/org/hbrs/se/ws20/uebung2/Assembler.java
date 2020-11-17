package org.hbrs.se.ws20.uebung2;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Assembler {

    Member m1;
    Member m2;
    Member m3;

    Container cont;

    @BeforeEach
    public void setup() {
        m1 = new MemberOverwrite(1);
        m2 = new MemberOverwrite(50);
        m3 = new MemberOverwrite(100);
        cont = new Container();
    }
    @AfterEach
    public void reset() {
        m1 = null;
        m2 = null;
        m3 = null;
        cont = null;
    }
    @Test
    public void addMemberTest() {
        try{
            cont.addMember(m1);
            cont.addMember(m2);
            cont.addMember(m3);
        }
        catch(ContainerException e){
            e.printStackTrace();
        }
        assertEquals(m1, m1.getID(), "Test succesed");
        assertEquals(m2, m2.getID(), "Test succesed");
        assertEquals(m3, m3.getID(), "Test succesed");
    }
    @Test
    public void deleteMemberTest() {
        try{
            cont.addMember(m1);
            cont.addMember(m2);
            cont.addMember(m3);
        }
        catch(ContainerException e){
            e.printStackTrace();
        }
        cont.deleteMember(1);
        assertEquals(2, cont.size(), "Test succesed");
        cont.dump();
    }

    @Test
    public void sizeMemberTest() {
        try{
            cont.addMember(m1);
            cont.addMember(m2);
            cont.addMember(m3);
        }
        catch(ContainerException e){
            e.printStackTrace();
        }
        assertEquals(3, cont.size(), "Test succesed");
    }
    @Test
    public void dumpMemberTest() {
        try{
            cont.addMember(m1);
            cont.addMember(m2);
            cont.addMember(m3);
        }
        catch(ContainerException e){
            e.printStackTrace();
        }
        assertEquals(3, cont.size(), "Test succesed");
        cont.dump();
    }


}
