package padroescomportamentais.state;

public class TarefaEstadoConcluido implements TarefaEstado {

    private static TarefaEstadoConcluido instance;

    private TarefaEstadoConcluido() {}

    public static TarefaEstadoConcluido getInstance() {
        if (instance == null) {
            instance = new TarefaEstadoConcluido();
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
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Tarefa Concluida";
    }
}
