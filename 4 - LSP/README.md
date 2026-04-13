# 🏎️ Smart Parking & Care - Etapa 4: LSP (Liskov Substitution Principle)

Nesta etapa, o foco é a **integridade da herança**. O Princípio de Substituição de Liskov nos diz que as subclasses (Carro, Moto, Caminhão) devem poder ser substituídas por sua classe base (Veiculo) sem que o sistema quebre ou se comporte de forma inesperada.

---

## 🎯 Objetivo da Etapa
Refinar a hierarquia de classes de veículos para garantir que o `EstacionamentoService` possa tratar qualquer veículo de forma genérica, eliminando "hacks" de código ou comportamentos forçados.

---

## 🏗️ O que deve ser feito

### 1. Refatoração da Classe Base (`Veiculo`)
Analise os métodos da sua classe abstrata ou interface pai. 
* **O que fazer:** Remova qualquer comportamento que não seja comum a **todos** os veículos. 
* **O Perigo:** Se `Veiculo` tem um método `abrirPortaMalas()` e a classe `Moto` precisa lançar uma `UnsupportedOperationException`, você violou o LSP.

### 2. Eliminação do `instanceof`
Verifique se no seu `EstacionamentoService` ou na `Calculadora` existe algum código que pergunta: `if (veiculo instanceof Carro)`.
* **Ação:** O comportamento específico deve ser resolvido através do polimorfismo ou de propriedades da classe, não por checagem de tipo em tempo de execução.
* **Meta:** O Service deve chamar métodos de `Veiculo` e obter resultados corretos, não importa se o objeto real é um Carro ou uma Moto.

### 3. Contratos de Pré-condição e Pós-condição
Garanta que as subclasses não "afrouxem" nem "apertem" demais as regras da classe pai.
* **Exemplo:** Se a classe base diz que o método `getPlaca()` nunca retorna nulo, nenhuma subclasse pode passar a permitir nulo.

---

## 📏 O Teste do "Ninja"
Você saberá que o LSP foi bem aplicado se:

1. **Substituição Real:** Você puder criar uma lista `List<Veiculo>` contendo Carros, Motos e Caminhões, e processar a saída de todos usando o mesmo loop, sem nenhum `if` para distinguir o tipo.
2. **Sem Exceções Surpresa:** Nenhum método herdado nas subclasses "cospe" um erro por não fazer sentido para aquele tipo de veículo.
3. **Comportamento Previsível:** O estado do sistema permanece consistente, independentemente de qual subclasse de `Veiculo` está sendo processada.

---

## 📝 Reflexão: O erro clássico do Quadrado e Retângulo
Lembre-se do exemplo clássico: "Um quadrado é um retângulo, mas se o método `setLargura` do Quadrado altera também a `altura`, ele quebra a expectativa de quem espera um Retângulo". No nosso sistema, certifique-se de que uma `Moto` se comporte exatamente como um `Veiculo` deve se comportar.

---

> **Próxima Parada:** ISP (Interface Segregation Principle) - Criando interfaces específicas para Lavagem e Recarga Elétrica!