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
}