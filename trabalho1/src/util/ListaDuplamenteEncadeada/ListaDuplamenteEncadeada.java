package util.ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoListaDupla<T> primeiro;

    public ListaDuplamenteEncadeada() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public void retirar(T info) {
        NoListaDupla<T> p = buscar(info);

        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    public NoListaDupla<T> buscar(T info) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void liberar() {
        NoListaDupla<T> p = primeiro;
        NoListaDupla<T> proximo;
        while (p != null) {
            proximo = p.getProximo();
            p.setProximo(null);
            p.setAnterior(null);
            p = proximo.getProximo();
        }
        primeiro = null;
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = primeiro;
        String resultado = "";

        while (p != null) {
            if (p == primeiro) {
                resultado += ", " + p.getInfo();
                p = p.getProximo();
            }
            if (p.getProximo() == null) {
                resultado = p.getInfo().toString() + resultado;
            } else {
                resultado = ", " + p.getInfo().toString() + resultado;
            }
            p = p.getProximo();
        }
        System.out.println(resultado);
    }

    @Override
    public String toString() {
        NoListaDupla<T> p = primeiro;
        String resultado = "";

        while (p != null) {
            if (p != primeiro) {
                resultado += ", ";
            }
            resultado += p.getInfo();
            p = p.getProximo();
        }
        return resultado;
    }

    public int obterUltimaPosicao(T valor) {
        NoListaDupla<T> p = primeiro;
        int pos = -1;
        int i = 0;
        
        while (p != null) {
            if (p.getInfo().equals(valor))
                pos = i;
            
            p = p.getProximo();
                i++;
            }
        return pos;
    }

    public NoListaDupla<T> obterNoIndice(int indice) {
        NoListaDupla<T> p = primeiro;
        if (p != null) {
            for (int i = 0; i != indice; i++) {
                p = p.getProximo();
            }
        }
        return p;
    }

    public ListaDuplamenteEncadeada<T> criarSubLista(int inicio, int fim) {
        if(inicio < 0)
            throw new IndexOutOfBoundsException();
        
        ListaDuplamenteEncadeada<T> nova = new ListaDuplamenteEncadeada<>();
        NoListaDupla<T> p = primeiro;
        int i = 0;
        
        while(p != null) {
           if(i >= inicio && i <= fim){
               nova.inserir(p.getInfo());
               if(i == fim)
                   break;
           }
           p = p.getProximo();
           i++;
        }
        return nova;
    }
}
