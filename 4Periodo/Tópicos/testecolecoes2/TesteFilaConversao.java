/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeColecoes;

public class TesteFilaConversao {

  public static void main(String[] args) {
    FilaGenerica filaDeAlunos = new FilaGenerica();

    Aluno aluno = new Aluno();
    filaDeAlunos.insere(aluno);

    Object alunoRemovido = filaDeAlunos.remove();

    if (aluno != alunoRemovido) {
      System.out.println("Erro: o aluno removido não é igual " +
        " ao que foi inserido");
    }

    if (!filaDeAlunos.vazia()) {
      System.out.println("Erro: A fila não está vazia");
    }
  }
}