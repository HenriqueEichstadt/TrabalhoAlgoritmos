package util.Pilhas;

import util.ListaEncadeada.ListaEncadeada;
import util.ListaEncadeada.NoLista;

public class PilhaLista<T> implements Pilha<T>{

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();
    
    @Override
    public void push(T value) {
        lista.inserir(value);
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia())
            throw new PilhaVaziaException();
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while(!estaVazia()){
            pop();
        }
        //poderia usar o lista.liberar();
    }

    @Override
    public String toString() {
        String resultado = "";
        NoLista<T> p = lista.getPrimeiro();
        resultado += p.getInfo();
        if(p.getProximo() != null){
            p = p.getProximo();
        }
        return resultado;
    }
    
    
    

    
}
