package com.example.busca;

public abstract class BuscaAbstract {
    private Object info[];

    public Object[] getInfo(){
        return this.info;
    }

    public void setInfo(Object[] info){
        this.info = info;
    }
}
