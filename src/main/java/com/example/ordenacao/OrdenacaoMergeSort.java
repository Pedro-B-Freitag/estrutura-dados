package com.example.ordenacao;
public class OrdenacaoMergeSort <T extends Comparable<T>> extends OrdenacaoAbstract<T>{
    
    @Override
    public void ordenar(){ 
    mergeSort(0, getInfo().length-1);
    }
    
    private void mergeSort(int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim)/2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }
    
    
    
    private void merge(int inicio, int fim, int meio){
        T[] info = getInfo();
        int tamEsquerda = meio - inicio + 1;
        T[] esquerda =  (T[]) new Comparable[tamEsquerda];
        for(int i = 0; i <= tamEsquerda - 1; i++){
            esquerda[i] = info[inicio + 1];
        }
        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for(int i = 0; i <= tamDireita - 1; i++){
            direita[i] = info[meio + 1 + i];
        }
        
        int cEsq = 0;
        int cDir = 0;
        int i;
        
        for( i = inicio; i <= fim; i++){
            if((cEsq < tamEsquerda) && (cDir < tamDireita)){
                if(esquerda[cEsq].compareTo(direita[cDir]) < 0){
                    info[i] = esquerda[cEsq];
                    cEsq++;
                }else{
                    info[i] = direita[cDir];
                    cDir++;
                }
            }else{
                break;
            }
            
            while (cEsq < tamEsquerda){
                info[i] = esquerda[cEsq];
                cEsq++;
                i++;
            }
            while (cDir < tamDireita){
                info[i] = direita[cDir];
                cDir++;
                i++;
            }
       
        }
    }
}
