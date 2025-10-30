package padroescomportamentais.state;

public class TarefaEstadoEmEspera implements TarefaEstado {

    private static TarefaEstadoEmEspera instance;

    private TarefaEstadoEmEspera() {}

    public static TarefaEstadoEmEspera getInstance() {
        if (instance == null) {
            instance = new TarefaEstadoEmEspera();
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
        tarefa.setEstado(TarefaEstadoAtrasado.getInstance());
        return true;
    }

    @Override
    public boolean reabrir(Tarefa tarefa) {
        return false;
    }

    @Override
    public String getEstado() {
        return "Tarefa Em Espera";
    }
}
