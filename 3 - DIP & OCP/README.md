## 📜 Etapa 3: A Maestria Jônin (OCP, DIP & O Tratado das Aldeias)

Nesta fase, o sistema de Konoha se expande para integrar a "Aliança Shinobi". Agora, o processamento de missões deve suportar não apenas a Vila da Folha, mas também outras aldeias como **Suna (Areia)** e **Kirigakure (Névoa)**, cada uma com suas próprias regras fiscais.

### 🎯 Objetivos Técnicos
- **OCP (Open/Closed Principle):** O sistema deve ser capaz de receber novos Ranks de missão e novas Aldeias sem que o código do `ProcessadorMissao` precise ser modificado.
- **DIP (Dependency Inversion Principle):** O `ProcessadorMissao` deixará de instanciar classes concretas e passará a depender de **Interfaces**.

### 🛠️ A Refatoração: Rumo à Extensibilidade

#### 1. Abstração de Ranks (Fim do Switch Case)
O cálculo por Rank (D, C, B, A, S) agora é extraído para uma interface.
- **Interface:** `RegraCalculoRank` com o método `double calcular(double valorBase)`.
- **Implementações:** `CalculoRankD`, `CalculoRankC`, `CalculoRankB`, `CalculoRankA`, `CalculoRankS`.

#### 2. O Desafio das Aldeias (Abstração de Impostos)
Para suportar o Tratado das Aldeias, a lógica de impostos foi abstraída:
- **Interface:** `Tributacao` com o método `double aplicar(double valor)`.
- **Implementações:** - `ImpostoKonoha`: Aplica 5%.
  - `ImpostoSuna`: Aplica 10%.
  - `ImpostoKiri`: Aplica 8%.

#### 3. Injeção de Dependência
O `ProcessadorMissao` agora recebe as interfaces necessárias via **Construtor**. Isso permite que o sistema seja montado de diferentes formas (ex: Missão Rank S em Suna) sem alterar o orquestrador.

### 🏗️ Estrutura de Código (DIP em Ação)

```java
public class ProcessadorMissao {
    private final RegraCalculoRank regra;
    private final Tributacao tributo;

    // O processador agora depende de abstrações, não de implementações (DIP)
    public ProcessadorMissao(RegraCalculoRank regra, Tributacao tributo) {
        this.regra = regra;
        this.tributo = tributo;
    }

    public void processar(Missao missao) {
        double valorBruto = regra.calcular(missao.getValorBase());
        double valorComBonus = valorBruto + calculaBonusPara(ninja);
        double valorLiquido = tributo.aplicar(valorComBônus);
    }
}
```
