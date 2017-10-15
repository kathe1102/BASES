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
public class TBINCIDENTESTest {
    
    public TBINCIDENTESTest() {
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
     * Test of cargatabla method, of class TBINCIDENTES.
     */
    @Test
    public void testCargatabla() {
        System.out.println("cargatabla");
        TBINCIDENTES instance = new TBINCIDENTES();
        instance.cargatabla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listardatos method, of class TBINCIDENTES.
     */
    @Test
    public void testListardatos() {
        System.out.println("listardatos");
        TBINCIDENTES instance = new TBINCIDENTES();
        instance.listardatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar method, of class TBINCIDENTES.
     */
    @Test
    public void testRegistrar() {
        System.out.println("registrar");
        TBINCIDENTES instance = new TBINCIDENTES();
        instance.registrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarcombo method, of class TBINCIDENTES.
     */
    @Test
    public void testCargarcombo() {
        System.out.println("cargarcombo");
        TBINCIDENTES instance = new TBINCIDENTES();
        instance.cargarcombo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarcombo2 method, of class TBINCIDENTES.
     */
    @Test
    public void testCargarcombo2() {
        System.out.println("cargarcombo2");
        TBINCIDENTES instance = new TBINCIDENTES();
        instance.cargarcombo2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class TBINCIDENTES.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        String fec = "";
        String pla = "";
        String lug = "";
        String her = "";
        String fat = "";
        String inv = "";
        String cod = "";
        TBINCIDENTES instance = new TBINCIDENTES();
        instance.modificar(fec, pla, lug, her, fat, inv, cod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class TBINCIDENTES.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        String cod = "";
        TBINCIDENTES instance = new TBINCIDENTES();
        instance.eliminar(cod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TBINCIDENTES.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TBINCIDENTES.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
