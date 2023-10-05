import java.util.Random;

// classe jogo que simula o comportamento de dois personagens
public class Jogo {
  public static void main(String[] args) throws Exception { 
    //objetos da classe Personagem
    var gerador = new Random();
    var personagem1 = new Personagem("Gaunter");
    var personagem2 = new Personagem("Zyra");

    //variavel que inicia como true para fazer a troca de personagens no jogo
    boolean alterarTurno = true;

    //loop infinito até uma condição for quebrada(se ambos morrerem)
    while (true) {
      int oQueFazer = gerador.nextInt(4); //gera numero aleatorio entre 0 e 4, para as ações dos personagens
      if (alterarTurno){

        // Ação do personagem "Gaunter"
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
        
        // Ação do personagem "Zyra"
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

      // Alternar entre os personagens, invertendo os valores true para false, e vice-versa
      alterarTurno = !alterarTurno;

      System.out.println("--------------------------------");
      Thread.sleep(1000); //pequena pausa entre os turnos
    }
    
  }
}
