package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    Tarefa tarefa;

    @BeforeEach
    public void setUp() {
        tarefa = new Tarefa();
    }

    @Test
    public void deveIniciarTarefaNova() {
        tarefa.setEstado(TarefaEstadoNovo.getInstance());
        assertTrue(tarefa.iniciar());
        assertEquals(TarefaEstadoEmProgresso.getInstance(), tarefa.getEstado());
    }

    @Test
    public void devePausarTarefaNova() {
        tarefa.setEstado(TarefaEstadoNovo.getInstance());
        assertTrue(tarefa.pausar());
        assertEquals(TarefaEstadoEmEspera.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveConcluirTarefaNova() {
        tarefa.setEstado(TarefaEstadoNovo.getInstance());
        assertFalse(tarefa.concluir());
    }

    @Test
    public void deveCancelarTarefaNova() {
        tarefa.setEstado(TarefaEstadoNovo.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelado.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveAtrasarTarefaNova() {
        tarefa.setEstado(TarefaEstadoNovo.getInstance());
        assertTrue(tarefa.atrasar());
        assertEquals(TarefaEstadoAtrasado.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveReabrirTarefaNova() {
        tarefa.setEstado(TarefaEstadoNovo.getInstance());
        assertFalse(tarefa.reabrir());
    }

    @Test
    public void naoDeveIniciarEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertFalse(tarefa.iniciar());
    }

    @Test
    public void devePausarEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.pausar());
        assertEquals(TarefaEstadoEmEspera.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveConcluirEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.concluir());
        assertEquals(TarefaEstadoConcluido.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveCancelarEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelado.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveAtrasarEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.atrasar());
        assertEquals(TarefaEstadoAtrasado.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveReabrirEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertFalse(tarefa.reabrir());
    }

    @Test
    public void deveIniciarEmEspera() {
        tarefa.setEstado(TarefaEstadoEmEspera.getInstance());
        assertTrue(tarefa.iniciar());
        assertEquals(TarefaEstadoEmProgresso.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDevePausarEmEspera() {
        tarefa.setEstado(TarefaEstadoEmEspera.getInstance());
        assertFalse(tarefa.pausar());
    }

    @Test
    public void naoDeveConcluirEmEspera() {
        tarefa.setEstado(TarefaEstadoEmEspera.getInstance());
        assertFalse(tarefa.concluir());
    }

    @Test
    public void deveCancelarEmEspera() {
        tarefa.setEstado(TarefaEstadoEmEspera.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelado.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveAtrasarEmEspera() {
        tarefa.setEstado(TarefaEstadoEmEspera.getInstance());
        assertTrue(tarefa.atrasar());
        assertEquals(TarefaEstadoAtrasado.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveIniciarConcluido() {
        tarefa.setEstado(TarefaEstadoConcluido.getInstance());
        assertFalse(tarefa.iniciar());
    }

    @Test
    public void naoDevePausarConcluido() {
        tarefa.setEstado(TarefaEstadoConcluido.getInstance());
        assertFalse(tarefa.pausar());
    }

    @Test
    public void naoDeveConcluirConcluido() {
        tarefa.setEstado(TarefaEstadoConcluido.getInstance());
        assertFalse(tarefa.concluir());
    }

    @Test
    public void deveReabrirConcluido() {
        tarefa.setEstado(TarefaEstadoConcluido.getInstance());
        assertTrue(tarefa.reabrir());
        assertEquals(TarefaEstadoEmProgresso.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveNadaCanceladoExcetoReabrir() {
        tarefa.setEstado(TarefaEstadoCancelado.getInstance());
        assertFalse(tarefa.iniciar());
        assertFalse(tarefa.pausar());
        assertFalse(tarefa.concluir());
        assertFalse(tarefa.cancelar());
        assertFalse(tarefa.atrasar());
        assertTrue(tarefa.reabrir());
        assertEquals(TarefaEstadoNovo.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveIniciarAtrasado() {
        tarefa.setEstado(TarefaEstadoAtrasado.getInstance());
        assertTrue(tarefa.iniciar());
        assertEquals(TarefaEstadoEmProgresso.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveCancelarAtrasado() {
        tarefa.setEstado(TarefaEstadoAtrasado.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelado.getInstance(), tarefa.getEstado());
    }

}
