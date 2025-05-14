package com.example.ordenacao;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        int n = info.length - 1;
        quickSort(0, n);
    }
    private void quickSort(int inicio, int fim) {
        if(inicio < fim) {
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo - 1);
            quickSort(idxPivo + 1, fim);
        }
    }
    private int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];
        while (true){
            a = a + 1;
            while (a <= fim && info[a].compareTo(pivo) < 0) {
                b = b - 1;
            }
            while (b >= 0 && info[b].compareTo(pivo) > 0) {
                if(a >= b) break;
                trocar(a, b);
            }

            trocar(b, inicio);
            return b;
        }

    }
}
