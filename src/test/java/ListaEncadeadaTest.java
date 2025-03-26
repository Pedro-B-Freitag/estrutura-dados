import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.example.entities.ListaEncadeada;
import com.example.entities.NoLista;

public class ListaEncadeadaTest {
    @Test
    public void testeListaEncadeada1(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        assertEquals(true, lista.estaVazia());
    }

    @Test
    public void testeListaEncadeada2(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        assertEquals(false, lista.estaVazia());
    }

    @Test 
    public void testeListaEncadeada3(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        NoLista primeiro = lista.getPrimeiro();
        System.out.println(primeiro.getInfo());
        assertEquals(null, lista.buscar(1));
    }

    @Test
    public void testeListaEncadeada4(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        System.out.println(lista.toString());
        assertEquals(3, lista.obterComprimento());
    }

    @Test
    public void testeListaEncadeada5(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista resposta = lista.buscar(20);
        assertEquals(20,resposta.getInfo());
    }

    @Test
    public void testeListaEncadeada6(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista resposta = lista.buscar(15);
        assertEquals(15,resposta.getInfo());
    }

    @Test
    public void testeListaEncadeada7(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(null, lista.buscar(50));
    }

    @Test
    public void testeListaEncadeada8(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals("15 , 10 , 5", lista.toString());
    }

    @Test
    public void testeListaEncadeada9(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(15);
        assertEquals("20 , 10 , 5", lista.toString());
    }

    @Test
    public void testeListaEncadeada10(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista resultado = lista.obterNo(0);
        assertEquals(20, resultado.getInfo());
    }

    @Test
    public void testeListaEncadeada11(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista resultado = lista.obterNo(3);
        assertEquals(5, resultado.getInfo());
    }

    @Test
    public void testeListaEncadeada12(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        try {
            lista.obterNo(10);
            fail();
        } catch (IndexOutOfBoundsException e) {
        
        }
    }

}
