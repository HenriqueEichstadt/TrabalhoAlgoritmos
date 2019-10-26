package util.ListaEncadeada;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    /*
     * Construtor padrão, Cria lista vazia 
     */
    public ListaEncadeada() {
        NoLista<T> novo = new NoLista();
    }

    /**
     * Getter da variável primeiro
     * @return Preimeiro nó da lista
     */
    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    /**
     * Insere um novo valor na lista
     * @param info valor a ser inserido na lista
     */
    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    /**
     *  Avalia se a lista está vazia ou não
     * @return True se a lista está vazia
     */
    public boolean estaVazia() {
        return primeiro == null;
    }

    /**
     * Bsuca um nó na lista encadeada
     * @param info dado a ser localizado
     * @return Nó contendo o dado a ser localizado
     */
    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info))
                return p;
            
            p = p.getProximo();
        }
        return null;
    }

    /**
     * Retira um dado da lista encadeada
     * @param info Dado a ser retirado da lista encadeada
     */
    public void retirar(T info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        // procura o nó que contém o dado a ser removido
        //guardando o anterior
        while ((p != null && !p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }

        // se achou o nó, retira-o da lista
        if (p != null) {
            if (anterior == null) {
                    primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    /**
     * Calcula a quantidade de nós da lista
     * @return quantidade de elementos da lista
     */
    public int obterComprimento() {
        int qtdDeNos = 0;
        NoLista<T> p = primeiro;
        
        while (p != null) {
            qtdDeNos++;
            p = p.getProximo();
        }
        return qtdDeNos;
    }

    /**
     * Obtém um nó da lista, partindo da posição do nó na lista
     * @param idx Posição do nó na lista
     * @return Nó
     */
    public NoLista<T> obterNo(int idx) {
        if(idx < 0)
            throw new IndexOutOfBoundsException();
        
        NoLista<T> p = getPrimeiro();
        for(int i = 0; (p != null) && (i < idx); i++){
            p = p.getProximo();
        }
        
        //   NoLista<T> p = getPrimeiro();
        //   while((p != null) && (idx > 0)){
        //   idx--;
        //   }
        
        if(p == null)
            throw new IndexOutOfBoundsException();
        return p;
    }

    @Override
    public String toString() {
        NoLista<T> p = primeiro;
        String resultado = "";

        while(p != null){
            if(p != primeiro){
                resultado += ", ";
            }
            resultado += p.getInfo().toString();
            p = p.getProximo();
        }
        return resultado;
    }
}
