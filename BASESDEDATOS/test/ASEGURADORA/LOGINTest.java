/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASEGURADORA;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SEBASTIAN
 */
public class LOGINTest {
    
    public LOGINTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validarusuario method, of class LOGIN.
     */
    @Test
    public void testValidarusuario() {
        System.out.println("validarusuario");
        String us = "";
        String Cla = "";
        LOGIN instance = new LOGIN();
        instance.validarusuario(us, Cla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class LOGIN.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LOGIN.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
