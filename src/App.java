import java.util.Arrays;
import java.util.Random;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }


    public static void main(String[] args) {
        // Testes com diferentes tamanhos
        int[] tamanhos = { 10, 100, 1000, 10000 };
        
        System.out.println("╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║       COMPARAÇÃO DOS ALGORITMOS DE ORDENAÇÃO                           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝\n");
        
        for (int tamanho : tamanhos) {
            System.out.println("═".repeat(75));
            System.out.println("TESTE COM VETOR DE TAMANHO: " + tamanho);
            System.out.println("═".repeat(75));
            
            // Gera o mesmo vetor para todos os algoritmos
            Integer[] vetor = gerarVetorObjetos(tamanho);
            Integer[] vetorCopia;
            
            // ===== BUBBLE SORT =====
            System.out.println("\n► BUBBLE SORT");
            System.out.println("-".repeat(75));
            vetorCopia = Arrays.copyOf(vetor, vetor.length);
            BubbleSort<Integer> bubbleSort = new BubbleSort<>();
            Integer[] vetorOrdenadoBubble = bubbleSort.ordenar(vetorCopia);
            
            System.out.printf("  Comparações:       %,d%n", bubbleSort.getComparacoes());
            System.out.printf("  Movimentações:     %,d%n", bubbleSort.getMovimentacoes());
            System.out.printf("  Tempo (ms):        %.4f%n", bubbleSort.getTempoOrdenacao());
            
            // ===== INSERTION SORT =====
            System.out.println("\n► INSERTION SORT");
            System.out.println("-".repeat(75));
            vetorCopia = Arrays.copyOf(vetor, vetor.length);
            InsertionSort<Integer> insertionSort = new InsertionSort<>();
            Integer[] vetorOrdenadoInsertion = insertionSort.ordenar(vetorCopia);
            
            System.out.printf("  Comparações:       %,d%n", insertionSort.getComparacoes());
            System.out.printf("  Movimentações:     %,d%n", insertionSort.getMovimentacoes());
            System.out.printf("  Tempo (ms):        %.4f%n", insertionSort.getTempoOrdenacao());
            
            // ===== SELECTION SORT =====
            System.out.println("\n► SELECTION SORT");
            System.out.println("-".repeat(75));
            vetorCopia = Arrays.copyOf(vetor, vetor.length);
            SelectionSort<Integer> selectionSort = new SelectionSort<>();
            Integer[] vetorOrdenadoSelection = selectionSort.ordenar(vetorCopia);
            
            System.out.printf("  Comparações:       %,d%n", selectionSort.getComparacoes());
            System.out.printf("  Movimentações:     %,d%n", selectionSort.getMovimentacoes());
            System.out.printf("  Tempo (ms):        %.4f%n", selectionSort.getTempoOrdenacao());
            
            // ===== RESUMO E ANÁLISE =====
            System.out.println("\n" + "▌".repeat(75));
            System.out.println("RESUMO COMPARATIVO:");
            System.out.println("▌".repeat(75));
            
            System.out.println("\n📊 COMPARAÇÕES:");
            System.out.printf("   Bubble Sort:      %,d%n", bubbleSort.getComparacoes());
            System.out.printf("   Insertion Sort:   %,d (%.1f%% do Bubble)%n", 
                insertionSort.getComparacoes(), 
                (insertionSort.getComparacoes() * 100.0) / bubbleSort.getComparacoes());
            System.out.printf("   Selection Sort:   %,d%n", selectionSort.getComparacoes());
            
            System.out.println("\n📊 MOVIMENTAÇÕES:");
            System.out.printf("   Bubble Sort:      %,d%n", bubbleSort.getMovimentacoes());
            System.out.printf("   Insertion Sort:   %,d%n", insertionSort.getMovimentacoes());
            System.out.printf("   Selection Sort:   %,d%n", selectionSort.getMovimentacoes());
            
            System.out.println("\n⏱️  TEMPO DE EXECUÇÃO:");
            System.out.printf("   Bubble Sort:      %.4f ms%n", bubbleSort.getTempoOrdenacao());
            System.out.printf("   Insertion Sort:   %.4f ms%n", insertionSort.getTempoOrdenacao());
            System.out.printf("   Selection Sort:   %.4f ms%n", selectionSort.getTempoOrdenacao());
            
            // Verifica se os vetores foram ordenados corretamente
            boolean bubbleOk = verificarOrdenacao(vetorOrdenadoBubble);
            boolean insertionOk = verificarOrdenacao(vetorOrdenadoInsertion);
            boolean selectionOk = verificarOrdenacao(vetorOrdenadoSelection);
            
            System.out.println("\n✓ VERIFICAÇÃO:");
            System.out.println("   Bubble Sort:      " + (bubbleOk ? "✓ CORRETO" : "✗ INCORRETO"));
            System.out.println("   Insertion Sort:   " + (insertionOk ? "✓ CORRETO" : "✗ INCORRETO"));
            System.out.println("   Selection Sort:   " + (selectionOk ? "✓ CORRETO" : "✗ INCORRETO"));
            System.out.println();
        }
        
        System.out.println("═".repeat(75));
        System.out.println("TESTES CONCLUÍDOS COM SUCESSO!");
        System.out.println("═".repeat(75));
    }
    
    /**
     * Verifica se um vetor está corretamente ordenado em ordem crescente.
     * @param vetor Vetor a ser verificado.
     * @return true se o vetor está ordenado, false caso contrário.
     */
    static boolean verificarOrdenacao(Integer[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
