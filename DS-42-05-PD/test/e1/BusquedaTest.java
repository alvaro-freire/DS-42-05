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

    Busqueda busqueda;

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

        /* se añaden los billetes predeterminados a la lista a filtrar */
        billeteList.clear();
        billeteList.add(b1);
        billeteList.add(b2);
        billeteList.add(b3);
        billeteList.add(b4);
        billeteList.add(b5);

    }

    @Test
    public void testFiltroOrigen() {
        /* Filtro de origen: [ "Coruña", "Santiago", "Lugo" ] */

        /* se añaden a la lista de comprobación los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b3);
        result.add(b4);
        result.add(b5);

        busqueda = new Busqueda.Builder(billeteList).origen("Coruña", "Santiago", "Lugo").build();
        assertEquals(result, busqueda.getList());

        /* se eliminan los billetes con origen = "Santiago" de la lista de comprobación */
        result.remove(b3);
        result.remove(b5);

        busqueda = new Busqueda.Builder(billeteList).origen("Coruña", "Lugo").build();
        assertEquals(result, busqueda.getList());

        /* se añaden los billetes con origen = "Coruña" || "Lugo" || "Vigo" a la lista de comprobación */
        result.clear();
        result.add(b1);
        result.add(b2);
        result.add(b4);

        busqueda = new Busqueda.Builder(billeteList).origen("Coruña", "Lugo", "Vigo").build();
        assertEquals(result, busqueda.getList());

    }

    @Test
    public void testFiltroDestino() {
        /* Filtro de destino: [ "Vigo", "Ourense" ] */

        /* se añaden los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b2);
        result.add(b4);
        result.add(b5);

        busqueda = new Busqueda.Builder(billeteList).destino("Vigo", "Ourense").build();
        assertEquals(result, busqueda.getList());

        /* se eliminan los billetes con destino = "Ourense" */
        result.remove(b2);
        result.remove(b5);

        busqueda = new Busqueda.Builder(billeteList).destino("Vigo").build();
        assertEquals(result, busqueda.getList());

        /* se añaden los billetes con destino = "Vigo" || "Coruña" a la lista de comprobación */
        result.clear();
        result.add(b1);
        result.add(b3);
        result.add(b4);

        busqueda = new Busqueda.Builder(billeteList).destino("Vigo", "Coruña").build();
        assertEquals(result, busqueda.getList());

    }

    @Test
    public void testiltroPrecio() {
        /* Filtro de precio: <= 15 */

        /* se añaden los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b2);
        result.add(b5);

        busqueda = new Busqueda.Builder(billeteList).precio(15, PriceOrder.LOWEREQ).build();
        assertEquals(result, busqueda.getList());

        /* se añaden los billetes que corresponden al filtro */
        result.clear();
        result.add(b3);
        result.add(b4);

        busqueda = new Busqueda.Builder(billeteList).precio(15, PriceOrder.HIGHER).build();
        assertEquals(result, busqueda.getList());

        /* se añaden los billetes que corresponden al filtro */
        result.clear();
        result.add(b1);
        result.add(b2);
        result.add(b5);

        busqueda = new Busqueda.Builder(billeteList).precio(18, PriceOrder.LOWER).build();
        assertEquals(result, busqueda.getList());

    }

    @Test
    public void testFiltroFecha() {
        /* Filtro de fecha: 1/12/2021 | 3/12/2021 | 5/12/2021 */

        /* se añaden los billetes que corresponden al filtro */
        result.add(b1);
        result.add(b3);
        result.add(b4);

        busqueda = new Busqueda.Builder(billeteList).fecha(d1, d3, d5).build();
        assertEquals(result, busqueda.getList());

        /* se elimina el billete con fecha '3/12/2021' */
        result.remove(b4);

        busqueda = new Busqueda.Builder(billeteList).fecha(d1, d5).build();
        assertEquals(result, busqueda.getList());

        /* se añaden los billetes que corresponden al filtro */
        result.clear();
        result.add(b2);
        result.add(b5);

        busqueda = new Busqueda.Builder(billeteList).fecha(d2, d4).build();
        assertEquals(result, busqueda.getList());

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

        busqueda = new Busqueda.Builder(billeteList).origen("Coruña", "Santiago", "Lugo").
                destino("Vigo", "Ourense").build();
        assertEquals(result, busqueda.getList());

        /* se añaden los billetes que corresponden a los filtros Origen, Destino y Precio */
        result.clear();
        result.add(b1);
        result.add(b5);

        busqueda = new Busqueda.Builder(billeteList).origen("Coruña", "Santiago", "Lugo").destino("Vigo", "Ourense").
                precio(15, PriceOrder.LOWEREQ).build();
        assertEquals(result, busqueda.getList());

        /* se añaden los billetes que corresponden a los filtros Origen, Destino, Precio y Fecha */
        result.clear();
        result.add(b1);

        busqueda = new Busqueda.Builder(billeteList).origen("Coruña", "Santiago", "Lugo").destino("Vigo", "Ourense").
                precio(15, PriceOrder.LOWEREQ).fecha(d1, d3, d5).build();
        assertEquals(result, busqueda.getList());

        /* se cambia el orden de los filtros */

        busqueda = new Busqueda.Builder(billeteList).destino("Vigo", "Ourense").fecha(d1, d3, d5).
                origen("Coruña", "Santiago", "Lugo").precio(15, PriceOrder.LOWEREQ).build();
        assertEquals(result, busqueda.getList());

    }

    //@Test
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
                "\t}\n", busqueda.toString());

    }

    @Test
    public void testThrows() {

        /* NullPointerException Throws */
        assertThrows(NullPointerException.class, () -> new Busqueda.Builder(null));
        assertThrows(NullPointerException.class, () -> new Billete(null, "Coruña", 0, d1));
        assertThrows(NullPointerException.class, () -> new Billete("Coruña", null, 0, d1));
        assertThrows(NullPointerException.class, () -> new Billete("Coruña", "Vigo", 0, null));

        /* IllegalArgumentException Throws */
        assertThrows(IllegalArgumentException.class, () -> new Date(-1, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Date(0, -1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Date(0, 0, -1));
        assertThrows(IllegalArgumentException.class, () -> new Billete("Coruña", "Vigo", -5, d1));

    }

}