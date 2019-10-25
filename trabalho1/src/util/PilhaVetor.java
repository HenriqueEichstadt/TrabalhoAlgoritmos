package util;

import util.Pilha.PilhaCheiaException;
import util.Pilha.Pilha;

public class PilhaVetor<T> implements Pilha<T>{
    private T[] info;
    private int limite;
    private int tamanho;
    
    /**
     * Cria uma pilha com o tamanho especificado
     * @param limite Capacidade máxima de empilhamento
     */
    public PilhaVetor(int limite){
        this.info = (T[])new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }
    
    /**
     * Empilha um dado
     * @param value dado a ser incluso na Pilha
     */
    @Override
    public void push(T value) {
        if(limite == tamanho)
            throw new PilhaCheiaException("Capacidade esgotada da pilha");
        info[tamanho] = value;
        tamanho++;
    }

    /**
     * Retorna o conteúdo do topo da pilha
     * @return topo da pilha
     */
    @Override
    public T peek() {
        if(estaVazia())
            throw new PilhaCheiaException("A pilha está vazia");
        
        return info[tamanho - 1];
    }

    /**
     * Retira o elemento da pilha e 
     * retorna o valor retirado
     * @return valor no topo da pilha
     */
    @Override
    public T pop() {
        T value = (T)peek();
        tamanho--;
        return value;
    }

    
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        while(!estaVazia())
            pop();
    }
    
    public void concatenar(PilhaVetor<T> pilha){
        for(int i = 0; i < pilha.tamanho; i++){
            this.push(pilha.info[i]);
        }
    }
    
    @Override
    public String toString(){
        T[] value = info;
        int tamanho = this.tamanho;
        String text = "";
        
        while(tamanho > 0){
            text += pop();
            if(tamanho != 1){
                text += ", ";
            }
            tamanho--;
        }
        return text;
    }
}
