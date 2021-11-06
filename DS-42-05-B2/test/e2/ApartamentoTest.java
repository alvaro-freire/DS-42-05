package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartamentoTest {

    private final Apartamento alquilerApartamentos = new Apartamento();

    private final Anuncio anuncio1 = new Anuncio(1, 110, 20, 1, 50, 15630);

    private final Anuncio anuncio2 = new Anuncio(2, 150, 50, 0, 55, 15608);

    private final Anuncio anuncio3 = new Anuncio(3, 140, 10, 2, 45, 15609);

    @BeforeEach
    void setUp() {
        alquilerApartamentos.clearList();
    }

    @Test
    public void testNaturalSort() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        alquilerApartamentos.sortList();

        /* primera posición de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));

        /* segunda posición de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(1));

        /* tercera posición de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(2));

    }

    @Test
    public void testSortByPrecioBase() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        alquilerApartamentos.setComparador(new SortByPrecioBase());

        alquilerApartamentos.sortList();

        /* primera posición de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));

        /* segunda posición de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(1));

        /* tercera posición de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(2));

    }

    @Test
    public void testSortByPrecioTotal() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        alquilerApartamentos.setComparador(new SortByPrecioTotal());

        alquilerApartamentos.sortList();

        /* primera posición de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));

        /* segunda posición de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(1));

        /* tercera posición de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(2));

    }

    @Test
    public void testSortByTamano() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        alquilerApartamentos.setComparador(new SortByTamano());

        alquilerApartamentos.sortList();

        /* primera posición de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(0));

        /* segunda posición de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(1));

        /* tercera posición de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(2));

    }

    @Test
    public void testSortByCp() {

        alquilerApartamentos.addAnuncio(anuncio1);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio2);

        alquilerApartamentos.setComparador(new SortByCp());

        alquilerApartamentos.sortList();

        /* primera posición de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(0));

        /* segunda posición de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(1));

        /* tercera posición de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(2));

    }
}