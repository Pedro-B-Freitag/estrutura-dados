package com.example.entities;

public class ListaEstatica<T> {

    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new Object[10];
        tamanho = 0;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() {
        Object[] novo = new Object[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            novo[i] = this.info[i];
        }
        this.info = novo;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.print(info[i] + " ");
        }
        System.out.println();
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int posicao = buscar(valor);
        if(posicao > -1){
            for(int i = posicao + 1; i < tamanho; i++){
                info[i - 1] = info[i];
                info[i] = null;
            }
            tamanho--;
        }
        
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;

    }

    @SuppressWarnings("unchecked")
    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        
        return (T)info[posicao];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }


    public void retirarElementos(int inicio, int fim) {
        if (inicio < 0 || fim >= tamanho || inicio > fim) {
            throw new IndexOutOfBoundsException("Índices inválidos.");
        }

        // Deslocando os elementos após 'fim' para 'inicio'
        for (int i = fim + 1; i < tamanho; i++) {
            info[inicio++] = info[i];
        }

        // Atualizando o tamanho da lista
        tamanho -= (fim - inicio + 1);

        // Preenchendo os espaços vazios com null (opcional)
        for (int i = tamanho; i < info.length; i++) {
            info[i] = null;
        }
    }


    @Override
    public String toString() {
        String resultado = "";
        for(int i = 0; i < tamanho; i++){
            if(i > 0){
                resultado += ",";
            }
            resultado += info[i];
        }
        return resultado;
    }

    public void inverter(){
        for(int i = 0; i < tamanho/2; i++){
            Object temp = info[i];
            info[i] = info[tamanho - i - 1];
            info[tamanho - i - 1] = temp; 
        }
    }
}

