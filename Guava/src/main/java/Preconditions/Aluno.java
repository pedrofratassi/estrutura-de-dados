package Preconditions;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class Aluno {
    private final Sistema sistema;
    private boolean alunoPresente;

    public Aluno(Sistema sistema){
        this.sistema = checkNotNull(sistema, "O Aluno(a) está ausente da Sala de Aula");
        this.alunoPresente = false;
    }

    public void solicitacaoPresenca(){
        checkState(alunoPresente, "Confirmando a presença do Aluno(a)!");
        alunoPresente = true;
    }

    public void computarPresenca(int presenca){
        sistema.computarPresenca(presenca);
    }

}
