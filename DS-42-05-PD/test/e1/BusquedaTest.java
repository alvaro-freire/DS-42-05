package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaTest {

    /* lista de billetes a filtrar */
    private final List<Billete> billeteList = new ArrayList<>();
    private final List<Billete> result = new ArrayList<>();

    private Busqueda busqueda;
    private Origen origen;
    private Destino destino;
    private Fecha fecha;
    private Precio precio;

    /* inicialización de fechas predeterminadas */
    private final Date d1 = new Date(1, 12, 2021);
    private final Date d2 = new Date(2, 12, 2021);
    private final Date d3 = new Date(3, 12, 2021);
    private final Date d4 = new Date(4, 12, 2021);
    private final Date d5 = new Date(5, 12, 2021);

    /* inicialización de billetes predeterminados */
    private final Billete b1 = new Billete("Coruña", "Vigo", 15, d1);
    private final Billete b2 = new Billete("Vigo", "Ourense", 15, d2);
    private final Billete b3 = new Billete("Santiago", "Coruña", 20, d5);
    private final Billete b4 = new Billete("Lugo", "Vigo", 18, d3);
    private final Billete b5 = new Billete("Santiago", "Ourense", 10, d4);

    @BeforeEach
    public void setUp() {

        /* se inicializan los filtros de orígenes y destinos predeterminados */
        origen = new Origen("Coruña", "Santiago", "Lugo");
        destino = new Destino("Vigo", "Ourense");

        /* se inicializa el filtro de fechas predeterminado */
        fecha = new Fecha(d1, d3, d5);

        /* se inicializa filtro de precio predeterminado */
        precio = new Precio(15, Precio.PriceOrder.LOWEREQ);

        /* se añaden los billetes predeterminados a la lista a filtrar */
        billeteList.clear();
        billeteList.add(b1);
        billeteList.add(b2);
        billeteList.add(b3);
        billeteList.add(b4);
        billeteList.add(b5);

        /* se inicializa la búsqueda con la lista de billetes correspondiente */
        busqueda = new Busqueda(billeteList);

    }

    @Test
    public void testFiltroOrigen() {
        /* Filtro de origen: [ "Coruña", "Santiago", "Lugo" ] */

        /* se añaden a la lista de comprobación los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b3);
        result.add(b4);
        result.add(b5);

        assertEquals(result, busqueda.filtrar(origen));

        /* se borra "Santiago" del filtro de orígenes */
        origen.removeOrigen("Santiago");

        /* se eliminan los billetes con origen = "Santiago" de la lista de comprobación */
        result.remove(b3);
        result.remove(b5);

        assertEquals(result, busqueda.filtrar(origen));

        /* se añade al filtro el origen "Vigo" */
        origen.addOrigen("Vigo");

        /* se añaden los billetes con origen = "Coruña" || "Lugo" || "Vigo" a la lista de comprobación */
        result.clear();
        result.add(b1);
        result.add(b2);
        result.add(b4);

        assertEquals(result, busqueda.filtrar(origen));

    }

    @Test
    public void testFiltroDestino() {
        /* Filtro de destino: [ "Vigo", "Ourense" ] */

        /* se añaden los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b2);
        result.add(b4);
        result.add(b5);

        assertEquals(result, busqueda.filtrar(destino));

        /* se borra "Ourense" del filtro de destino */
        destino.removeDestino("Ourense");

        /* se eliminan los billetes con destino = "Ourense" */
        result.remove(b2);
        result.remove(b5);

        assertEquals(result, busqueda.filtrar(destino));

        /* se añade al filtro el destino "Coruña" */
        destino.addDestino("Coruña");

        /* se añaden los billetes con destino = "Vigo" || "Coruña" a la lista de comprobación */
        result.clear();
        result.add(b1);
        result.add(b3);
        result.add(b4);

        assertEquals(result, busqueda.filtrar(destino));

    }

    @Test
    public void testiltroPrecio() {
        /* Filtro de precio: <= 15 */

        /* se añaden los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b2);
        result.add(b5);

        assertEquals(result, busqueda.filtrar(precio));

        /* se cambia el filtro Precio a: > 15 */
        precio.setPriceOrder(Precio.PriceOrder.HIGHER);

        /* se añaden los billetes que corresponden al filtro */
        result.clear();
        result.add(b3);
        result.add(b4);

        assertEquals(result, busqueda.filtrar(precio));

        /* se cambia el filtro Precio a: < 18 */
        precio.setPrecio(18);
        precio.setPriceOrder(Precio.PriceOrder.LOWER);

        /* se añaden los billetes que corresponden al filtro */
        result.clear();
        result.add(b1);
        result.add(b2);
        result.add(b5);

        assertEquals(result, busqueda.filtrar(precio));

    }

    @Test
    public void testFiltroFecha() {
        /* Filtro de fecha: 1/12/2021 | 3/12/2021 | 5/12/2021 */

        /* se añaden los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b3);
        result.add(b4);

        assertEquals(result, busqueda.filtrar(fecha));

        /* se elimina del filtro Fecha la fecha '3/12/2021' */
        fecha.removeFecha(d3);

        /* se elimina el billete con fecha '3/12/2021' */
        result.remove(b4);

        assertEquals(result, busqueda.filtrar(fecha));

        /* se cambia el filtro Fecha: 2/12/2021 || 4/12/2021 */
        fecha.clearFecha();
        fecha.addFecha(d2);
        fecha.addFecha(d4);

        /* se añaden los billetes que corresponden al filtro */
        result.clear();
        result.add(b2);
        result.add(b5);

        assertEquals(result, busqueda.filtrar(fecha));

    }

    @Test
    public void testFiltros() {
        /* Filtro de origen: [ "Coruña", "Santiago", "Lugo" ] */
        /* Filtro de destino: [ "Vigo", "Ourense" ] */
        /* Filtro de precio: <= 15 */
        /* Filtro de fecha: 1/12/2021 | 3/12/2021 | 5/12/2021 */

        /* se añaden los billetes que corresponden a los filtros Origen y Destino */
        result.clear();
        result.add(b1);
        result.add(b4);
        result.add(b5);

        assertEquals(result, busqueda.filtrar(origen, destino));

        /* se añaden los billetes que corresponden a los filtros Origen, Destino y Precio */
        result.clear();
        result.add(b1);
        result.add(b5);

        assertEquals(result, busqueda.filtrar(origen, destino, precio));

        /* se añaden los billetes que corresponden a los filtros Origen, Destino, Precio y Fecha */
        result.clear();
        result.add(b1);

        assertEquals(result, busqueda.filtrar(origen, destino, precio, fecha));

        /* se cambia el orden de los filtros */
        assertEquals(result, busqueda.filtrar(destino, fecha, origen, precio));

    }

    @Test
    public void testToString() {

        assertEquals("*************** Búsqueda ***************\n" +
                "Lista de billetes (sin filtros):\n" +
                "\n" +
                "\tBillete {\n" +
                "\t\torigen = 'Coruña'\n" +
                "\t\tdestino = 'Vigo'\n" +
                "\t\tprecio = 15\n" +
                "\t\tfecha = 1/12/2021\n" +
                "\t}\n" +
                "\n" +
                "\tBillete {\n" +
                "\t\torigen = 'Vigo'\n" +
                "\t\tdestino = 'Ourense'\n" +
                "\t\tprecio = 15\n" +
                "\t\tfecha = 2/12/2021\n" +
                "\t}\n" +
                "\n" +
                "\tBillete {\n" +
                "\t\torigen = 'Santiago'\n" +
                "\t\tdestino = 'Coruña'\n" +
                "\t\tprecio = 20\n" +
                "\t\tfecha = 5/12/2021\n" +
                "\t}\n" +
                "\n" +
                "\tBillete {\n" +
                "\t\torigen = 'Lugo'\n" +
                "\t\tdestino = 'Vigo'\n" +
                "\t\tprecio = 18\n" +
                "\t\tfecha = 3/12/2021\n" +
                "\t}\n" +
                "\n" +
                "\tBillete {\n" +
                "\t\torigen = 'Santiago'\n" +
                "\t\tdestino = 'Ourense'\n" +
                "\t\tprecio = 10\n" +
                "\t\tfecha = 4/12/2021\n" +
                "\t}\n", busqueda.toString());

        assertEquals("*************** Búsqueda ***************\n" +
                "Filtros: Origen [ Coruña, Santiago, Lugo ] || Destino [ Vigo, Ourense ] || Precio (<=15) || Fecha [ 1/12/2021, 3/12/2021, 5/12/2021 ] :\n" +
                "\n" +
                "\tBillete {\n" +
                "\t\torigen = 'Coruña'\n" +
                "\t\tdestino = 'Vigo'\n" +
                "\t\tprecio = 15\n" +
                "\t\tfecha = 1/12/2021\n" +
                "\t}\n", busqueda.toString(origen, destino, precio, fecha));

    }

    @Test
    public void testThrows() {

        /* NullPointerException Throws */
        assertThrows(NullPointerException.class, () -> new Busqueda(null));
        assertThrows(NullPointerException.class, () -> origen.addOrigen(null));
        assertThrows(NullPointerException.class, () -> destino.addDestino(null));
        assertThrows(NullPointerException.class, () -> origen.removeOrigen(null));
        assertThrows(NullPointerException.class, () -> destino.removeDestino(null));
        assertThrows(NullPointerException.class, () -> new Precio(0, null));
        assertThrows(NullPointerException.class, () -> fecha.addFecha(null));
        assertThrows(NullPointerException.class, () -> fecha.removeFecha(null));
        assertThrows(NullPointerException.class, () -> new Billete(null, "Coruña", 0, d1));
        assertThrows(NullPointerException.class, () -> new Billete("Coruña", null, 0, d1));
        assertThrows(NullPointerException.class, () -> new Billete("Coruña", "Vigo", 0, null));

        /* IllegalArgumentException Throws */
        assertThrows(IllegalArgumentException.class, () -> origen.addOrigen("Coruña"));
        assertThrows(IllegalArgumentException.class, () -> destino.addDestino("Vigo"));
        assertThrows(IllegalArgumentException.class, () -> origen.removeOrigen("Barcelona"));
        assertThrows(IllegalArgumentException.class, () -> destino.removeDestino("Madrid"));
        assertThrows(IllegalArgumentException.class, () -> new Precio(-5, Precio.PriceOrder.LOWER));
        assertThrows(IllegalArgumentException.class, () -> fecha.addFecha(d1));
        assertThrows(IllegalArgumentException.class, () -> fecha.removeFecha(new Date( 1, 1, 1)));
        assertThrows(IllegalArgumentException.class, () -> new Date(-1, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Date(0, -1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Date(0, 0, -1));
        assertThrows(IllegalArgumentException.class, () -> new Billete("Coruña", "Vigo", -5, d1));

    }

}