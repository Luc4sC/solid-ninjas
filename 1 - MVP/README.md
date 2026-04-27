## 📜 Etapa 1: O Despertar do Código Genin (MVP)

Nesta primeira fase, o foco é a **funcionalidade bruta**. O objetivo é criar um código "Genin": funciona, mas é desorganizado, difícil de manter e com responsabilidades misturadas.

### 🎯 Objetivos Técnicos
- Criar um código funcional, porém **procedural**.
- Utilizar **Classes Anêmicas** (classes que possuem apenas dados, sem comportamento).
- Centralizar toda a lógica em uma única **God Class** (`ProcessadorMissao`).
- Ignorar, propositalmente, os princípios SOLID para fins de comparação posterior.

### 🧮 Regras de Negócio (Cálculos)
O sistema deve calcular o valor final líquido da missão seguindo esta ordem:

1.  **Valor Base por Rank**:
    - **Rank D**: Valor base original.
    - **Rank C**: +10% sobre o valor base.
    - **Rank B**: +20% sobre o valor base.
    - **Rank A**: +50% sobre o valor base.
    - **Rank S**: +100% sobre o valor base (dobro).

2.  **Bônus de Graduação**:
    - Se o Ninja for um **Jônin**, ele recebe um bônus adicional de **10%** sobre o valor acumulado até então.

3.  **Imposto de Konoha**:
    - Independente do ninja ou do rank, a Vila retira **5%** do valor total final para a manutenção da infraestrutura de Konoha.

### 🏗️ Estrutura Sugerida

- **`Ninja`**: Atributos `nome`, `graduação` (Genin, Chunin, Jonin), `Aldeia`, `Clã`.
- **`Missao`**: Atributos `id`, `rank` (D, C, B, A, S), `recompensa`.
- **`ProcessadorMissao`**: Possui o método `processar(Ninja ninja, Missao missao)`.
    - Deve conter os `ifs/switch` de cálculo.
    - Deve imprimir o resultado no console.

### ✅ Validação do Comportamento Esperado

| Cenário | Entrada | Saída Esperada (Líquido) |
| :--- | :--- | :--- |
| **Missão Simples** | Rank D (1000 Ryōs) / Genin | **950.00** |
| **Missão Rank A** | Rank A (1000 Ryōs) / Chunin | **1425.00** |
| **Missão Elite** | Rank S (2000 Ryōs) / Jônin | **4180.00** |
