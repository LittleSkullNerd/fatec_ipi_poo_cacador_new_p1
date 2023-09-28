import java.util.Random;

public class Jogo {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();
    var personagem = new Personagem("John");
    var personagem2 = new Personagem("Karla");

    boolean alterarPersonagem = true;

    while (true) {
      int oQueFazer = gerador.nextInt(4); // [0..4[

      if (alterarPersonagem) {
        // Ação do personagem "John"
        switch (oQueFazer) {
          case 0:
            personagem.cacar();
            break;

          case 1:
            personagem.comer();
            break;

          case 2:
            personagem.dormir();
            break;

          case 3:
            personagem.morrer();
            break;
        }
        personagem.exibirEstado();
      } else {
        // Ação do personagem "Karla"
        switch (oQueFazer) {
          case 0:
            personagem2.cacar();
            break;

          case 1:
            personagem2.comer();
            break;

          case 2:
            personagem2.dormir();
            break;

          case 3:
            personagem2.morrer();
            break;
        }
        personagem2.exibirEstado();
      }

      System.out.println("--------------------");
      Thread.sleep(8000);

      // Alternar entre os personagens na próxima iteração
      alterarPersonagem = !alterarPersonagem;
    }
  }
}
