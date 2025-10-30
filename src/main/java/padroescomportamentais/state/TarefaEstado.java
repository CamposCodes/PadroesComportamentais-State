package padroescomportamentais.state;

public interface TarefaEstado {
    boolean iniciar(Tarefa tarefa);
    boolean pausar(Tarefa tarefa);
    boolean concluir(Tarefa tarefa);
    boolean cancelar(Tarefa tarefa);
    boolean atrasar(Tarefa tarefa);
    boolean reabrir(Tarefa tarefa);
    String getEstado();
}
