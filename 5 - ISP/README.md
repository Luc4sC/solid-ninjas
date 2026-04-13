# 🏎️ Smart Parking & Care - Etapa 5: ISP (Interface Segregation Principle)

Nesta etapa final, vamos expandir o negócio! O estacionamento agora oferece serviços extras como **Lavagem** e **Recarga Elétrica**. O desafio é adicionar essas funcionalidades sem obrigar todos os veículos a "saberem" sobre elas. O Princípio da Segregação de Interface diz que uma classe não deve ser forçada a depender de métodos que ela não utiliza.

---

## 🎯 Objetivo da Etapa
Implementar serviços opcionais de forma modular, garantindo que as interfaces sejam específicas para cada necessidade e que as classes implementem apenas o que realmente lhes cabe.

---

## 🏗️ O que deve ser feito

### 1. Criação de Interfaces Específicas
Em vez de criar uma interface gigante chamada `ServicosExtras`, você deve fatiar as habilidades em interfaces menores.
* **Ação:** Crie interfaces como `Lavavel` (com o método `lavar()`) e `Carregavel` (com o método `recarregar()`).
* **Meta:** Separar as "capacidades" do veículo. Nem todo carro é elétrico, e nem todo veículo pode ser lavado (ex: um carro de coleção com pintura especial).

### 2. Implementação Seletiva nas Subclasses
Agora, aplique essas interfaces apenas onde elas fazem sentido.
* **Exemplo:** - A classe `CarroEletrico` implementará `Lavavel` e `Carregavel`.
    - A classe `MotoGasolina` implementará apenas `Lavavel`.
    - Uma classe `Bicicleta` (se houver) não implementará nenhuma das duas.



### 3. Ajuste no Fluxo de Saída (Checkout)
O `EstacionamentoService` deve ser capaz de verificar se um veículo possui determinada "habilidade" antes de oferecer ou cobrar pelo serviço.
* **Ação:** No momento do checkout, o sistema deve verificar se o serviço extra foi solicitado e se o veículo é compatível com aquele serviço.

---

## 📏 O Teste do "Ninja"
Você saberá que o ISP foi bem aplicado se:

1. **Interfaces Magras:** Suas interfaces de serviço têm apenas o que é estritamente necessário (coesão alta).
2. **Sem Métodos "Mudos":** Você não tem nenhuma classe com métodos vazios ou que lançam erro apenas para satisfazer uma interface (ex: `Moto` tendo que implementar `recarregar()` sem fazer nada).
3. **Facilidade de Expansão:** Se você decidir adicionar o serviço de "Troca de Óleo", bastará criar a interface `TrocaDeOleo` e aplicá-la apenas aos veículos a combustão, sem afetar os elétricos.

---

## 📝 Reflexão Final: O Poder das Habilidades
Ao usar o ISP, você para de ver o objeto apenas como "um tipo de coisa" (Herança) e passa a vê-lo também como "um conjunto de capacidades" (Interfaces). Isso torna seu código absurdamente flexível para novos modelos de negócio.

---

## 🎉 Parabéns!
Ao concluir esta etapa, você terá percorrido todo o caminho do **SOLID**:
- **S:** Responsabilidades divididas.
- **O:** Extensível por novas classes.
- **L:** Subclasses confiáveis.
- **I:** Interfaces enxutas e específicas.
- **D:** Dependência total de abstrações.

Você agora tem um sistema **Smart Parking & Care** com arquitetura de nível profissional!