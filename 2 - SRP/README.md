## 📜 Etapa 2: A Ascensão Chunin (Aplicando SRP)

Nesta segunda fase, aplicamos o **Single Responsibility Principle (Princípio da Responsabilidade Única)**. O objetivo é aumentar a coesão do sistema, garantindo que cada classe tenha apenas uma razão para existir e mudar.

### 🎯 Objetivos Técnicos
- Identificar responsabilidades múltiplas na "God Class" `ProcessadorMissao`.
- Extrair lógicas de cálculo e infraestrutura para classes especialistas.
- Transformar o `ProcessadorMissao` em um orquestrador de baixo acoplamento.

### 🛠️ A Refatoração
A lógica que antes estava amontoada em um único método agora deve ser dividida em:

1.  **`CalculadoraDeRecompensa`**: 
    - Método `calcular(Ninja ninja, Missao missao)`
    - Responsável apenas por aplicar as porcentagens dos Ranks e o bônus por nível Ninja.
2.  **`CalculadoraImposto`**:
    - Método `aplicarImposto(double valor)`
    - Responsável apenas pela regra tributária de 5% da Vila da Folha.
3.  **`MissaoRepository`**:
    - Método `salvar(Missao missao)`
    - Responsável por simular a persistência dos dados (Logs/DB).
4. **`Graduação`**
    - Responsável por conter dados e comportamentos relacionados a gradução. Por ex: porcentagem do Bonûs da missão.

### 🏗️ Nova Estrutura de Orquestração
O `ProcessadorMissao` deve ficar parecido com isso:
```java
public void processar(Ninja ninja, Missao missao) {
    double valorBruto = calculadora.calcular(ninja, missao);
    double valorLiquido = impostos.aplicarImposto(valorBruto);
    
    repository.salvar(missao);
}
```

