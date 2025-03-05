import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.entities.ListaEstatica;

public class ListaEstaticaTest {
    @Test
    public void testeInverter(){
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inverter();
        assertEquals( "20,15,10,5",lista.toString());
    }

    @Test
    public void testeInverter2(){
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);

        lista.inverter();
        assertEquals("25,20,15,10,5",lista.toString());

    }
}
