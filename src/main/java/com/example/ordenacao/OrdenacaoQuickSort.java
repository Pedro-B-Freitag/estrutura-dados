package com.example.ordenacao;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        quickSort(0, this.getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = this.particionar(inicio, fim);

            this.quickSort(inicio, indicePivo - 1);
            this.quickSort(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        T[] info = this.getInfo();
        T pivo = info[inicio];

        while (true) {
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) {
                break;
            }

            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }

    //Nao funcionou como esperado/nao testado
    public void ordenarAntigo(){
        quickSort(0, getInfo().length);
    }

    private void quickSortAntigo(int inicio, int fim){
        if(inicio < fim){
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo - 1);
            quickSort(idxPivo + 1, fim);
        }
    }

    private int particionarAntigo(int inicio, int fim){
        T[] info = getInfo();
        T pivo = info[inicio];
        int a = inicio;
        int b = fim + 1;

        while(true){
            do {
                a++;
            }while(a <= fim && info[a].compareTo(pivo) > 0);//ino[a] < pivo
            do {
                b--;
            }while(b >= inicio && info[b].compareTo(pivo) > 0 );

            if(a >= b){
                break;
            }

            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }
}