package util.ListaEstatica;

public class ListaEstatica<T> {

    private T[] info;
    private int tamanho;
    private final byte TAMANHO_INICIAL = 10;

    public ListaEstatica() {
        info = (T[])new Object[TAMANHO_INICIAL];
        tamanho = 0;
    }

    public void inserir(T valor) {
        /* Verificar se o tamanho do vetor é o suficiente para guardar o valor
           Caso não seja, irá aumentar seu tamanho */
        redimensionar(tamanho + 1);
        // Atribui o valor na próxima posição
        info[tamanho] = valor;
        tamanho++;
    }

    public int buscar(T item) {
        int indiceDoItem = -1; //retorna -1 se não encontrar o item
        for (int i = 0; i < tamanho; i++) {

            T itemAtual = info[i];
            if (item.equals(itemAtual)) {
                indiceDoItem = i;
                break;
            }
        }
        return indiceDoItem;
    }

    public void retirar(T item) {
        // encontrar o indice do item a ser removido
        int indiceDoItem = buscar(item);

        // Quando não encontrou o item
        if (indiceDoItem == -1) {
            return;
        }

        // remover o item
        for (int i = indiceDoItem; i < tamanho - 1; i++) {
            info[i] = info[i + 1];
        }
        // decrementar o tamanho do vetor/proxima Posição a ser ocupada
        tamanho--;
    }

    public void liberar() {
        info = (T[])new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int indice) {
        if (indice < 0 || indice >= tamanho) {
            // Quando o argumento está fora do intervalo de valores permitido
            throw new IndexOutOfBoundsException();
        }
        return info[indice];
    }

    public boolean estaVazia() {
        return (info[1] != null);
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String dadosAExibir = "";
        
        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                dadosAExibir += ", ";
            }
            
            dadosAExibir += info[i];
        }
        return dadosAExibir;
    }

    public void exibir() {

        System.out.println("Eu tenho " + info.length + " posições.");
        System.out.println(tamanho + " delas estão ocupadas.");
        System.out.println("Valores em cada posição");
        System.out.println(toString());
    }
    
    private void redimensionar(int tamanhoNecessario) {

        // Se o tamanho do vetor é maior que o tamanho que necessito;
        if (info.length >= tamanhoNecessario)
            return;

        // Gerar um novo tamanho para o vetor
        int novoTamanho = info.length + 10;
        if (novoTamanho < tamanhoNecessario) {
            novoTamanho = tamanhoNecessario;
        }

        // instanciando novo vetor com tamanho maior
        T[] novoVetor = (T[])new Object[novoTamanho];

        // Atribuir os valores do vetor antigo para o novo
        for (int indice = 0; indice < info.length; indice++) {
            novoVetor[indice] = info[indice];
        }
        // atribuir o novo vetor ao antigo
        info = novoVetor;
    }
}
