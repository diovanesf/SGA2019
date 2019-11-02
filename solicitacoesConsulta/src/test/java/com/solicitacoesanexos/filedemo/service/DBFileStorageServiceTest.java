/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicitacoesanexos.filedemo.service;

import com.solicitacoesanexos.filedemo.model.DBFile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Diovane
 */
public class DBFileStorageServiceTest {
    
    public DBFileStorageServiceTest() {
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
     * Test of storeFile method, of class DBFileStorageService.
     */
    @Test
    public void testStoreFile() {
        System.out.println("storeFile");
        MultipartFile file = null;
        DBFileStorageService instance = new DBFileStorageService();
        DBFile expResult = null;
        DBFile result = instance.storeFile(file);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFile method, of class DBFileStorageService.
     */
    @Test
    public void testGetFile() {
        System.out.println("getFile");
        String fileId = "";
        DBFileStorageService instance = new DBFileStorageService();
        DBFile expResult = null;
        DBFile result = instance.getFile(fileId);
        assertEquals(expResult, result);
        
    }
    
}
