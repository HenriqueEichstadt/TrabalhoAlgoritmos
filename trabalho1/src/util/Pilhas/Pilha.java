package util.Pilhas;

public interface Pilha<T> {

    void push(T value);
    T pop();
    T peek();
    boolean estaVazia();
    void liberar();
}

