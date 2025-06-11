package com.example.busca;

import com.example.entities.ListaEncadeada;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T>{
    @Override
    public NoArvoreBinaria<T> buscar(T info){
        return buscar(this.getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info){
        if(no == null){
            return null;
        }

        if(no.getInfo().equals(info)){
            return no;
        }

        NoArvoreBinaria<T> resultado = buscar(no.getEsquerda(),info);

        if(resultado != null){
            return resultado;
        }

        return buscar(no.getDireita(), info);
    }

    @Override
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(getRaiz());
    }


    //=======================================================================


    // Busca o nó pai de um valor específico
    public NoArvoreBinaria<T> buscarPai(T info) {
        if (getRaiz() == null || getRaiz().getInfo().equals(info)) {
            return null; // Raiz não tem pai
        }
        return buscarPai(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscarPai(NoArvoreBinaria<T> no, T info) {
        if (no == null) return null;

        // Verifica se é pai direto
        if ((no.getEsquerda() != null && no.getEsquerda().getInfo().equals(info)) ||
                (no.getDireita() != null && no.getDireita().getInfo().equals(info))) {
            return no;
        }

        // Busca recursivamente
        NoArvoreBinaria<T> paiEsquerda = buscarPai(no.getEsquerda(), info);
        if (paiEsquerda != null) return paiEsquerda;

        return buscarPai(no.getDireita(), info);
    }

    // Calcula o nível de um nó específico
    public int calcularNivel(T info) {
        return calcularNivel(getRaiz(), info, 0);
    }

    private int calcularNivel(NoArvoreBinaria<T> no, T info, int nivelAtual) {
        if (no == null) return -1;

        if (no.getInfo().equals(info)) {
            return nivelAtual;
        }

        int nivelEsquerda = calcularNivel(no.getEsquerda(), info, nivelAtual + 1);
        if (nivelEsquerda != -1) return nivelEsquerda;

        return calcularNivel(no.getDireita(), info, nivelAtual + 1);
    }

    // Encontra o menor ancestral comum de dois nós
    public NoArvoreBinaria<T> encontrarMenorAncestralComum(T info1, T info2) {
        return encontrarMenorAncestralComum(getRaiz(), info1, info2);
    }

    private NoArvoreBinaria<T> encontrarMenorAncestralComum(NoArvoreBinaria<T> no, T info1, T info2) {
        if (no == null) return null;

        if (no.getInfo().equals(info1) || no.getInfo().equals(info2)) {
            return no;
        }

        NoArvoreBinaria<T> esquerdaLCA = encontrarMenorAncestralComum(no.getEsquerda(), info1, info2);
        NoArvoreBinaria<T> direitaLCA = encontrarMenorAncestralComum(no.getDireita(), info1, info2);

        if (esquerdaLCA != null && direitaLCA != null) {
            return no;
        }

        return (esquerdaLCA != null) ? esquerdaLCA : direitaLCA;
    }

    // Calcula a distância entre dois nós
    public int calcularDistanciaEntreNos(T info1, T info2) {
        NoArvoreBinaria<T> lca = encontrarMenorAncestralComum(info1, info2);
        if (lca == null) return -1;

        int dist1 = calcularDistanciaAteNo(lca, info1);
        int dist2 = calcularDistanciaAteNo(lca, info2);

        return dist1 + dist2;
    }

    private int calcularDistanciaAteNo(NoArvoreBinaria<T> de, T info) {
        if (de == null) return -1;

        if (de.getInfo().equals(info)) return 0;

        int distEsquerda = calcularDistanciaAteNo(de.getEsquerda(), info);
        if (distEsquerda != -1) return distEsquerda + 1;

        int distDireita = calcularDistanciaAteNo(de.getDireita(), info);
        if (distDireita != -1) return distDireita + 1;

        return -1;
    }

    // Busca todos os nós em um nível específico
    public ListaEncadeada<T> buscarNosNoNivel(int nivel) {
        ListaEncadeada<T> nos = new ListaEncadeada();
        buscarNosNoNivel(getRaiz(), nivel, 0, nos);
        return nos;
    }

    private void buscarNosNoNivel(NoArvoreBinaria<T> no, int nivelDesejado, int nivelAtual, ListaEncadeada<T> nos) {
        if (no == null) return;

        if (nivelAtual == nivelDesejado) {
            nos.inserir(no.getInfo());
            return;
        }

        buscarNosNoNivel(no.getEsquerda(), nivelDesejado, nivelAtual + 1, nos);
        buscarNosNoNivel(no.getDireita(), nivelDesejado, nivelAtual + 1, nos);
    }

    // Busca todos os nós folha
    public ListaEncadeada<T> buscarTodasFolhas() {
        ListaEncadeada<T> folhas = new ListaEncadeada<>();
        buscarTodasFolhas(getRaiz(), folhas);
        return folhas;
    }

    private void buscarTodasFolhas(NoArvoreBinaria<T> no, ListaEncadeada<T> folhas) {
        if (no == null) return;

        if (no.getEsquerda() == null && no.getDireita() == null) {
            folhas.inserir(no.getInfo());
            return;
        }

        buscarTodasFolhas(no.getEsquerda(), folhas);
        buscarTodasFolhas(no.getDireita(), folhas);
    }

    // Busca todos os nós internos
    public ListaEncadeada<T> buscarTodosNosInternos() {
        ListaEncadeada<T> nosInternos = new ListaEncadeada<>();
        buscarTodosNosInternos(getRaiz(), nosInternos);
        return nosInternos;
    }

    private void buscarTodosNosInternos(NoArvoreBinaria<T> no, ListaEncadeada<T> nosInternos) {
        if (no == null) return;

        if (no.getEsquerda() != null || no.getDireita() != null) {
            nosInternos.inserir(no.getInfo());
        }

        buscarTodosNosInternos(no.getEsquerda(), nosInternos);
        buscarTodosNosInternos(no.getDireita(), nosInternos);
    }


    // Busca o nó mais à esquerda da árvore
    public NoArvoreBinaria<T> buscarMaisEsquerda() {
        return buscarMaisEsquerda(getRaiz());
    }

    private NoArvoreBinaria<T> buscarMaisEsquerda(NoArvoreBinaria<T> no) {
        if (no == null) return null;

        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

    // Busca o nó mais à direita da árvore
    public NoArvoreBinaria<T> buscarMaisDireita() {
        return buscarMaisDireita(getRaiz());
    }

    private NoArvoreBinaria<T> buscarMaisDireita(NoArvoreBinaria<T> no) {
        if (no == null) return null;

        while (no.getDireita() != null) {
            no = no.getDireita();
        }
        return no;
    }

    // Verifica se um valor é ancestral de outro
    public boolean ehAncestral(T ancestral, T descendente) {
        NoArvoreBinaria<T> noAncestral = buscar(ancestral);
        if (noAncestral == null) return false;

        return buscar(noAncestral, descendente) != null;
    }

    // Busca todos os descendentes de um nó
   

    // Conta quantos nós satisfazem uma condição
    public int contarNosComCondicao(java.util.function.Predicate<T> condicao) {
        return contarNosComCondicao(getRaiz(), condicao);
    }

    private int contarNosComCondicao(NoArvoreBinaria<T> no, java.util.function.Predicate<T> condicao) {
        if (no == null) return 0;

        int count = condicao.test(no.getInfo()) ? 1 : 0;
        count += contarNosComCondicao(no.getEsquerda(), condicao);
        count += contarNosComCondicao(no.getDireita(), condicao);

        return count;
    }

    // Busca com limite de profundidade
    public NoArvoreBinaria<T> buscarComLimiteProfundidade(T info, int maxProfundidade) {
        return buscarComLimiteProfundidade(getRaiz(), info, 0, maxProfundidade);
    }

    private NoArvoreBinaria<T> buscarComLimiteProfundidade(NoArvoreBinaria<T> no, T info, int profundidadeAtual, int maxProfundidade) {
        if (no == null || profundidadeAtual > maxProfundidade) {
            return null;
        }

        if (no.getInfo().equals(info)) {
            return no;
        }

        NoArvoreBinaria<T> resultadoEsquerda = buscarComLimiteProfundidade(no.getEsquerda(), info, profundidadeAtual + 1, maxProfundidade);
        if (resultadoEsquerda != null) return resultadoEsquerda;

        return buscarComLimiteProfundidade(no.getDireita(), info, profundidadeAtual + 1, maxProfundidade);
    }

}