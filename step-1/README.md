# 🏎️ Smart Parking & Care - Etapa 1: O MVP Funcional

Este projeto faz parte de uma série de estudos práticos sobre os princípios **SOLID** aplicados em Java, inspirados na leitura do livro *SOLID para Ninjas*. O objetivo desta primeira etapa é criar um sistema funcional de gerenciamento de estacionamento, permitindo que a "dificuldade de manutenção" surja naturalmente para ser resolvida através de refatoração nas etapas seguintes.

---

## 🎯 Objetivo da Etapa
Construir o "Mínimo Viável" (MVP) que permita registrar a entrada e saída de veículos (Carros e Motos) e calcular o valor devido com base no tempo de permanência. 

> **💡 Nota Mental:** Nesta fase, o foco é **funcionalidade**. É permitido que a lógica de negócio, o cálculo e a exibição estejam acoplados. Isso servirá de "âncora" para sentirmos a necessidade do **SOLID** no futuro.

---

## 🚀 Funcionalidades Esperadas
- [ ] **Check-in:** Registrar a entrada de um veículo capturando a data/hora atual.
- [ ] **Check-out:** Registrar a saída de um veículo buscando-o pela placa.
- [ ] **Cálculo de Tarifa:**
    - **Carro:** R$ 10,00 por hora.
    - **Moto:** R$ 5,00 por hora.
- [ ] **Recibo:** Exibir um resumo detalhado no console ao finalizar a estadia.

---

## 📏 Regras de Negócio Iniciais
1. **Arredondamento:** Qualquer fração de hora deve ser cobrada como uma hora cheia (ex: 1h e 5min deve ser cobrado como 1 hora e, 1h e 40min deve ser cobrado como 2 horas).
2. **Identificação:** A placa é o identificador único. Não podem existir dois veículos com a mesma placa no pátio simultaneamente.
3. **Persistência:** Os dados devem ser mantidos em memória (ex: `List` ou `Map`) enquanto a aplicação estiver rodando.

---

## 🛠️ Sugestão de Estrutura de Classes
Para guiar o início do seu desenvolvimento, considere criar:

* `Veiculo`: Classe base (ou pai) contendo os atributos comuns.
* `Ticket`: Classe para associar o veículo aos registros de tempo.
* `EstacionamentoService`: Onde ficará a lógica principal de entrada, saída e cálculo.

---

## 📝 Exemplo de Saída Esperada (CLI)
```text
--- Entrada Registrada ---
Placa: ABC-1234 | Modelo: Honda Civic | Entrada: 14:00

--- Saída Finalizada ---
Veículo: ABC-1234
Permanência: 2 horas e 15 minutos
Valor Total: R$ 30,00 (Tarifa: Carro)
