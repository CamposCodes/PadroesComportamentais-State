package padroescomportamentais.state;

public class TarefaEstadoNovo implements TarefaEstado {

    private static TarefaEstadoNovo instance;

    private TarefaEstadoNovo() {}

    public static TarefaEstadoNovo getInstance() {
        if (instance == null) {
            instance = new TarefaEstadoNovo();
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
        tarefa.setEstado(TarefaEstadoEmEspera.getInstance());
        return true;
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
        tarefa.setEstado(TarefaEstadoAtrasado.getInstance());
        return true;
    }

    @Override
    public boolean reabrir(Tarefa tarefa) {
        return false;
    }

    @Override
    public String getEstado() {
        return "Tarefa Nova";
    }
}
