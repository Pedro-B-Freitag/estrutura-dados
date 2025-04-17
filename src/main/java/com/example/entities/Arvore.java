package com.example.entities;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore(){
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public String toString(){
        if(raiz == null){
            return "";
        }
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no){
        String s ="<";
        s = s + no.getInfo();

        NoArvore<T> p = no.getPrimeiro();

        while(p != null){
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        s += ">";

        return s;
    }

    public boolean pertence(T info){
        if(raiz == null){
            return false;
        }
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info){
        if(no.getInfo() == info){
            return true;
        }
        NoArvore<T> p;
        p = no.getPrimeiro();
        while(p!= null){
            if(pertence(p, info)){
                return true;
            }
            p = p.getProximo();
        }
        return false;
    }

    public int contarNos(){
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no){
        if(no == null){
            return 0;
        }
        return 1 + contarNos(no.getPrimeiro()) + contarNos(no.getProximo());
    }


}
