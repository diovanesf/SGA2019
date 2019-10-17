/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.solicitacoes.solicitacoesexclusao.models.Solicitacao;
import com.solicitacoes.solicitacoesexclusao.resources.SolicitacaoResource;
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
     * Test of deletaSolicitacao method, of class SolicitacaoResource.
     */
    @Test
    public void testDeletaSolicitacao() {
        System.out.println("deletaSolicitacao");
        Solicitacao solicitacao = null;
        SolicitacaoResource instance = new SolicitacaoResource();
        instance.deletaSolicitacao(solicitacao);
       
    }
    
}
