import java.util.Random;

public class Jogo {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();
    var personagem1 = new Personagem("John");
    var personagem2 = new Personagem("Karla");

    //variavel que inicia como true para fazer a troca de personagens no jogo
    boolean alterarTurno = true;

    while (true) {
      int oQueFazer = gerador.nextInt(4);
    
      if (alterarTurno){
        // Ação do personagem "John"
        switch (oQueFazer) {
          case 0:
            personagem1.cacar();
            break;

          case 1:
            personagem1.comer();
            break;

          case 2:
            personagem1.dormir();
            break;

          case 3:
            personagem1.atacar(personagem2);
            break;
      }
          personagem1.exibirEstado();

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
            personagem2.atacar(personagem1);
            break;
        }
        personagem2.exibirEstado();
      }

      //verificar se os dois morreram para dar game over
      if(personagem1.getEnergia() <= 0 && personagem2.getEnergia() <= 0){
        System.out.println("Todos os personagens morreram. GAME OVER");
        break;
      }

      // Alternar entre os personagens na próxima iteração
      alterarTurno = !alterarTurno;

      System.out.println("--------------------------------");
      Thread.sleep(1000);
    }
    
  }
}
