package com.example.busca;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {
    public void inserir(T valor){

    }

    @Override
    public NoArvoreBinaria<T> buscar(T info){
        return buscar(this.getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info){
        if(no == null){
            return null;
        }

        return null;
    }
}