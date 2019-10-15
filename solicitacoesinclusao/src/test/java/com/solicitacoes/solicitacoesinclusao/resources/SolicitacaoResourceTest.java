/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.solicitacoes.solicitacoesinclusao.models.Solicitacao;
import com.solicitacoes.solicitacoesinclusao.resources.SolicitacaoResource;
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
public class SolicitacaoResourceTest {
    
    public SolicitacaoResourceTest() {
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
     * Test of salvaSolicitacao method, of class SolicitacaoResource.
     */
    @Test
    public void testSalvaSolicitacao() {
        System.out.println("salvaSolicitacao");
        Solicitacao solicitacao = null;
        SolicitacaoResource instance = new SolicitacaoResource();
        Solicitacao expResult = null;
        Solicitacao result = instance.salvaSolicitacao(solicitacao);
        assertEquals(expResult, result);
        
    }
    
}
