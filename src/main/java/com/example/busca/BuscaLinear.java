package com.example.busca;

public class BuscaLinear<T> extends BuscaAbstract{
    public int buscar(T valor){
        Object[] info = this.getInfo();

        for(int i = 0; i < info.length; i++){
            if(valor.equals(info[i])){
                return i;
            }
        }

        return -1;
    }
}
