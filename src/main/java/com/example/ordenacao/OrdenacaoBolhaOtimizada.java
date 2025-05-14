package com.example.ordenacao;

public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T>{
    @Override
    public void ordenar() {
        int n = info.length;
        boolean trocou = false;
        for(int i = n-1; i > 1; i --){
            trocou = false;
            for(int j = 0; j < i-1; j++){
                if(info[j].compareTo(info[j+1]) > 0){
                    trocar(j, j+1);
                    trocou = true;
                }
            }
            if(!trocou){
                return;
            }
        }
    }
}
