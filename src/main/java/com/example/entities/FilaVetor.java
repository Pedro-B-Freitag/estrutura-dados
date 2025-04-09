package com.example.entities;

import com.example.exceptions.FilaCheiaException;
import com.example.exceptions.FilaVaziaException;
import com.example.interfaces.Fila;

public class FilaVetor<T> implements Fila<T>{

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    //ao retirar não movemos todos os registros para a esquerda para não ser muito pesado
    //ao invés disso, não movemos para a esquerda, deixamos a posição como nula e não esvaziamos a sua posição
    //deixamos sua posição nula e quando a lista ficar cheia, preenchemos ela com novos dados depois.

    public FilaVetor(int limite){
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
        info = new Object[limite];
    }

    //ao somar tamanho + inicio, obtemos o lugar em que se deve adicionar o elemento
    //quando funciona de forma circular, fazemos tamanho + inicio - limite;
    //quando o inicio + tamanho for menor que o limite, o resto da divisão da o numero certo
    //se a soma for maior, o resto deve dar o indice circular;
    @Override
    public void inserir(T valor) {
        if(tamanho == limite){
            throw new FilaCheiaException();
        }
        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho ++;

    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new FilaVaziaException();
        }
        return (T)info[inicio];
    }

    @Override
    public T retirar() {
        T inicioAntigo = peek();
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho --;
        return inicioAntigo;
    }
    //ou fazer assim ou 
    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2){
        FilaVetor<T> f3 = new FilaVetor<T>(limite + f2.getLimite());
        int posicao = inicio;
        for(int i = 0; i < this.tamanho; i ++){
            f3.inserir((T)this.info[posicao]);
            posicao = (posicao + 1) % this.limite;
        }

        posicao = f2.inicio;
        for(int i = 0; i < f2.tamanho; i ++){
            f3.inserir((T)f2.info[posicao]);
            posicao = (posicao + 1) % f2.limite;
        }

        return f3;
    }

    public String toString(){
        String retorno = "";

        int posicao = inicio;
        for(int i = 0; i < tamanho; i++){
            if(i > 0){
                retorno += ",";
            }
            retorno = retorno + info[posicao];
            //sempre considerar o vetor circular;
            posicao = (posicao + 1) % limite;
        }
        return retorno;
    }

    public int getLimite() {
        return limite;
    }    
    
}
