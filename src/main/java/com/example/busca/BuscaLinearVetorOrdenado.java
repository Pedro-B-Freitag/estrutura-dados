package com.example.busca;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract {
    public int buscar(T valor){
        T[] info = (T[])this.getInfo();

        for(int i = 0; i < info.length; i++){
            if(valor.equals(info[i])){
                return i;
            }else{
                if(valor.compareTo((T)info[i]) < 0){
                    break;
                }
            }           
        }

        return -1;
    }
}