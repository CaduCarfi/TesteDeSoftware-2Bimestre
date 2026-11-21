# Semana 10 — Prática de TDD (Java + JUnit 5)

Quatro projetos Maven desenvolvidos com **TDD** (RED → GREEN → REFACTOR), usando Java 17, JUnit 5 e JaCoCo para cobertura.

## Projetos

| Projeto | Descrição | Testes | Cobertura |
|---|---|---|---|
| [`bubblesort-tdd`](bubblesort-tdd) | Ordenação de vetor de inteiros com Bubble Sort | 7 | 100% |
| [`carrinho-compras-tdd`](carrinho-compras-tdd) | Carrinho com total, remoção, validação de preço e desconto de 10% a partir de R$ 500 | 14 | 100% |
| [`conta-bancaria-tdd-maven`](conta-bancaria-tdd-maven) | Conta com depósito e saque, sem saldo negativo | 9 | 100% |
| [`estoque-tdd`](estoque-tdd) | Controle de estoque de produto, sem quantidades inválidas | 10 | 100% |

Cobertura de linhas e de branches.

## Como executar

Pré-requisitos: JDK 17+ e Maven.

Dentro de cada projeto:

```bash
mvn test       # executa os testes
mvn verify     # executa os testes e exige 100% de cobertura (JaCoCo)
```

O relatório de cobertura é gerado em `target/site/jacoco/index.html`.

## Decisões de implementação

- **Carrinho, preço negativo:** lança `IllegalArgumentException` (o mesmo vale para produto nulo).
- **Conta e estoque, operações inválidas** (valores negativos ou zero, saque ou retirada acima do disponível): são ignoradas, sem alterar o estado.
- **Carrinho, desconto:** 10% quando o subtotal é **maior ou igual** a R$ 500,00.
- Os testes fornecidos originalmente não foram alterados. Só foram acrescentados testes de casos de borda.

## Estrutura

```text
SEMANA10/
├── bubblesort-tdd/
├── carrinho-compras-tdd/
├── conta-bancaria-tdd-maven/
└── estoque-tdd/
```

Cada projeto contém `src/main` (implementação), `src/test` (testes) e `pom.xml`.
