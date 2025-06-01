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
        return  contador % info.length;
    }

    public void retirar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);
            info[indice].retirar(no);
        }
    }

    public int calcularQtdeObjetos() {

        int qtdeObjetos = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                qtdeObjetos += this.info[i].obterComprimento();
            }

        }

        return qtdeObjetos;
    }
}
