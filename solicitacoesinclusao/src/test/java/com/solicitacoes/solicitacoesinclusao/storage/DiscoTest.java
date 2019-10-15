/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import com.solicitacoes.solicitacoesinclusao.storage.Disco;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduarodo
 */
public class DiscoTest {
    
    public DiscoTest() {
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
     * Test of salvarArquivo method, of class Disco.
     */
    @org.junit.Test
    public void testSalvarArquivo() {
        System.out.println("salvarArquivo");
        MultipartFile arquivo = null;
        Disco instance = new Disco();
        instance.salvarArquivo(arquivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class Disco.
     */
    @org.junit.Test
    public void testSalvar() {
        System.out.println("salvar");
        String diretorio = "";
        MultipartFile arquivo = null;
        Disco instance = new Disco();
        instance.salvar(diretorio, arquivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
