## 📜 Etapa 4: O Caminho do Renegado (Aplicando LSP)

Nesta fase, o sistema enfrenta um novo desafio: processar missões para ninjas que não possuem mais vínculo com nenhuma vila (os **Nukenin** ou Renegados, como os membros da Akatsuki). O objetivo é aplicar o **Liskov Substitution Principle (Princípio de Substituição de Liskov)** para garantir que nossa hierarquia de classes seja consistente.

### 🎯 Objetivos Técnicos
- **LSP (Liskov Substitution Principle):** Garantir que qualquer subclasse de `Ninja` possa substituir a classe base sem quebrar o comportamento do `ProcessadorMissao`.
- **Refatoração de Contratos:** Ajustar os métodos da classe base para que reflitam comportamentos comuns a todos os ninjas, evitando exceções do tipo "não suportado".
- **Eliminação de `instanceof`:** O código não deve perguntar "quem é você?" para decidir como calcular; o objeto deve saber se comportar.

### 🛠️ O Desafio: O Problema do Registro de Konoha

Até agora, podíamos assumir que todo ninja tinha um nível (Genin, Chunin, Jonin) e uma Vila vinculada. 
No entanto, um **NinjaRenegado**:
1. Não possui graduação oficial reconhecida pelas Vilas (Bônus de Jonin não se aplica).
2. Não paga impostos para uma Vila específica (ou possui uma taxa fixa de "Mercado Negro").

**A Violação do LSP:** Se o seu `ProcessadorMissao` chamar um método `ninja.getGraduacao()` e o `NinjaRenegado` lançar uma `UnsupportedOperationException` (porque ele não tem graduação), você quebrou o LSP. O sistema espera um Ninja, mas o Renegado não consegue agir como um "Ninja padrão".

### 🏗️ A Refatoração Sugerida

Para respeitar o LSP, devemos garantir que o contrato da classe `Ninja` seja cumprido por todos:

1.  **Classe Base `Ninja`**: Deve conter apenas o que é universal (ex: `getNome()`, `getClã()`).
2.  **Especialização de Comportamento**: O cálculo de bônus por graduação (Jonin) deve ser movido para onde ele faz sentido. 
    * *Dica:* Talvez o bônus não deva ser perguntado ao Ninja, mas sim processado por uma regra que saiba lidar com "Ninjas da Vila".
3.  **Tratamento de Impostos**: Como na Etapa 3 criamos a interface `Tributacao`, um `NinjaRenegado` pode simplesmente usar uma implementação chamada `SemImposto` ou `TaxaMercadoNegro`, mantendo a compatibilidade com o `ProcessadorMissao`.

### 🏗️ Exemplo de Estrutura (Substituibilidade)

```java
// O Processador trata todos como Ninja
public void processar(Ninja ninja, Missao missao) {
    double valorBruto = regraRank.calcular(missao.getValorBase());
    double valorComBonus = valorBruto + ninja.obterBonusPorGraduacao(valorBruto);
    double valorLiquido = tributo.aplicar(valorBruto);
}
```

### ✅ Validação (O Teste da Akatsuki)

Para validar se o seu código atingiu a maestria no LSP, execute os seguintes testes de comportamento:

| Cenário de Teste | Entrada (Objeto) | Comportamento Esperado | Resultado para Sucesso |
| :--- | :--- | :--- | :--- |
| **Ninja de Konoha** | `NinjaDaVila` | Deve processar bônus e impostos normalmente. | Fluxo sem erros. |
| **Ninja da Akatsuki** | `NinjaRenegado` | Deve ignorar bônus de vila e impostos governamentais. | **Processamento concluído sem exceções ou `ifs` específicos.** |
| **Substituibilidade** | `Ninja` (Pai) | O código que funciona para o Pai deve funcionar para o Renegado. | Saída de valor coerente. |

**Dica de Jônin:** Se você conseguir passar um objeto `NinjaRenegado` para o `ProcessadorMissao` e ele imprimir o valor final corretamente sem que você tenha alterado uma única linha de código dentro do Processador, sua implementação de LSP está perfeita!
