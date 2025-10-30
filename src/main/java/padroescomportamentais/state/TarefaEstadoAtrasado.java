package padroescomportamentais.state;

public class TarefaEstadoAtrasado implements TarefaEstado {

    private static TarefaEstadoAtrasado instance;

    private TarefaEstadoAtrasado() {}

    public static TarefaEstadoAtrasado getInstance() {
        if (instance == null) {
            instance = new TarefaEstadoAtrasado();
        }
        return instance;
    }

    @Override
    public boolean iniciar(Tarefa tarefa) {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        return true;
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
        tarefa.setEstado(TarefaEstadoCancelado.getInstance());
        return true;
    }

    @Override
    public boolean atrasar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean reabrir(Tarefa tarefa) {
        return false;
    }

    @Override
    public String getEstado() {
        return "Tarefa Atrasada";
    }
}
