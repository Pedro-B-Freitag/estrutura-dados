package com.example.entities;

import com.example.exceptions.FilaVaziaException;
import com.example.interfaces.Fila;

public class FilaLista<T> implements Fila<T>{
    private ListaEncadeada<T> lista;

    public FilaLista(){
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new FilaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor;
        valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();

    }

    public String toString(){
        return lista.toString();
    }



}
