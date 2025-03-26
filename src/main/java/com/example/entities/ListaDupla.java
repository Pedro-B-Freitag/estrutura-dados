package com.example.entities;

public class ListaDupla<T> {
    
    private NoListaDupla<T> primeiro;

    public ListaDupla(){
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro(){
        return primeiro;
    }

    public void inserir(T valor){
        NoListaDupla<T> no = new NoListaDupla(valor);
        no.setProximo(primeiro);
        no.setAnterior(null);
        if(primeiro != null){
            primeiro.setAnterior(no);
        }        
        primeiro = no;
        
    }

    public NoListaDupla<T> buscar(T valor){
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if(atual.getInfo().equals(valor)){
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T valor){
        NoListaDupla<T> p = buscar(valor);

        if(p != null){
            if(p == primeiro){
                primeiro = p.getProximo();
            }else{
                p.getAnterior().setProximo(p.getProximo());
            }
            if(p.getProximo() != null){
                p.getProximo().setAnterior(p.getAnterior());
            }
            
        }

        
    }

    public void exibirOrdemInversa(){
        NoListaDupla<T> p = primeiro;
        NoListaDupla<T> ultimo = p;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();     
        }
        while (ultimo != null){
            System.out.print(ultimo.getInfo());
            ultimo = ultimo.getAnterior();
            if(ultimo != null){
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    public void liberar(){
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            NoListaDupla<T> proximo = p.getProximo();
            p.setAnterior(null);
            p.setProximo(null);
            p = proximo;
        }
        primeiro = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            atual = atual.getProximo();
            if(atual != null){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
