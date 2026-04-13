# 🏎️ Smart Parking & Care: Um Laboratório de SOLID

Bem-vindo ao **Smart Parking & Care**, um projeto desenvolvido para colocar em prática os ensinamentos do livro *"SOLID para Ninjas"*. Mais do que um simples sistema de gestão de estacionamento, este repositório é um registro de evolução arquitetural, onde cada etapa representa a superação de um desafio de design de software.

---

## 🎯 Objetivo do Projeto

O objetivo principal deste projeto é a aplicação rigorosa dos princípios **SOLID** em um ambiente controlado. A ideia é transformar um código inicialmente simples e acoplado em uma arquitetura de nível profissional, flexível o suficiente para aceitar novos requisitos sem "efeitos colaterais".

Ao longo do desenvolvimento, este projeto foca em:
- **S**ingle Responsibility: Classes com uma única razão para mudar.
- **O**pen-Closed: Sistema extensível para novos tipos de tarifas e veículos sem modificar o core.
- **L**iskov Substitution: Garantia de que a hierarquia de veículos é íntegra e confiável.
- **I**nterface Segregation: Contratos enxutos e específicos para serviços de valor agregado.
- **D**ependency Inversion: Acoplamento voltado para abstrações, facilitando testes e trocas de infraestrutura.

---

## 🏗️ O Sistema: Smart Parking & Care

O **Smart Parking & Care** gerencia o fluxo de entrada e saída de veículos em um pátio, mas com um diferencial: ele é um ecossistema modular.

### Funcionalidades:
* **Entrada e Saída Dinâmica:** Registro de Carros, Motos e Veículos Elétricos.
* **Motor de Tarifação:** Cálculo de permanência com arredondamento e suporte a múltiplas tabelas de preços (Padrão, Feriado, VIP).
* **Hub de Serviços Extras:** Implementação de serviços de conveniência (Lavagem, Recarga Elétrica, Manutenção) através de interfaces de capacidades.
* **Persistência Abstrata:** Preparado para rodar em memória, arquivos ou bancos de dados reais.

---

## 📈 Roteiro de Evolução

O projeto foi dividido em 5 etapas evolutivas, onde cada uma "limpa a bagunça" deixada pela anterior enquanto introduz um novo conceito:

1. **Etapa 1 (MVP):** Funcionalidade básica com código procedural/acoplado.
2. **Etapa 2 (SRP):** Refatoração e separação de responsabilidades.
3. **Etapa 3 (OCP & DIP):** Inversão de dependência e introdução de estratégias de cálculo.
4. **Etapa 4 (LSP):** Refinamento da hierarquia de veículos e contratos.
5. **Etapa 5 (ISP):** Segregação de serviços extras e habilidades específicas.

---

## 🥷 O Desafio Ninja

Se você encontrou este repositório e deseja dominar a arte do código limpo, aqui está o meu desafio para você:

**Não comece pelo final.** Tente implementar a **Etapa 1** da forma mais simples possível. Sinta a dor de ter que alterar cinco lugares diferentes para mudar o preço de uma tarifa. Veja o código "gritar" por ajuda quando você tenta adicionar um serviço extra. 

Somente quando você sentir o peso do acoplamento, aplique o próximo princípio do SOLID. A verdadeira maestria não vem de escrever código bonito de primeira, mas de saber exatamente **por que** e **como** transformar um código rígido em uma solução elegante e sustentável.

**Você está pronto para refatorar até a excelência?**

---
*Este projeto foi inspirado pelos conceitos de Maurício Aniche em "SOLID para Ninjas".*