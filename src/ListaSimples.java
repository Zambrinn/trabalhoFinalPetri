public class ListaSimples implements EstruturaSimples {

    private Object[] elementos;
    private int tamanho;

    public ListaSimples(int size) {
        this.elementos = new Object[size];
        this.tamanho = 0;
    }

    @Override
    public void inserirElemento(Object elemento) {
        if (estaCheia()) {
            System.out.println("A lista está cheia, não é possivel inserir");
        }

        elementos[tamanho] = elemento; // insere o elemento na proxima posição
        tamanho++;
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        if (estaCheia()) {
            System.out.println("A lista está cheia, não é possivel inserir");
        }

        if ( indice < 0 || indice > tamanho ) { // Verifica se o indice está dentro dos limites válidos
            System.out.println("O índice é invalido");
        }

        for (int i = tamanho - 1; i >= indice; i++) { // Manda os elementos para a "direita" do vetor [1][2][3][4] [1][][3][4]
            elementos[i + 1] = elementos[i];
        }

        elementos[indice] = elemento; // Insere o novo elemento na posição
        tamanho++; // Aumenta o tamanho da lista
    }

    @Override
    public void inserirSequencia(Object[] elementos) {
        if (estaCheia()) {
            dobrarCapacidade();
        }

        for (int i = 0; i < elementos.length; i++) { // Percorre o vetor e insere cada elemento
            inserirElemento(elementos[i]);
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            return false;
        }

        elementos[tamanho - 1] = null; // remove o ultimo elemento
        tamanho--; // diminui o tamanho da lista
        return true;
    }

    @Override
    public Object removerIndice(int indice) {
        if (estaVazia() || indice < 0 || indice > tamanho) {
            return 0;
        }

        Object removido = elementos[indice]; // Fiz isso para guardar o elemento no indice para retornar ele depois

        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        tamanho--;
        return removido;
    }

    @Override
    public void removerSequencia(Object[] elementos) {

        if (estaVazia()) {
            System.out.println("A lista está vazia");
            return;
        }

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < elementos.length; j++) { // verifica o elemento da lista e ve se ta no vetor de elementos a serem removidos
                if (this.elementos[i].equals(elementos[j])) { // condicional para quando encontrar, remover o item da lista
                    for (int k = 0; k < tamanho - 1; k++) {
                        this.elementos[k] = elementos[k + 1];
                    }
                    tamanho--; // Diminui o tamanho da lista
                    i--; // mantem o indice ajustado para não pular nenhum elemento
                    break;
                }
            }
        }
    }
    

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        int j = 0; // Guardar elementos que não vão ser removidos
        for (int i = 0; i < tamanho; i++) {
            if (!elementos[i].equals(elemento)) { // Coloquei o.equals para caso passe uma ‘string’, o "==" nao seria tão eficaz
                elementos[j] = elementos[i];
                j++;
            }
        }
        tamanho = j;
    }

    @Override
    public boolean estaCheia() {
        return tamanho == elementos.length; // retorna true se o tamanho for igual ao tamanho maximo do vetor
    }

    @Override
    public boolean estaVazia() { // se o tamanho for 0 não existe elemento nele
        return tamanho == 0;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) { // Apenas procura um elemento especifico
                return true;
            }
        }
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
       if ( indice < 0 || indice >= tamanho ) { // Condicional, se o indice for menor que 0 ou o indice for maior/igual ao tamanho retorna nulo
           return null;
       }
       return elementos[indice]; //Retorna o elemento que está no indice
    }

    @Override
    public void ordenarCrescente() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (elementos[i] instanceof Integer && elementos[j] instanceof Integer) {
                    Integer firstValue = (Integer) elementos[i];
                    Integer secondValue = (Integer) elementos[j];

                    if (firstValue > secondValue) {
                        Object auxiliar = elementos[i];
                        elementos[i] = elementos[j];
                        elementos[j] = auxiliar;
                    }
                } else {
                    System.out.println("Erro: Elementos incompatíveis com ordenação (precisam ser inteiros).");
                    return; // ou você pode continuar, depende do comportamento que quiser
                }
            }
        }
        System.out.println("Fila ordenada em ordem crescente!!");
    }

    @Override
    public void ordenarDecrescente() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                Integer firstValue = (Integer) elementos[i];
                Integer secondValue = (Integer) elementos[j];

                if (firstValue < secondValue) {
                    Object auxiliar = elementos[i];
                    elementos[i] = elementos[j];
                    elementos[j] = auxiliar;
                }
            }
        }
        System.out.println("Fila ordenada em ordem decrescente!!");
    }

    @Override
    public int quantidadeElementos() {
        return tamanho;
    }

    @Override
    public void dobrarCapacidade() {
        if (elementos.length == tamanho) {
            Object[] novosElementos = new Object[elementos.length * 2]; // Cria o novo vetor

            for (int i = 0; i < elementos.length; i++) {
                novosElementos[i] = elementos[i]; // Copia os valores do vetor antigo para o novo
            }

            elementos = novosElementos;
        }
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elementoAntigo)) { // Compara o elemento e verifica se é igual ao que queremos substituir
                elementos[i] = elementoNovo; // Caso for igual, substitui pelo novo elemento
            }
        }
    }

    @Override
    public void limpar() {
        for (int i = 0; i < tamanho; i++) {
            elementos[i] = null; // Coloca "null" em cada posição do vetor (limpando a lista) [1][2][3] [null][null][null]
        }
        tamanho = 0;
    }

    @Override
    public void exibir() {
        if (estaVazia()) {
            System.out.println("A lista está vazia");
            return;
        }

        for (int i = 0; i < tamanho; i++) {
            System.out.println(elementos[i] + " "); // Passa cada posição e printa o valor
        }
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()) {
            return "A lista está vazia";
        }
        return elementos[0]; // Apenas retorna o primeiro elemento [1][2][3]
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) {
            return "A lista está vazia";
        }
        return elementos[tamanho - 1]; // Apenas retorna o último elemento
    }
}
