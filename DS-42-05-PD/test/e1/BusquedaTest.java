package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaTest {

    @Test
    public void test() {
        Origen origen = new Origen("Coruña", "Santiago");
        Destino destino = new Destino("Vigo");
        Precio precio = new Precio(15, Precio.PriceOrder.LOWEREQ);
        Fecha fecha = new Fecha(new Date(121, Calendar.DECEMBER, 20));
        List<Billete> list = new ArrayList<>();
        List<Billete> list_updated = new ArrayList<>();

        Billete b1 = new Billete("Coruña", "Vigo", 15, new Date(121, Calendar.DECEMBER, 20));
        list.add(b1);
        Billete b2 = new Billete("Vigo", "Santiago", 15, new Date(121, Calendar.DECEMBER, 20));
        list.add(b2);
        Billete b3 = new Billete("Santiago", "Coruña", 10, new Date(121, Calendar.DECEMBER, 20));
        list.add(b3);
        Billete b4 = new Billete("Ourense", "Vigo", 18, new Date(121, Calendar.DECEMBER, 20));
        list.add(b4);
        Billete b5 = new Billete("Santiago", "Coruña", 12, new Date(121, Calendar.DECEMBER, 20));
        list.add(b5);


        Busqueda busqueda = new Busqueda(list);
        list_updated = busqueda.filtrar(origen, destino, precio, fecha);

        list_updated = busqueda.filtrar(origen, precio);
    }

}