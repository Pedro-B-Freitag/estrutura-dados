package com.example.busca;

public class NoArvoreBinaria<T> {
    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;
    private T info;

    public NoArvoreBinaria(T info){
        this.esquerda = null;
        this.direita = null;
        this.info = info;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria esquerda, NoArvoreBinaria direita){
        this.esquerda = esquerda;
        this.direita = direita;
        this.info = info;
    }

    //Necessario para metodo fromString da arvoreBinaria
    public NoArvoreBinaria() {
        this.info = null;
        this.esquerda = null;
        this.direita = null;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return this.info;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
}
