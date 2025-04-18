package com.example.entities;

public class NoListaDupla<T> {
    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public NoListaDupla(T info) {
        this.info = info;
        this.proximo = null;
        this.anterior = null;
    }
    public T getInfo() {
        return info;
    }
    public NoListaDupla<T> getProximo() {
        return proximo;
    }
    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }
    public NoListaDupla<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    

}
