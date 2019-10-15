/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.solicitacoes.solicitacoesexclusao.models.Solicitacao;
import java.sql.Date;
import junit.framework.TestCase;

/**
 *
 * @author Diovane
 */
public class SolicitacaoTest extends TestCase {
    
    public SolicitacaoTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getId method, of class Solicitacao.
     */
    public void testGetId() {
        System.out.println("getId");
        Solicitacao instance = new Solicitacao();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Solicitacao.
     */
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Solicitacao instance = new Solicitacao();
        instance.setId(id);
        
    }

    /**
     * Test of getCodAtividade method, of class Solicitacao.
     */
    public void testGetCodAtividade() {
        System.out.println("getCodAtividade");
        Solicitacao instance = new Solicitacao();
        long expResult = 0L;
        long result = instance.getCodAtividade();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCodAtividade method, of class Solicitacao.
     */
    public void testSetCodAtividade() {
        System.out.println("setCodAtividade");
        long codAtividade = 0L;
        Solicitacao instance = new Solicitacao();
        instance.setCodAtividade(codAtividade);
        
    }

    /**
     * Test of getNomeDoAluno method, of class Solicitacao.
     */
    public void testGetNomeDoAluno() {
        System.out.println("getNomeDoAluno");
        Solicitacao instance = new Solicitacao();
        String expResult = "";
        String result = instance.getNomeDoAluno();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNomeDoAluno method, of class Solicitacao.
     */
    public void testSetNomeDoAluno() {
        System.out.println("setNomeDoAluno");
        String nomeDoAluno = "";
        Solicitacao instance = new Solicitacao();
        instance.setNomeDoAluno(nomeDoAluno);
        
    }

    /**
     * Test of getMatriculaDoAluno method, of class Solicitacao.
     */
    public void testGetMatriculaDoAluno() {
        System.out.println("getMatriculaDoAluno");
        Solicitacao instance = new Solicitacao();
        int expResult = 0;
        int result = instance.getMatriculaDoAluno();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMatriculaDoAluno method, of class Solicitacao.
     */
    public void testSetMatriculaDoAluno() {
        System.out.println("setMatriculaDoAluno");
        int matriculaDoAluno = 0;
        Solicitacao instance = new Solicitacao();
        instance.setMatriculaDoAluno(matriculaDoAluno);
        
    }

    /**
     * Test of getCargaHoraria method, of class Solicitacao.
     */
    public void testGetCargaHoraria() {
        System.out.println("getCargaHoraria");
        Solicitacao instance = new Solicitacao();
        int expResult = 0;
        int result = instance.getCargaHoraria();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCargaHoraria method, of class Solicitacao.
     */
    public void testSetCargaHoraria() {
        System.out.println("setCargaHoraria");
        int cargaHoraria = 0;
        Solicitacao instance = new Solicitacao();
        instance.setCargaHoraria(cargaHoraria);
        
    }

    /**
     * Test of getCargaHorariaReal method, of class Solicitacao.
     */
    public void testGetCargaHorariaReal() {
        System.out.println("getCargaHorariaReal");
        Solicitacao instance = new Solicitacao();
        int expResult = 0;
        int result = instance.getCargaHorariaReal();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCargaHorariaReal method, of class Solicitacao.
     */
    public void testSetCargaHorariaReal() {
        System.out.println("setCargaHorariaReal");
        int cargaHorariaReal = 0;
        Solicitacao instance = new Solicitacao();
        instance.setCargaHorariaReal(cargaHorariaReal);
        
    }

    /**
     * Test of getPeriodoAtividade method, of class Solicitacao.
     */
    public void testGetPeriodoAtividade() {
        System.out.println("getPeriodoAtividade");
        Solicitacao instance = new Solicitacao();
        String expResult = "";
        String result = instance.getPeriodoAtividade();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPeriodoAtividade method, of class Solicitacao.
     */
    public void testSetPeriodoAtividade() {
        System.out.println("setPeriodoAtividade");
        String periodoAtividade = "";
        Solicitacao instance = new Solicitacao();
        instance.setPeriodoAtividade(periodoAtividade);
        
    }

    /**
     * Test of getDataSolicitacao method, of class Solicitacao.
     */
    public void testGetDataSolicitacao() {
        System.out.println("getDataSolicitacao");
        Solicitacao instance = new Solicitacao();
        Date expResult = null;
        Date result = instance.getDataSolicitacao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDataSolicitacao method, of class Solicitacao.
     */
    public void testSetDataSolicitacao() {
        System.out.println("setDataSolicitacao");
        Date dataSolicitacao = null;
        Solicitacao instance = new Solicitacao();
        instance.setDataSolicitacao(dataSolicitacao);
        
    }

    /**
     * Test of id method, of class Solicitacao.
     */
    public void testId() {
        System.out.println("id");
        long id = 0L;
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.id(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of codAtividade method, of class Solicitacao.
     */
    public void testCodAtividade() {
        System.out.println("codAtividade");
        long codAtividade = 0L;
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.codAtividade(codAtividade);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of nomeDoAluno method, of class Solicitacao.
     */
    public void testNomeDoAluno() {
        System.out.println("nomeDoAluno");
        String nomeDoAluno = "";
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.nomeDoAluno(nomeDoAluno);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of matriculaDoAluno method, of class Solicitacao.
     */
    public void testMatriculaDoAluno() {
        System.out.println("matriculaDoAluno");
        int matriculaDoAluno = 0;
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.matriculaDoAluno(matriculaDoAluno);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of cargaHoraria method, of class Solicitacao.
     */
    public void testCargaHoraria() {
        System.out.println("cargaHoraria");
        int cargaHoraria = 0;
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.cargaHoraria(cargaHoraria);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of cargaHorariaReal method, of class Solicitacao.
     */
    public void testCargaHorariaReal() {
        System.out.println("cargaHorariaReal");
        int cargaHorariaReal = 0;
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.cargaHorariaReal(cargaHorariaReal);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of periodoAtividade method, of class Solicitacao.
     */
    public void testPeriodoAtividade() {
        System.out.println("periodoAtividade");
        String periodoAtividade = "";
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.periodoAtividade(periodoAtividade);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of dataSolicitacao method, of class Solicitacao.
     */
    public void testDataSolicitacao() {
        System.out.println("dataSolicitacao");
        Date dataSolicitacao = null;
        Solicitacao instance = new Solicitacao();
        Solicitacao expResult = null;
        Solicitacao result = instance.dataSolicitacao(dataSolicitacao);
        assertEquals(expResult, result);
        
    }
    
}
