package com.example.entities;

import com.example.interfaces.Pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private Object info[];
    private int tamanho;
    private int limite;

    public PilhaVetor(int limite){
        this.limite = limite;
        info= new Object[limite];
    }

    @Override
    public void push(T v) {
        if(tamanho == limite){
            info[tamanho] = v;
            tamanho ++;
        }else{
            throw new RuntimeException("Capacidade esgotada da pilha");
        }
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        tamanho --;
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new RuntimeException("Pilha está vazia!");
        }
        return (T) info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        info= new Object[limite];
        tamanho = 0;
    }

    @Override
    public String toString() {
        String resultado = "";
        for(int i = 0; i < tamanho; i++){
            if(i > 0){
                resultado += ",";
            }
            resultado += info[i];
        }
        return resultado;
    }

    public void concatenar(PilhaVetor p){
        if(tamanho + p.getTamanho() <= limite){
            for(int i = 0; i < p.getTamanho(); i++){
                push((T) p.getInfo()[i]);
            }

        } else{
            throw new RuntimeException("Capacidade esgotada da pilha");
        }
        
    }

    public Object[] getInfo() {
        return info;
    }

    public void setInfo(Object[] info) {
        this.info = info;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    

    
}
