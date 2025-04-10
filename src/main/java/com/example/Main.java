package com.example;


import com.example.entities.ArvoreBinaria;
import com.example.entities.NoArvoreBinaria;

public class Main {
    public static void main(String[] args) {
            ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

            NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(10);
            NoArvoreBinaria<Integer> esquerda = new NoArvoreBinaria<>(5);
            NoArvoreBinaria<Integer> direita = new NoArvoreBinaria<>(15);
            NoArvoreBinaria<Integer> esquerdaEsquerda = new NoArvoreBinaria<>(3);

            esquerda.setEsquerda(esquerdaEsquerda);
            raiz.setEsquerda(esquerda);
            raiz.setDireita(direita);

            arvore.setRaiz(raiz);

            System.out.println(arvore.contarNos());
            
        }
    }
