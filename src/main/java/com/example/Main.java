package com.example;

import com.example.entities.Arvore;
import com.example.entities.NoArvore;

public class Main {
    public static void main(String[] args) {

        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        no3.inserirFilho(no4);

        NoArvore<Integer> no5 = new NoArvore<>(5);

        NoArvore<Integer> no2 = new NoArvore<>(2);
        no2.inserirFilho(no5);
        no2.inserirFilho(no3);

        NoArvore<Integer> no10 = new NoArvore<>(10);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        no9.inserirFilho(no10);

        NoArvore<Integer> no8 = new NoArvore<>(8);

        NoArvore<Integer> no7 = new NoArvore<>(7);
        no7.inserirFilho(no9);
        no7.inserirFilho(no8);

        NoArvore<Integer> no6 = new NoArvore<>(6);

        NoArvore<Integer> no1 = new NoArvore<>(1);
        no1.inserirFilho(no7);
        no1.inserirFilho(no6);
        no1.inserirFilho(no2);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(no1);
        System.out.println(arvore);
        System.out.println(arvore.contarNos());


        }
    }
