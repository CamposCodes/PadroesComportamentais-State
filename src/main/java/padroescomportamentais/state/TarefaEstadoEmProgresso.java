package padroescomportamentais.state;

public class TarefaEstadoEmProgresso implements TarefaEstado {

    private static TarefaEstadoEmProgresso instance;

    private TarefaEstadoEmProgresso() {}

    public static TarefaEstadoEmProgresso getInstance() {
        if (instance == null) {
            instance = new TarefaEstadoEmProgresso();
        }
        return instance;
    }

    @Override
    public boolean iniciar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean pausar(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoEmEspera.getInstance());
        return true;
    }

    @Override
    public boolean concluir(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoConcluido.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoCancelado.getInstance());
        return true;
    }

    @Override
    public boolean atrasar(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoAtrasado.getInstance());
        return true;
    }

    @Override
    public boolean reabrir(Tarefa tarefa) {
        return false;
    }

    @Override
    public String getEstado() {
        return "Tarefa Em Progresso";
    }
}
