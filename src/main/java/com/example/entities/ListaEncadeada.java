package com.example.entities;

public class ListaEncadeada<T> {
    
    private NoLista<T> primeiro;

    public ListaEncadeada(){
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor){
        NoLista<T> no = new NoLista<>(valor);
        no.setProximo(primeiro);
        primeiro = no;
    }

    public boolean estaVazia(){
        return primeiro == null;
    }

    public NoLista<T> buscar(T valor){
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if(atual.getInfo().equals(valor)){
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T valor){
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;
        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProximo();
        }

        if(p != null){
            if(p == primeiro){
                this.primeiro = p.getProximo();
            }else{
                anterior.setProximo(p.getProximo()); 
            }
        }
    }

    public int obterComprimento(){
        int contador = 1;
        NoLista<T> p = primeiro;
        
        while(p.getProximo() != null){
            p = p.getProximo();
            contador ++;
        }
        return contador;
    }

    public NoLista<T> obterNo(int valor){
        if(valor < 0){
            throw new IndexOutOfBoundsException("Fora dos limites da lista");
        }
        if(primeiro != null){
            NoLista p = primeiro;
            int contador = 0;
            while(p != null){
                if(contador == valor){
                    return p;
                }
                p = p.getProximo();
                contador ++;
            }
            throw new IndexOutOfBoundsException("Fora dos limites da lista");
        }
        return null;
    }

    public ListaEncadeada<T> criarListaInvertida(){
        ListaEncadeada<T> lista = new ListaEncadeada<>();

        NoLista<T> p = primeiro;
        while (p != null) {
            lista.inserir(p.getInfo());
            p = p.getProximo();
        }
        return lista;
    }

    public void anexar(ListaEstatica<T> l2){
        Integer tamanho = obterComprimento();
        NoLista<T> ultimo = obterNo(tamanho - 1);
        for(int i = 0; i < l2.getTamanho(); i++){
            NoLista<T> p = new NoLista<T>(l2.obterElemento(i));
            ultimo.setProximo(p);
            ultimo = p;
        }
    }

    public void liberar(){
        NoLista<T> p = primeiro;
        while (p != null) {
            NoLista<T> proximo = p.getProximo();
            p.setProximo(null);
            p = proximo;
        }
        primeiro = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            atual = atual.getProximo();
            if(atual != null){
                sb.append(" , ");
            }
        }
        return sb.toString();
    }



}
