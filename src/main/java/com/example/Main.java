package com.example;

import com.example.entities.Arvore;
import com.example.entities.ArvoreBinaria;
import com.example.entities.FilaVetor;
import com.example.entities.NoArvore;
import com.example.entities.NoArvoreBinaria;
import com.example.ordenacao.OrdenacaoBolhaOtimizada;
import com.example.ordenacao.OrdenacaoMergeSort;
import com.example.ordenacao.OrdenacaoQuickSort;

public class Main {
    public static void main(String[] args) {

        

        
        
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        
        fila.inserir(0);
        fila.inserir(0);
        fila.inserir(0);
        fila.retirar();
        fila.retirar();
        fila.retirar();

        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(4);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(4);
        
        System.out.println(fila);
        fila.encolher();
        System.out.println(fila);
        
        NoArvoreBinaria<Integer> nob4 = new NoArvoreBinaria<>(4);
        
        NoArvoreBinaria<Integer> nob10 = new NoArvoreBinaria<>(10);
        NoArvoreBinaria<Integer> nob9 = new NoArvoreBinaria<>(9);
        nob9.setEsquerda(nob10);

        NoArvoreBinaria<Integer> nob8 = new NoArvoreBinaria<>(8);

        NoArvoreBinaria<Integer> nob7 = new NoArvoreBinaria<>(7);
        nob7.setEsquerda(nob9);
        nob7.setDireita(nob8);


        NoArvoreBinaria<Integer> nob1 = new NoArvoreBinaria<>(1);
        nob1.setDireita(nob7);
        nob1.setEsquerda(nob4);
        ArvoreBinaria<Integer> arvoreB = new ArvoreBinaria<>();
        arvoreB.setRaiz(nob1);
        
        System.out.println(arvoreB.contarFolhas());
        
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
        System.out.println(arvore.contarNosInternos());


        Integer[] mergeLista = {2,145,32,1,56,9,6,4,8,0,54,342,67,86};
        OrdenacaoQuickSort mergeSort = new OrdenacaoQuickSort();
        mergeSort.setInfo(mergeLista);
        mergeSort.ordenar();
        for(int i = 0; i < mergeLista.length; i++){
            System.out.print(mergeLista[i] + ",");
        }

        }
    }
