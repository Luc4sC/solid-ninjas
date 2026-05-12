## 📜 Etapa 5: Formação de Equipes e o ISP (Interface Segregation Principle)

Agora que nosso sistema é extensível e depende de abstrações, precisamos garantir que as Missões recebam as equipes certas. Nem todo Ninja é um médico, e nem todo Ninja é um rastreador.

### 🎯 Objetivos Técnicos
* **ISP (Interface Segregation Principle):** Criar interfaces específicas para habilidades (**Lutador**, **Curador**, **Furtivo**) em vez de uma interface única e pesada para todos os Ninjas.
* **Validação de Requisitos:** Implementar uma lógica onde a Missão define quais "contratos" de habilidades a equipe precisa assinar para ser enviada.

---

### 🛠️ A Refatoração: O Princípio da Segregação de Interface

#### 1. Segregando Habilidades
Em vez de uma interface `Ninja` com métodos como `curar()` e `rastrear()`, dividimos em interfaces menores. Assim, um Ninja que não sabe curar não é obrigado a implementar esse método.

* **Interface:** `Lutador` -> `atacar()`
* **Interface:** `Médico` -> `curar()`
* **Interface:** `Rastreador` -> `rastrear()`

#### 2. Implementações Específicas
Os Ninjas agora implementam apenas o que lhes cabe:

* **Naruto:** `implements Lutador`
* **Sakura:** `implements Lutador, Médico`
* **Neji:** `implements Lutador, Rastreador`

---

### 🏗️ Estrutura de Código (ISP e Validação de Equipe)

Abaixo, veja como a Missão utiliza essas interfaces para validar a equipe sem conhecer as classes concretas dos Ninjas:

```java
public class MissaoReconhecimento {
    private final List<Ninja> equipe;

    public MissaoReconhecimento(List<Ninja> equipe) {
        this.equipe = equipe;
    }

    public void iniciarMissao() {
        if (!validarRequisitos()) {
            throw new EquipeInvalidaException("A equipe não possui os especialistas necessários!");
        }
        System.out.println("Missão iniciada com sucesso!");
    }

    private boolean validarRequisitos() {
        // A Missão de Reconhecimento exige pelo menos um Ninja de cada tipo:
        boolean temLutador = equipe.stream().anyMatch(n -> n instanceof Lutador);
        boolean temCurador = equipe.stream().anyMatch(n -> n instanceof Curador);
        boolean temFurtivo = equipe.stream().anyMatch(n -> n instanceof Furtivo);

        return temLutador && temCurador && temFurtivo;
    }
}