package com.example.busca;

public class BuscaLinear<T> extends BuscaAbstract{
    public int buscar(T valor){
        T vetor[] = (T[])this.getInfo();

        for(int i = 0; i < vetor.length; i++){
            if(valor.equals(vetor[i])){
                return i;
            }
        }

        return -1;
    }
}
