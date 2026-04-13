# 🥷 Smart Parking & Care - Etapa 2: Aplicando o SRP

Agora que temos o sistema funcionando, o desafio é aplicar o **Single Responsibility Principle (SRP)**. No livro *SOLID para Ninjas*, aprendemos que uma classe deve ter uma única razão para existir e mudar. 

Na Etapa 1, nossa classe `Main` provavelmente está fazendo "coisas demais": calculando valores, salvando dados e formatando mensagens para o console. Vamos resolver isso!

---

## 🎯 Objetivo da Etapa
Refatorar o código inicial, extraindo responsabilidades para classes menores e altamente coesas. A `Main` deve deixar de ser um "faz-tudo" para se tornar um **orquestrador**.

---

## 📏 O Teste do "Ninja"
Seu código estará no caminho certo se você puder responder **SIM** para estas perguntas:

1. Se eu quiser mudar o preço da moto, eu altero **apenas** a Classe que contém as regras de calcúlo?
2. Se eu quiser mudar o texto "Valor Total" para "Total a Pagar", eu altero **apenas** a Classe de retorno?
3. Se eu decidir usar um banco de dados real, a lógica de cálculo de preço permanece **intocada**?
