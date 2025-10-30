package padroescomportamentais.state;

public class TarefaEstadoCancelado implements TarefaEstado {

    private static TarefaEstadoCancelado instance;

    private TarefaEstadoCancelado() {}

    public static TarefaEstadoCancelado getInstance() {
        if (instance == null) {
            instance = new TarefaEstadoCancelado();
        }
        return instance;
    }

    @Override
    public boolean iniciar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean pausar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean concluir(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean cancelar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean atrasar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean reabrir(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoNovo.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Tarefa Cancelada";
    }
}
