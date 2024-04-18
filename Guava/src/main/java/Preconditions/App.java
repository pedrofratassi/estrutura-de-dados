package Preconditions;

public class App {
    public static void main(String[] args){

        Aluno estudante = new Aluno(new Boletim());
        estudante.solicitacaoPresenca();
        estudante.computarPresenca(76);
    }
}
