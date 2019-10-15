/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import com.solicitacoes.solicitacoesexclusao.models.Solicitacao;
import com.solicitacoes.solicitacoesexclusao.repositories.SolicitacaoRepository;
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
public class SolicitacaoRepositoryTest {
    
    public SolicitacaoRepositoryTest() {
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
     * Test of findById method, of class SolicitacaoRepository.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        long id = 0L;
        SolicitacaoRepository instance = new SolicitacaoRepositoryImpl();
        Solicitacao expResult = null;
        Solicitacao result = instance.findById(id);
        assertEquals(expResult, result);
        
    }

    public class SolicitacaoRepositoryImpl implements SolicitacaoRepository {

        public Solicitacao findById(long id) {
            return null;
        }
    }
    
}
