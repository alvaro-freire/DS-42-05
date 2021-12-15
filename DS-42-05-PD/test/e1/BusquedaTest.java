package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaTest {

    Busqueda busqueda;

    @BeforeEach
    public void setUp() {
        Origen origen = new Origen("Coruña", "Santiago");
        Destino destino = new Destino("Vigo");
        Precio precio = new Precio(15, Precio.PriceOrder.LOWEREQ);
        Date d1 = new Date(30, 1, 1947);
        Fecha fecha = new Fecha(d1);
        List<Billete> list = new ArrayList<>();

        Billete b1 = new Billete("Coruña", "Vigo", 15, d1);
        list.add(b1);
        Billete b2 = new Billete("Vigo", "Santiago", 15, d1);
        list.add(b2);
        Billete b3 = new Billete("Santiago", "Coruña", 10, d1);
        list.add(b3);
        Billete b4 = new Billete("Ourense", "Vigo", 18, d1);
        list.add(b4);
        Billete b5 = new Billete("Santiago", "Coruña", 12, d1);
        list.add(b5);
    }

    @Test
    public void test() {
        List<Billete> result;

        Origen origen = new Origen("Coruña", "Santiago");
        Destino destino = new Destino("Vigo");
        Precio precio = new Precio(15, Precio.PriceOrder.LOWEREQ);
        Date d1 = new Date(30, 1, 1947);
        Fecha fecha = new Fecha(d1);
        List<Billete> list = new ArrayList<>();

        Billete b1 = new Billete("Coruña", "Vigo", 15, d1);
        list.add(b1);
        Billete b2 = new Billete("Vigo", "Santiago", 15, d1);
        list.add(b2);
        Billete b3 = new Billete("Santiago", "Coruña", 10, d1);
        list.add(b3);
        Billete b4 = new Billete("Ourense", "Vigo", 18, d1);
        list.add(b4);
        Billete b5 = new Billete("Santiago", "Coruña", 12, d1);
        list.add(b5);

        busqueda = new Busqueda(list);

        result = busqueda.filtrar();

    }

}