package com.example.ordenacao;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar(){
        T[] vetor = this.getInfo();
        int i;
        int j;
        int n = getInfo().length;

        for(i = n - 1; i >= 1; i--){
            for(j = 0; j < i; j++){
                if(vetor[j].compareTo(vetor[j +1]) > 0){
                    trocar(j, j+1);
                }
            }
        }
    }

}
