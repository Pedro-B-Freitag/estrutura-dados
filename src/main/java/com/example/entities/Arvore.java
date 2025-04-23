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

    public int obterNivel(T info) {
        return obterNivel(raiz, info, 0);
    }

    private int obterNivel(NoArvore<T> no, T info, int nivel) {
        if (no == null) return -1;

        if (no.getInfo().equals(info)) {
            return nivel;
        }

        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            int res = obterNivel(filho, info, nivel + 1);
            if (res != -1) return res;
            filho = filho.getProximo();
        }

        return -1;
    }


}
