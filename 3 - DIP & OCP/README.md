# 🏎️ Smart Parking & Care - Etapa 3: OCP & DIP

Nesta fase, o projeto deixa de ser um sistema "fixo" e passa a ser uma estrutura **plugável**. Aplicaremos o **Princípio Aberto/Fechado (OCP)** e o **Princípio da Inversão de Dependência (DIP)** para garantir que o núcleo do sistema seja protegido contra mudanças externas.

---

## 🎯 Objetivo da Etapa
Transformar o sistema em uma estrutura modular onde as peças (cálculo, armazenamento, exibição) podem ser trocadas como blocos de montar, utilizando **Abstrações (Interfaces)** em vez de implementações concretas.

---

## 🏗️ O que deve ser feito

### 1. Aplicando o OCP (Open-Closed Principle)
O motor de cálculo não deve mais conter lógica fixa (`if/else`) para decidir preços com base no tipo de veículo ou data.
* **Ação:** Criar uma interface para a estratégia de tarifação (ex: `TarifaStrategy`).
* **Meta:** Permitir a criação de novas regras (Tarifa de Domingo, Tarifa VIP, Promoção) apenas criando novas classes, sem precisar abrir ou modificar o `EstacionamentoService`.

### 2. Aplicando o DIP (Dependency Inversion Principle)
A lógica de negócio não deve mais "saber" como os dados são salvos ou como o cálculo é realizado internamente.
* **Ação:** Remover todos os instanciamientos diretos (`new`) de dentro do `EstacionamentoService`.
* **Inversão:** O Service deve receber suas ferramentas (Calculadora, Repositório, Printer) através do **construtor**. Ele passa a depender de contratos (interfaces) e não de classes específicas.



### 3. Desacoplamento de Infraestrutura
Isolar completamente a forma como as informações são persistidas.
* **Ação:** Criar uma interface para o Repositório de Tickets.
* **Meta:** O sistema deve ser capaz de trocar o armazenamento de "Memória" para "Banco de Dados" ou "Arquivo TXT" apenas trocando a implementação injetada no Service, sem alterar a regra de negócio.

---

## 📏 O Teste do "Ninja"
Você saberá que concluiu esta etapa com sucesso se:

1. **Extensibilidade:** Conseguir adicionar um novo modelo de cobrança apenas criando uma classe nova, sem tocar no código do Service.
2. **Testabilidade:** Conseguir testar o `EstacionamentoService` passando versões "Mock" ou "Fake" das dependências.
3. **Abstração:** O `EstacionamentoService` não conhece nenhuma classe concreta de infraestrutura, apenas interfaces.

---

## 📝 Mudança de Visão
Nesta etapa, você deixa de programar focado em **"Como eu faço isso?"** e passa a programar focado em **"O que eu preciso que seja feito?"**. O Service define o contrato, e o mundo externo provê as ferramentas.

---

> **Próxima Parada:** LSP (Liskov Substitution Principle) - Refinando a hierarquia de veículos!