package com.example.busca;

public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract {
    public int buscar(T valor){
        T[] info = (T[]) this.getInfo();
        int n = info.length;
        int inicio = 0;
        int fim = n - 1;

        while(inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(valor.compareTo(info[meio]) < 0){
                fim = meio - 1;
            }else if(valor.compareTo(info[meio]) > 0){
                inicio = meio + 1;
            }else{
                return meio;
            }
        }

        return -1;
    }
}
