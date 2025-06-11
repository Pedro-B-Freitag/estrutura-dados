package com.example.entities;

public class MapaDispersao <T>{
    ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho){
        info = new ListaEncadeada[tamanho];
    }
    private int calcularHash(int chave){
        int tamanho = info.length;
        return chave % tamanho;
    }
    public void inserir(int chave, T valor){
        int indice = calcularHash(chave);
        if(info[indice] == null){
            info[indice] = new ListaEncadeada<>();
        }
        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setValor(valor);

        info[indice].inserir(noMapa);
    }

    public T buscar(int chave){
        int indice = calcularHash(chave);
        if(info[indice] == null){
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if(no != null){
                return no.getInfo().getValor();
            }
        }

        return null;
    }

    public double calcularFatorCarga(){
        int contador = 0;
        for(int i = 0; i < info.length; i++){
            if(info[i] != null){
                contador++;
            }
        }
        return  (double) contador / info.length;
    }

    public void retirar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);
            info[indice].retirar(no);
        }
    }

    //===============================================================================

    public int calcularQtdeObjetos() {

        int qtdeObjetos = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                qtdeObjetos += this.info[i].obterComprimento();
            }

        }

        return qtdeObjetos;
    }

    public boolean redimensionar(int novoTamanho) {
        if(novoTamanho <= 0) return false;

        ListaEncadeada<NoMapa<T>>[] infoAntiga = info;
        info = new ListaEncadeada[novoTamanho];

        for(int i = 0; i < infoAntiga.length; i++) {
            if(infoAntiga[i] != null) {
                NoLista<NoMapa<T>> atual = infoAntiga[i].getPrimeiro();
                while(atual != null) {
                    NoMapa<T> no = atual.getInfo();
                    inserir(no.getChave(), no.getValor());
                    atual = atual.getProximo();
                }
            }
        }
        return true;
    }

    public int encontrarMaiorCadeia() {
        int maiorCadeia = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                int tamanhoCadeia = info[i].obterComprimento();
                maiorCadeia = Math.max(maiorCadeia, tamanhoCadeia);
            }
        }
        return maiorCadeia;
    }

    public int encontrarMenorCadeia() {
        int menorCadeia = Integer.MAX_VALUE;
        boolean encontrouCadeia = false;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && !info[i].estaVazia()) {
                int tamanhoCadeia = info[i].obterComprimento();
                menorCadeia = Math.min(menorCadeia, tamanhoCadeia);
                encontrouCadeia = true;
            }
        }

        return encontrouCadeia ? menorCadeia : 0;
    }

    public boolean precisaRedimensionar() {
        double fatorCarga = calcularFatorCarga();
        return fatorCarga > 0.75 || encontrarMaiorCadeia() > 5;
    }


}
