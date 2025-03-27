package com.example;

import com.example.entities.ListaEncadeada;
import com.example.entities.ListaEstatica;

public class Main {
    public static void main(String[] args) {
            ListaEstatica<Integer> lista = new ListaEstatica<Integer>();
            lista.inserir(10);
            lista.inserir(20);
            lista.inserir(30);
            lista.inserir(40);
            lista.inserir(50);
            lista.inserir(60);
            lista.inserir(10);
            lista.inserir(10);
            System.out.println(lista.toString());
    
            lista.retirarElementos(1, 7);
            System.out.println(lista.toString());
            System.out.println(lista.getTamanho());
    
    
            ListaEncadeada<Integer> lista2 = new ListaEncadeada<>();
            lista2.inserir(1);
            lista2.inserir(2);
            lista2.inserir(3);
            lista2.anexar(lista);
            System.out.println(lista2.toString());
        }
    }
