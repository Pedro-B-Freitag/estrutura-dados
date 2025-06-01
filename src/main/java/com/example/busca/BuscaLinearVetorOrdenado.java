package com.example.busca;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract {
    public int buscar(T valor){
        T[] info = (T[])this.getInfo();

        for(int i = 0; i < info.length; i++){
            if(info[i].compareTo(valor) > 0){
                return -1;
            }

            if(valor.equals(info[i])){
                return i;
            }
        }

        return -1;
    }
}