import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.entities.ListaDupla;
import com.example.entities.NoListaDupla;

public class ListaDuplaTest {

    @Test
    public void testeListaDupla(){
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.exibirOrdemInversa();
        assertEquals("20, 15, 10, 5", lista.toString());
    }

    @Test
    public void testeListaDupla2(){
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla resposta = lista.buscar(20);
        assertEquals(20, resposta.getInfo());
    }

    @Test
    public void testeListaDupla3(){
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla resposta = lista.buscar(10);
        assertEquals(10, resposta.getInfo());
    }

    @Test
    public void testeListaDupla4(){
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        lista.exibirOrdemInversa();
        assertEquals("15, 10, 5", lista.toString());
    }

    @Test
    public void testeListaDupla5(){
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        lista.exibirOrdemInversa();
        assertEquals("20, 15, 5", lista.toString());
    }

    @Test
    public void testeListaDupla6(){
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(5);
        lista.exibirOrdemInversa();
        assertEquals("20, 15, 10", lista.toString());
    }

    @Test
    public void testeListaDupla7(){
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        lista.exibirOrdemInversa();
        assertEquals("", lista.toString());
    }

}
