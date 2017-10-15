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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author SEBASTIAN
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ASEGURADORA.MENUTest.class, ASEGURADORA.TBASEGURAMIENTOSTest.class, ASEGURADORA.TBINCIDENTESTest.class, ASEGURADORA.TBCOMPAÑIATest.class, ASEGURADORA.TBAUTOMOTORESTest.class, ASEGURADORA.LOGINTest.class, ASEGURADORA.TBTIPOAUTOMOTORESTest.class})
public class ASEGURADORASuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
