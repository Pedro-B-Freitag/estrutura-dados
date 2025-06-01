package com.example.ordenacao;
public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T>  {
    public void ordenar() {
        int tamanhoVetor = this.getInfo().length - 1;

        this.mergeSort(0, tamanhoVetor);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            this.mergeSort(inicio, meio);
            this.mergeSort(meio + 1, fim);
            this.merge(inicio, fim, meio);
        }
    }

    private void merge(int inicio, int fim, int meio) {
        T[] info = this.getInfo();

        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        T[] esquerda = (T[]) new Comparable[tamanhoEsquerda];
        T[] direita = (T[]) new Comparable[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = info[inicio + i];
        }

        for (int i = 0; i < tamanhoDireita; i++) {
            direita[i] = info[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;
        int k = inicio;

        while (cEsq < tamanhoEsquerda && cDir < tamanhoDireita) {
            if (esquerda[cEsq].compareTo(direita[cDir]) <= 0) {
                info[k] = esquerda[cEsq];
                cEsq++;
            } else {
                info[k] = direita[cDir];
                cDir++;
            }

            k++;
        }

        while (cEsq < tamanhoEsquerda) {
            info[k] = esquerda[cEsq];
            cEsq++;
            k++;
        }

        while (cDir < tamanhoDireita) {
            info[k] = direita[cDir];
            cDir++;
            k++;
        }
    }
}