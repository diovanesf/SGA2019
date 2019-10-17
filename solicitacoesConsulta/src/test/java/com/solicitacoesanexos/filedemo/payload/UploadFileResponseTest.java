/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicitacoesanexos.filedemo.payload;

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
public class UploadFileResponseTest {
    
    public UploadFileResponseTest() {
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
     * Test of getFileName method, of class UploadFileResponse.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        UploadFileResponse instance = null;
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFileName method, of class UploadFileResponse.
     */
    @Test
    public void testSetFileName() {
        System.out.println("setFileName");
        String fileName = "";
        UploadFileResponse instance = null;
        instance.setFileName(fileName);
        
    }

    /**
     * Test of getFileDownloadUri method, of class UploadFileResponse.
     */
    @Test
    public void testGetFileDownloadUri() {
        System.out.println("getFileDownloadUri");
        UploadFileResponse instance = null;
        String expResult = "";
        String result = instance.getFileDownloadUri();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFileDownloadUri method, of class UploadFileResponse.
     */
    @Test
    public void testSetFileDownloadUri() {
        System.out.println("setFileDownloadUri");
        String fileDownloadUri = "";
        UploadFileResponse instance = null;
        instance.setFileDownloadUri(fileDownloadUri);
        
    }

    /**
     * Test of getFileType method, of class UploadFileResponse.
     */
    @Test
    public void testGetFileType() {
        System.out.println("getFileType");
        UploadFileResponse instance = null;
        String expResult = "";
        String result = instance.getFileType();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFileType method, of class UploadFileResponse.
     */
    @Test
    public void testSetFileType() {
        System.out.println("setFileType");
        String fileType = "";
        UploadFileResponse instance = null;
        instance.setFileType(fileType);
        
    }

    /**
     * Test of getSize method, of class UploadFileResponse.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        UploadFileResponse instance = null;
        long expResult = 0L;
        long result = instance.getSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSize method, of class UploadFileResponse.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        long size = 0L;
        UploadFileResponse instance = null;
        instance.setSize(size);
        
    }
    
}
