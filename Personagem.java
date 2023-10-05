public class Personagem {
 
  //atributos ou propriedades da classe Personagem
  private String nome;      //nome do tipo string
  private int energia = 10; //inicia com total de energia = 10
  private int fome = 0;     //começa sem fome
  private int sono = 0;     //começa sem sono
  private int item = 4;     //item inicia com 4

  //Construtor da classe personagem
  Personagem(String nome){
    this.nome = nome;
  }

  //Construtor da classe personagem, responsavel por construir o objeto (criar uma instancia)
  Personagem(String nome, int energia, int fome, int sono){
    this.nome = nome;
    if (energia >= 0 && energia <= 10)
      this.energia = energia;
    if (fome >= 0 && fome <= 10)
      this.fome = fome;
    if(sono >= 0 && sono <= 10)
      this.sono = sono;  
  }

  //comportamentos / métodos a seguir
  //método caçar
  void cacar(){
    if(energia <= 0){
      System.out.println(nome + " está morto e não pode caçar");
      return;
    }
    if(energia >= 2){
      System.out.println(nome + " caçando...");
      energia -= 2;     //energia = energia - 2;
      item++;
    } else {
      System.out.println (nome + " sem energia para caçar...");
    }
    fome = Math.min(fome + 1, 10);  //função math.min para garantir que nao excedam o valor 10
    sono = Math.min(sono + 1 ,10);
  }

  //método comer
  void comer(){
    if(energia <= 0){
      System.out.println(nome + " está morto e não pode comer");
      return;
    }
    if (fome >= 1 && item >= 1){
      System.out.println(nome + " comendo...");
      // operador ternário
      energia = energia + 1 > 10 ? 10 : energia + 1;
      //
      fome--;
      item--;
    }
    else if(item == 0){
      System.out.println(nome + " sem item no estoque para comer");
    }
    else{
      System.out.println(nome + " sem fome...");
    }
  }

  //método dormir
  void dormir(){
    if(energia <= 0){
      System.out.println(nome + " está morto e não pode dormir");
      return;
    }
    if(sono > 0){
      System.out.println(nome + " dormindo...");
      sono -= 1;
      energia = Math.min(10, energia + 1);
    }
    else{
      System.out.println(nome + " sem sono...");
    }
  }

  //método exibir o estado do personagem, retornando alguns valores
  void exibirEstado(){
    System.out.printf(
      "%s: e: %d, f: %d, s: %d, i: %d\n",
      nome,
      energia,
      fome,
      sono,
      item
    );
  }

  //método morrer
  void morrer(){
  if(energia <= 0){
    System.out.println(nome + " Game Over para " + nome);
    energia = 0;
  }
  else
    System.out.println(nome + " Continua vivo ");
  }

  //método diminuir energia
  void diminuirEnergia(){
    this.energia--;
    if(this.energia <= 0){
      morrer();
    }
  }

  //método atacar
  void atacar(Personagem alvo){
    if(energia <= 0){
      System.out.println(nome + " está morto e não pode atacar");
    }
    if(alvo.energia <= 0){
      System.out.println(alvo.nome + " já esta morto " + nome + " não pode atacar um personagem morto");
      return;
    }
    if(energia >= 1){
      System.out.println(nome + " atacando " + alvo.nome + "!" );
      alvo.diminuirEnergia();
    }
    else{
      System.out.println(nome + " sem energia para atacar ");
    }
  }

//método de acesso que retorna valor energia
public int getEnergia() {
    return energia;
}
}


