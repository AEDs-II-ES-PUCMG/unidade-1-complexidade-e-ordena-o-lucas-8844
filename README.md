[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/juL8mNP7)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=22880994&assignment_repo_type=AssignmentRepo)

# AEDs II: Complexidade e Métodos de Ordenação

Atividade prática da disciplina de **Algoritmos e Estruturas de Dados II** com foco na análise de complexidade de algoritmos e implementação de métodos de ordenação.

## 👤 Aluno

- **Nome:** Lucas
- **Período:** 2026.1
- **Turma:** G2 - Noite

## 📚 Descrição do Projeto

Este projeto implementa e compara três algoritmos clássicos de ordenação, analisando suas características de desempenho em termos de comparações, movimentações e tempo de execução.

### Algoritmos Implementados

1. **Bubble Sort (Ordenação por Bolha)**
   - Complexidade: **O(n²)** no pior caso
   - Estratégia: Compara elementos adjacentes e troca se estiverem fora de ordem
   - Melhor para: Vetores pequenos ou quase ordenados

2. **Insertion Sort (Ordenação por Inserção)**
   - Complexidade: **O(n²)** no pior caso, O(n) no melhor caso
   - Estratégia: Insere cada elemento na posição correta do vetor parcialmente ordenado
   - Melhor para: Vetores pequenos e parcialmente ordenados

3. **Selection Sort (Ordenação por Seleção)**
   - Complexidade: **O(n²)** no todos os casos
   - Estratégia: Encontra o menor elemento e o coloca na posição correta
   - Melhor para: Minimizar movimentações de dados

## 📁 Estrutura do Projeto

```
src/
├── App.java              # Classe principal com testes comparativos
├── IOrdenador.java       # Interface genérica para algoritmos de ordenação
├── BubbleSort.java       # Implementação do Bubble Sort
├── InsertionSort.java    # Implementação do Insertion Sort
└── SelectionSort.java    # Implementação do Selection Sort
```

## 🚀 Como Executar

### Compilação

```bash
javac src/*.java
```

### Execução

```bash
java -cp src App
```

### Saída Esperada

O programa executa testes com vetores de tamanhos variados (10, 100, 1.000 e 10.000 elementos) e exibe:
- Número de comparações realizadas
- Número de movimentações realizadas
- Tempo de execução em milissegundos
- Verificação se a ordenação está correta

## 📊 Análise Comparativa dos Resultados

### Teste com 100 Elementos

| Algoritmo | Comparações | Movimentações | Tempo (ms) |
|-----------|------------|---------------|-----------|
| Bubble Sort | 4.950 | 6.555 | 0,4226 |
| Insertion Sort | 2.281 (46,1%) | 2.284 | 0,1186 |
| Selection Sort | 4.950 | 273 | 0,1889 |

### Teste com 1.000 Elementos

| Algoritmo | Comparações | Movimentações | Tempo (ms) |
|-----------|------------|---------------|-----------|
| Bubble Sort | 499.500 | 727.650 | 8,7890 |
| Insertion Sort | 243.542 (48,8%) | 243.549 | 6,8260 |
| Selection Sort | 499.500 | 2.973 | 6,0251 |

### Teste com 10.000 Elementos

| Algoritmo | Comparações | Movimentações | Tempo (ms) |
|-----------|------------|---------------|-----------|
| Bubble Sort | 49.995.000 | 75.918.840 | 329,5210 |
| Insertion Sort | 25.316.271 (50,6%) | 25.316.279 | 159,7978 |
| Selection Sort | 49.995.000 | 29.979 | 221,6125 |

## 🔍 Conclusões

### Pontos-chave observados:

1. **Insertion Sort** é o mais eficiente em comparações
   - Realiza aproximadamente 50% menos comparações que Bubble Sort
   - Melhor desempenho geral em vetores aleatórios

2. **Selection Sort** é excelente em minimizar movimentações
   - Realiza ~99% menos movimentações que Bubble Sort
   - Número de comparações é sempre n(n-1)/2, independente dos dados

3. **Bubble Sort** é o mais lento
   - Máximo de comparações em todos os casos
   - Alto número de movimentações
   - Útil apenas para fins educacionais ou vetores pequenos

4. **Escala Quadrática**
   - Todos os três algoritmos apresentam crescimento O(n²)
   - Ao aumentar o tamanho em 10x, o tempo aumenta aproximadamente 100x

### Recomendações:

- ✅ Use **Insertion Sort** para vetores pequenos (< 1.000 elementos)
- ✅ Use algoritmos mais eficientes (Quick Sort, Merge Sort) para vetores grandes
- ❌ Evite Bubble Sort em produção

## 🛠 Tecnologias Utilizadas

- **Linguagem:** Java 11+
- **IDE:** Visual Studio Code
- **Controle de Versão:** Git/GitHub

## 📝 Tarefas Completadas

- ✅ Tarefa 0: Entendimento teórico e setup do repositório
- ✅ Tarefa 1: Implementação de BubbleSort e InsertionSort com testes
- ✅ Tarefa 2: Implementação de SelectionSort e análise comparativa de desempenho

## 📖 Interface IOrdenador

A interface genérica define o contrato para todos os ordenadores:

```java
public interface IOrdenador<T> {
    public T[] ordenar(T[] dados);           // Ordena o vetor
    public int getComparacoes();             // Retorna número de comparações
    public int getMovimentacoes();           // Retorna número de movimentações
    public double getTempoOrdenacao();       // Retorna tempo em milissegundos
}
```

## 📜 Licença

Este projeto é parte da disciplina de AEDs II da PUC Minas.
