package com.example.entities;

public class ArvoreBinaria<T> {
    
    NoArvoreBinaria<T> raiz;

    public ArvoreBinaria(){}

    public void setRaiz(NoArvoreBinaria<T> raiz){
        this.raiz = raiz;
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public boolean pertence(T info){
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info){
        if(no == null){
            return false;
        }else{
            return (no.getInfo() == info) || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
        }
    }

    public String toString(){
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no){

        if(no == null){
            return "<>";
        }

        return "<" + no.getInfo() + ">" + "<" + arvorePre(no.getEsquerda()) + ">" + "<" +arvorePre(no.getDireita()) + ">";

    }

    public int contarNos(){
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no){

        if(no == null){
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    public int contarFolhas() {
        if (raiz == null) return 0;

        return contarFolhas(raiz);
    }

    private int contarFolhas(NoArvoreBinaria<T> no) {

        if(no == null){
            return 0;
        }
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return 1;
        }

        return contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
    }

}
