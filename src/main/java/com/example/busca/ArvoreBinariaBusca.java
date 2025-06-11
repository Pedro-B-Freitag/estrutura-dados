package com.example.busca;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {
    public void inserir(T valor){
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(valor);
        if(estaVazia()){
            setRaiz(novo);
        }else{
            NoArvoreBinaria<T> p = getRaiz();
            NoArvoreBinaria<T> pai;

            while(true){
                pai = p;
                if(valor.compareTo(p.getInfo()) < 0){
                    p = p.getEsquerda();
                    if(p == null){
                        pai.setEsquerda(novo);
                        return;
                    }
                }else if(valor.compareTo(p.getInfo()) > 0){
                    p = p.getDireita();
                    if(p == null){
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info){
        return buscar(info, this.getRaiz());
    }

    private NoArvoreBinaria<T> buscar(T info, NoArvoreBinaria<T> no){
        if (no == null) {
            return null;
        }

        if (info.equals(no.getInfo())) {
            return no;
        } else if (info.compareTo(no.getInfo()) < 0) {
            return buscar(info, no.getEsquerda());
        } else {
            return buscar(info, no.getDireita());
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> excluir) {
        NoArvoreBinaria<T> p = excluir.getDireita();
        NoArvoreBinaria<T> paiSucessor = excluir;
        NoArvoreBinaria<T> sucessor = excluir;//p

        while (p != null) {
            paiSucessor = sucessor;
            sucessor = p;
            p = p.getEsquerda();
        }

        if (sucessor != excluir.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }
        return sucessor;

    }

    public boolean isDegenerada() {
        NoArvoreBinaria<T> no = getRaiz();

        while (no.getEsquerda() != null || no.getDireita() != null) {
            if (no.getEsquerda() != null && no.getDireita() != null) {
                return false;
            } else if (no.getEsquerda() != null) {
                no = no.getEsquerda();
            }
            else if (no.getDireita() != null) {
                no = no.getDireita();
            }
        }

        return true;
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // localiza o no a ser removido
        while ((p != null) && (!p.getInfo().equals(info))) {
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) { // se info < p.info
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p != null) { // achou dado a ser removido?
            if ((p.getEsquerda() == null) && (p.getDireita() == null)) {// 1.o caso - Nó folha
                if (p == getRaiz()) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda)
                        pai.setEsquerda(null);
                    else
                        pai.setDireita(null);
                }

            } else {// 2.o caso
                if (p.getDireita() == null) {// nó com apenas um filho a esquerda 2.o caso
                    if (p == getRaiz()) {
                        setRaiz(p.getEsquerda());
                    } else {
                        if (filhoEsquerda)
                            pai.setEsquerda(p.getEsquerda());
                        else
                            pai.setDireita(p.getEsquerda());
                    }
                } else {
                    if (p.getEsquerda() == null) {// nó com apenas um flho a direita 2.o caso
                        if (p == getRaiz())
                            setRaiz(p.getDireita());
                        else {
                            if (filhoEsquerda)
                                pai.setEsquerda(p.getDireita());
                            else
                                pai.setDireita(p.getDireita());
                        }

                    } else {//3.o caso
                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);
                        if (p == getRaiz())
                            setRaiz(sucessor);
                        else {
                            if (filhoEsquerda)
                                pai.setEsquerda(sucessor);
                            else
                                pai.setDireita(sucessor);
                        }
                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }
            }
        }
    }

    //===============================================================================

     private int numeroComparacoes = 0;



        private NoArvoreBinaria<T> inserirRecursivo(NoArvoreBinaria<T> no, T valor) {
            if (no == null) {
                return new NoArvoreBinaria<>(valor);
            }

            if (valor.compareTo(no.getInfo()) < 0) {
                no.setEsquerda(inserirRecursivo(no.getEsquerda(), valor));
            } else if (valor.compareTo(no.getInfo()) > 0) {
                no.setDireita(inserirRecursivo(no.getDireita(), valor));
            }
            // Se igual, não insere (evita duplicatas)

            return no;
        }



        private NoArvoreBinaria<T> buscarRecursivo(T info, NoArvoreBinaria<T> no) {
            if (no == null) {
                return null;
            }

            if (info.equals(no.getInfo())) {
                return no;
            } else if (info.compareTo(no.getInfo()) < 0) {
                return buscarRecursivo(info, no.getEsquerda());
            } else {
                return buscarRecursivo(info, no.getDireita());
            }
        }

        // Busca iterativa mais eficiente
        public NoArvoreBinaria<T> buscarIterativo(T info) {
            numeroComparacoes = 0;
            NoArvoreBinaria<T> atual = getRaiz();

            while (atual != null) {
                numeroComparacoes++;
                int comparacao = info.compareTo(atual.getInfo());

                if (comparacao == 0) {
                    return atual;
                } else if (comparacao < 0) {
                    atual = atual.getEsquerda();
                } else {
                    atual = atual.getDireita();
                }
            }
            return null;
        }

        // Encontra o menor elemento da árvore
        public T encontrarMenor() {
            NoArvoreBinaria<T> menorNo = encontrarMenorNo(getRaiz());
            return menorNo != null ? menorNo.getInfo() : null;
        }

        private NoArvoreBinaria<T> encontrarMenorNo(NoArvoreBinaria<T> no) {
            if (no == null) return null;

            while (no.getEsquerda() != null) {
                no = no.getEsquerda();
            }
            return no;
        }

        // Encontra o maior elemento da árvore
        public T encontrarMaior() {
            NoArvoreBinaria<T> maiorNo = encontrarMaiorNo(getRaiz());
            return maiorNo != null ? maiorNo.getInfo() : null;
        }

        private NoArvoreBinaria<T> encontrarMaiorNo(NoArvoreBinaria<T> no) {
            if (no == null) return null;

            while (no.getDireita() != null) {
                no = no.getDireita();
            }
            return no;
        }

        // Encontra o sucessor de um valor
        public T encontrarSucessor(T valor) {
            NoArvoreBinaria<T> no = buscar(valor);
            if (no == null) return null;

            NoArvoreBinaria<T> sucessor = encontrarSucessorNo(no);
            return sucessor != null ? sucessor.getInfo() : null;
        }

        private NoArvoreBinaria<T> encontrarSucessorNo(NoArvoreBinaria<T> no) {
            if (no.getDireita() != null) {
                return encontrarMenorNo(no.getDireita());
            }

            // Busca o ancestral que é sucessor
            NoArvoreBinaria<T> atual = getRaiz();
            NoArvoreBinaria<T> sucessor = null;

            while (atual != null) {
                if (no.getInfo().compareTo(atual.getInfo()) < 0) {
                    sucessor = atual;
                    atual = atual.getEsquerda();
                } else if (no.getInfo().compareTo(atual.getInfo()) > 0) {
                    atual = atual.getDireita();
                } else {
                    break;
                }
            }

            return sucessor;
        }

        // Encontra o predecessor de um valor
        public T encontrarPredecessor(T valor) {
            NoArvoreBinaria<T> no = buscar(valor);
            if (no == null) return null;

            NoArvoreBinaria<T> predecessor = encontrarPredecessorNo(no);
            return predecessor != null ? predecessor.getInfo() : null;
        }

        private NoArvoreBinaria<T> encontrarPredecessorNo(NoArvoreBinaria<T> no) {
            if (no.getEsquerda() != null) {
                return encontrarMaiorNo(no.getEsquerda());
            }

            // Busca o ancestral que é predecessor
            NoArvoreBinaria<T> atual = getRaiz();
            NoArvoreBinaria<T> predecessor = null;

            while (atual != null) {
                if (no.getInfo().compareTo(atual.getInfo()) > 0) {
                    predecessor = atual;
                    atual = atual.getDireita();
                } else if (no.getInfo().compareTo(atual.getInfo()) < 0) {
                    atual = atual.getEsquerda();
                } else {
                    break;
                }
            }

            return predecessor;
        }



        // Verifica se a árvore é uma BST válida
        public boolean ehBSTValida() {
            return ehBSTValida(getRaiz(), null, null);
        }

        private boolean ehBSTValida(NoArvoreBinaria<T> no, T min, T max) {
            if (no == null) return true;

            if ((min != null && no.getInfo().compareTo(min) <= 0) ||
                    (max != null && no.getInfo().compareTo(max) >= 0)) {
                return false;
            }

            return ehBSTValida(no.getEsquerda(), min, no.getInfo()) &&
                    ehBSTValida(no.getDireita(), no.getInfo(), max);
        }

        // Remove o menor elemento
        public T removerMenor() {
            T menor = encontrarMenor();
            if (menor != null) {
                setRaiz(removerMenor(getRaiz()));
            }
            return menor;
        }

        private NoArvoreBinaria<T> removerMenor(NoArvoreBinaria<T> no) {
            if (no.getEsquerda() == null) {
                return no.getDireita();
            }
            no.setEsquerda(removerMenor(no.getEsquerda()));
            return no;
        }

        // Remove o maior elemento
        public T removerMaior() {
            T maior = encontrarMaior();
            if (maior != null) {
                setRaiz(removerMaior(getRaiz()));
            }
            return maior;
        }

        private NoArvoreBinaria<T> removerMaior(NoArvoreBinaria<T> no) {
            if (no.getDireita() == null) {
                return no.getEsquerda();
            }
            no.setDireita(removerMaior(no.getDireita()));
            return no;
        }

        // Método retirar corrigido e simplificado
        public boolean remover(T valor) {
            if (!pertence(valor)) return false;
            setRaiz(removerRecursivo(getRaiz(), valor));
            return true;
        }

        private NoArvoreBinaria<T> removerRecursivo(NoArvoreBinaria<T> no, T valor) {
            if (no == null) return null;

            int comparacao = valor.compareTo(no.getInfo());

            if (comparacao < 0) {
                no.setEsquerda(removerRecursivo(no.getEsquerda(), valor));
            } else if (comparacao > 0) {
                no.setDireita(removerRecursivo(no.getDireita(), valor));
            } else {
                // Nó encontrado - três casos
                if (no.getEsquerda() == null) {
                    return no.getDireita();
                } else if (no.getDireita() == null) {
                    return no.getEsquerda();
                } else {
                    // Nó com dois filhos - substitui pelo sucessor
                    NoArvoreBinaria<T> sucessor = encontrarMenorNo(no.getDireita());
                    no.setInfo(sucessor.getInfo());
                    no.setDireita(removerRecursivo(no.getDireita(), sucessor.getInfo()));
                }
            }

            return no;
        }

        // Calcula a soma de todos os elementos (assumindo valores numéricos)
        public double calcularSomaElementos() {
            return calcularSomaElementos(getRaiz());
        }

        private double calcularSomaElementos(NoArvoreBinaria<T> no) {
            if (no == null) return 0;

            double valor = 0;
            if (no.getInfo() instanceof Number) {
                valor = ((Number) no.getInfo()).doubleValue();
            }

            return valor + calcularSomaElementos(no.getEsquerda()) +
                    calcularSomaElementos(no.getDireita());
        }

        // Calcula a média dos elementos
        public double calcularMediaElementos() {
            int totalNos = contarNos();
            return totalNos > 0 ? calcularSomaElementos() / totalNos : 0;
        }

        // Conta elementos menores que um valor
        public int contarMenoresQue(T valor) {
            return contarMenoresQue(getRaiz(), valor);
        }

        private int contarMenoresQue(NoArvoreBinaria<T> no, T valor) {
            if (no == null) return 0;

            if (no.getInfo().compareTo(valor) < 0) {
                return 1 + contarMenoresQue(no.getEsquerda(), valor) +
                        contarMenoresQue(no.getDireita(), valor);
            } else {
                return contarMenoresQue(no.getEsquerda(), valor);
            }
        }

        // Conta elementos maiores que um valor
        public int contarMaioresQue(T valor) {
            return contarMaioresQue(getRaiz(), valor);
        }

        private int contarMaioresQue(NoArvoreBinaria<T> no, T valor) {
            if (no == null) return 0;

            if (no.getInfo().compareTo(valor) > 0) {
                return 1 + contarMaioresQue(no.getEsquerda(), valor) +
                        contarMaioresQue(no.getDireita(), valor);
            } else {
                return contarMaioresQue(no.getDireita(), valor);
            }
        }

        // Constrói BST balanceada a partir de array ordenado
        public void construirBalanceada(T[] arrayOrdenado) {
            setRaiz(construirBalanceada(arrayOrdenado, 0, arrayOrdenado.length - 1));
        }

        private NoArvoreBinaria<T> construirBalanceada(T[] array, int inicio, int fim) {
            if (inicio > fim) return null;

            int meio = (inicio + fim) / 2;
            NoArvoreBinaria<T> no = new NoArvoreBinaria<>(array[meio]);

            no.setEsquerda(construirBalanceada(array, inicio, meio - 1));
            no.setDireita(construirBalanceada(array, meio + 1, fim));

            return no;
        }


        // Obtém estatísticas específicas da BST
        public String obterEstatisticasBST() {
            StringBuilder stats = new StringBuilder();
            stats.append("=== Estatísticas da Árvore Binária de Busca ===\n");
            stats.append("É BST válida: ").append(ehBSTValida()).append("\n");
            stats.append("Menor elemento: ").append(encontrarMenor()).append("\n");
            stats.append("Maior elemento: ").append(encontrarMaior()).append("\n");
            stats.append("Soma dos elementos: ").append(calcularSomaElementos()).append("\n");
            stats.append("Média dos elementos: ").append(String.format("%.2f", calcularMediaElementos())).append("\n");

            return stats.toString();
        }

        // Getters para análise de performance
        public int obterNumeroComparacoes() {
            return numeroComparacoes;
        }

        public void resetarContadorComparacoes() {
            numeroComparacoes = 0;
        }

        // Remove métodos duplicados e com bugs da versão original

}