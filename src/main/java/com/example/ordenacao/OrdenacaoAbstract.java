package com.example.ordenacao;

public abstract class OrdenacaoAbstract <T extends Comparable<T>> {
    T[] info;

    public void trocar(int a, int b){
        T temp = info[b];
        info[b] = info[a];
        info[a] = temp;
    }

    public void ordenar(){

    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public T[] getInfo() {
        return info;
    }
}
