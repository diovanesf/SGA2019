/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicitacoesanexos.filedemo.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diovane
 */
public class DBFileTest {
    
    public DBFileTest() {
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

    
    @Test
    public void testGetId() {
        System.out.println("getId");
        DBFile instance = new DBFile();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class DBFile.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        DBFile instance = new DBFile();
        instance.setId(id);
        
    }

    /**
     * Test of getFileName method, of class DBFile.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        DBFile instance = new DBFile();
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFileName method, of class DBFile.
     */
    @Test
    public void testSetFileName() {
        System.out.println("setFileName");
        String fileName = "";
        DBFile instance = new DBFile();
        instance.setFileName(fileName);
        
    }

    /**
     * Test of getFileType method, of class DBFile.
     */
    @Test
    public void testGetFileType() {
        System.out.println("getFileType");
        DBFile instance = new DBFile();
        String expResult = "";
        String result = instance.getFileType();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFileType method, of class DBFile.
     */
    @Test
    public void testSetFileType() {
        System.out.println("setFileType");
        String fileType = "";
        DBFile instance = new DBFile();
        instance.setFileType(fileType);
        
    }

    /**
     * Test of getData method, of class DBFile.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        DBFile instance = new DBFile();
        byte[] expResult = null;
        byte[] result = instance.getData();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of setData method, of class DBFile.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        byte[] data = null;
        DBFile instance = new DBFile();
        instance.setData(data);
        
    }
    
}
