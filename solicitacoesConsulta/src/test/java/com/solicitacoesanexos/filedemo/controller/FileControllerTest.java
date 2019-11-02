/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicitacoesanexos.filedemo.controller;

import com.solicitacoesanexos.filedemo.payload.UploadFileResponse;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Diovane
 */
public class FileControllerTest {
    
    public FileControllerTest() {
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
     * Test of uploadFile method, of class FileController.
     */
    @Test
    public void testUploadFile() {
        System.out.println("uploadFile");
        MultipartFile file = null;
        FileController instance = new FileController();
        UploadFileResponse expResult = null;
        UploadFileResponse result = instance.uploadFile(file);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of uploadMultipleFiles method, of class FileController.
     */
    @Test
    public void testUploadMultipleFiles() {
        System.out.println("uploadMultipleFiles");
        MultipartFile[] files = null;
        FileController instance = new FileController();
        List<UploadFileResponse> expResult = null;
        List<UploadFileResponse> result = instance.uploadMultipleFiles(files);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of downloadFile method, of class FileController.
     */
    @Test
    public void testDownloadFile() {
        System.out.println("downloadFile");
        String fileId = "";
        FileController instance = new FileController();
        ResponseEntity<Resource> expResult = null;
        ResponseEntity<Resource> result = instance.downloadFile(fileId);
        assertEquals(expResult, result);
       
    }
    
}
