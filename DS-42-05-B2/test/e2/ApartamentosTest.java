package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartamentosTest {

    private final Apartamentos alquilerApartamentos = new Apartamentos();

    private final Anuncio anuncio1 = new Anuncio(1, 110, 20, 1, 50, 15630);

    private final Anuncio anuncio2 = new Anuncio(2, 150, 50, 0, 55, 15608);

    private final Anuncio anuncio3 = new Anuncio(3, 140, 10, 2, 45, 15609);

    @BeforeEach
    void setUp() {

        alquilerApartamentos.clearList();
        alquilerApartamentos.setComparador(null);
        alquilerApartamentos.sortList();

        /* anuncio1 */
        anuncio1.setNumReferencia(1);
        anuncio1.setPrecioBase(110);
        anuncio1.setPrecioPlaza(20);
        anuncio1.setNumPlazas(1);
        anuncio1.setTamano(50);
        anuncio1.setCp(15630);

        /* anuncio2 */
        anuncio2.setNumReferencia(2);
        anuncio2.setPrecioBase(150);
        anuncio2.setPrecioPlaza(50);
        anuncio2.setNumPlazas(0);
        anuncio2.setTamano(55);
        anuncio2.setCp(15608);

        /* anuncio3 */
        anuncio3.setNumReferencia(3);
        anuncio3.setPrecioBase(140);
        anuncio3.setPrecioPlaza(10);
        anuncio3.setNumPlazas(2);
        anuncio3.setTamano(45);
        anuncio3.setCp(15609);
    }

    @Test
    public void testAddAndRemove() {

        alquilerApartamentos.addAnuncio(anuncio1);
        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);

        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(1));
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(2));

        alquilerApartamentos.removeAnuncio(anuncio2);
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(1));

        alquilerApartamentos.removeAnuncio(anuncio1);
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(0));

        alquilerApartamentos.removeAnuncio(anuncio3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> alquilerApartamentos.getAnuncio(0));
    }

    @Test
    public void testThrows() {

        /* par??metros inv??lidos al instanciar un anuncio */
        assertThrows(IllegalArgumentException.class,
                () -> new Anuncio(-1, 1, 1, 1, 1, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Anuncio(1, -1, 1, 1, 1, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Anuncio(1, 1, -1, 1, 1, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Anuncio(1, 1, 1, -1, 1, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Anuncio(1, 1, 1, 1, -1, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Anuncio(1, 1, 1, 1, 1, -1));

        /* par??metros inv??lidos al editar anuncios */
        assertThrows(IllegalArgumentException.class, () -> anuncio1.setNumReferencia(-1));
        assertThrows(IllegalArgumentException.class, () -> anuncio1.setPrecioBase(-1));
        assertThrows(IllegalArgumentException.class, () -> anuncio1.setPrecioPlaza(-1));
        assertThrows(IllegalArgumentException.class, () -> anuncio1.setNumPlazas(-1));
        assertThrows(IllegalArgumentException.class, () -> anuncio1.setTamano(-1));
        assertThrows(IllegalArgumentException.class, () -> anuncio1.setCp(-1));

        /* par??metro "null" al a??adir anuncio */
        assertThrows(NullPointerException.class, () -> alquilerApartamentos.addAnuncio(null));

        /* se a??ade el mismo anuncio dos veces */
        alquilerApartamentos.addAnuncio(anuncio1);
        assertThrows(IllegalArgumentException.class, () -> alquilerApartamentos.addAnuncio(anuncio1));

        /* se igualan los campos del anuncio1 y el anuncio2 y se intenta a??adir a la lista */
        anuncio2.setNumReferencia(1);
        anuncio2.setPrecioBase(110);
        anuncio2.setPrecioPlaza(20);
        anuncio2.setNumPlazas(1);
        anuncio2.setTamano(50);
        anuncio2.setCp(15630);
        assertThrows(IllegalArgumentException.class, () -> alquilerApartamentos.addAnuncio(anuncio2));

        /* se intenta recuperar un anuncio de
         * una posici??n inexistente en la lista */
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> alquilerApartamentos.getAnuncio(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> alquilerApartamentos.getAnuncio(5));

        /* se intenta borrar integrante inexistente */
        assertThrows(IllegalArgumentException.class, () -> alquilerApartamentos.removeAnuncio(anuncio3));
    }

    @Test
    public void testEquals() {

        /* se comprueban anuncios distintos */
        assertNotEquals(anuncio1, anuncio2);

        /* se comprueba el mismo objeto */
        assertEquals(anuncio1, anuncio1);

        /* se igualan los campos del anuncio1 y el anuncio2 */
        anuncio2.setNumReferencia(1);
        anuncio2.setPrecioBase(110);
        anuncio2.setPrecioPlaza(20);
        anuncio2.setNumPlazas(1);
        anuncio2.setTamano(50);
        anuncio2.setCp(15630);

        assertEquals(anuncio1, anuncio2);
    }

    @Test
    public void testHashCode() {
        /* se comprueban anuncios distintos */
        assertNotEquals(anuncio1.hashCode(), anuncio2.hashCode());

        /* se comprueba el mismo objeto */
        assertEquals(anuncio1.hashCode(), anuncio1.hashCode());

        /* se igualan los campos del anuncio1 y el anuncio2 */
        anuncio2.setNumReferencia(1);
        anuncio2.setPrecioBase(110);
        anuncio2.setPrecioPlaza(20);
        anuncio2.setNumPlazas(1);
        anuncio2.setTamano(50);
        anuncio2.setCp(15630);

        assertEquals(anuncio1.hashCode(), anuncio2.hashCode());
    }

    @Test
    public void testNaturalSort() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        /* ordenaci??n natural (n?? de referencia) */
        alquilerApartamentos.sortList();

        /* primera posici??n de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));
        /* segunda posici??n de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(1));
        /* tercera posici??n de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(2));
    }

    @Test
    public void testSortByPrecioBase() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        alquilerApartamentos.setComparador(new SortByPrecioBase());

        /* ordenaci??n por precio base */
        alquilerApartamentos.sortList();
        /* primera posici??n de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));
        /* segunda posici??n de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(1));
        /* tercera posici??n de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(2));
    }

    @Test
    public void testSortByPrecioTotal() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        alquilerApartamentos.setComparador(new SortByPrecioTotal());

        /* ordenaci??n por precio total */
        alquilerApartamentos.sortList();
        /* primera posici??n de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(0));
        /* segunda posici??n de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(1));
        /* tercera posici??n de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(2));
    }

    @Test
    public void testSortByTamano() {

        alquilerApartamentos.addAnuncio(anuncio2);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio1);

        alquilerApartamentos.setComparador(new SortByTamano());

        /* ordenaci??n por tama??o */
        alquilerApartamentos.sortList();

        /* primera posici??n de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(0));
        /* segunda posici??n de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(1));
        /* tercera posici??n de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(2));
    }

    @Test
    public void testSortByCp() {

        alquilerApartamentos.addAnuncio(anuncio1);
        alquilerApartamentos.addAnuncio(anuncio3);
        alquilerApartamentos.addAnuncio(anuncio2);

        alquilerApartamentos.setComparador(new SortByCp());

        /* ordenaci??n por c??digo postal */
        alquilerApartamentos.sortList();

        /* primera posici??n de la lista */
        assertEquals(anuncio2, alquilerApartamentos.getAnuncio(0));
        /* segunda posici??n de la lista */
        assertEquals(anuncio3, alquilerApartamentos.getAnuncio(1));
        /* tercera posici??n de la lista */
        assertEquals(anuncio1, alquilerApartamentos.getAnuncio(2));
    }

    @Test
    public void testToString() {

        /* se a??ade el primer anuncio a la lista y se imprimen los datos: */
        alquilerApartamentos.addAnuncio(anuncio1);
        assertEquals(
                "Anuncio 0:\n" +
                        "\tN?? Ref.: 1\n" +
                        "\tPrecio base: 110\n" +
                        "\tPrecio plazas: 20\n" +
                        "\tN?? plazas: 1\n" +
                        "\tPrecio total: 130\n" +
                        "\tTama??o: 50\n" +
                        "\tC??digo postal: 15630\n",
                alquilerApartamentos.toString());

        /* se a??ade el segundo anuncio: */
        alquilerApartamentos.addAnuncio(anuncio2);
        assertEquals(
                "Anuncio 0:\n" +
                        "\tN?? Ref.: 1\n" +
                        "\tPrecio base: 110\n" +
                        "\tPrecio plazas: 20\n" +
                        "\tN?? plazas: 1\n" +
                        "\tPrecio total: 130\n" +
                        "\tTama??o: 50\n" +
                        "\tC??digo postal: 15630\n" +
                        "Anuncio 1:\n" +
                        "\tN?? Ref.: 2\n" +
                        "\tPrecio base: 150\n" +
                        "\tPrecio plazas: 50\n" +
                        "\tN?? plazas: 0\n" +
                        "\tPrecio total: 150\n" +
                        "\tTama??o: 55\n" +
                        "\tC??digo postal: 15608\n",
                alquilerApartamentos.toString());

        /* se ordena la lista por c??digo postal: */
        alquilerApartamentos.setComparador(new SortByCp());
        alquilerApartamentos.sortList();
        assertEquals(
                "Anuncio 0:\n" +
                        "\tN?? Ref.: 2\n" +
                        "\tPrecio base: 150\n" +
                        "\tPrecio plazas: 50\n" +
                        "\tN?? plazas: 0\n" +
                        "\tPrecio total: 150\n" +
                        "\tTama??o: 55\n" +
                        "\tC??digo postal: 15608\n" +
                        "Anuncio 1:\n" +
                        "\tN?? Ref.: 1\n" +
                        "\tPrecio base: 110\n" +
                        "\tPrecio plazas: 20\n" +
                        "\tN?? plazas: 1\n" +
                        "\tPrecio total: 130\n" +
                        "\tTama??o: 50\n" +
                        "\tC??digo postal: 15630\n",
                alquilerApartamentos.toString());

        /* se elimina de la lista el primer anuncio: */
        alquilerApartamentos.removeAnuncio(anuncio1);
        assertEquals(
                "Anuncio 0:\n" +
                        "\tN?? Ref.: 2\n" +
                        "\tPrecio base: 150\n" +
                        "\tPrecio plazas: 50\n" +
                        "\tN?? plazas: 0\n" +
                        "\tPrecio total: 150\n" +
                        "\tTama??o: 55\n" +
                        "\tC??digo postal: 15608\n",
                alquilerApartamentos.toString());

        /* se a??ade el anuncio 3 a la lista: */
        alquilerApartamentos.addAnuncio(anuncio3);
        assertEquals(
                "Anuncio 0:\n" +
                        "\tN?? Ref.: 2\n" +
                        "\tPrecio base: 150\n" +
                        "\tPrecio plazas: 50\n" +
                        "\tN?? plazas: 0\n" +
                        "\tPrecio total: 150\n" +
                        "\tTama??o: 55\n" +
                        "\tC??digo postal: 15608\n" +
                        "Anuncio 1:\n" +
                        "\tN?? Ref.: 3\n" +
                        "\tPrecio base: 140\n" +
                        "\tPrecio plazas: 10\n" +
                        "\tN?? plazas: 2\n" +
                        "\tPrecio total: 160\n" +
                        "\tTama??o: 45\n" +
                        "\tC??digo postal: 15609\n",
                alquilerApartamentos.toString());

        /* se a??ade de nuevo el anuncio 1 y se ordena la lista por tama??o: */
        alquilerApartamentos.addAnuncio(anuncio1);
        alquilerApartamentos.setComparador(new SortByTamano());
        alquilerApartamentos.sortList();
        assertEquals(
                "Anuncio 0:\n" +
                        "\tN?? Ref.: 3\n" +
                        "\tPrecio base: 140\n" +
                        "\tPrecio plazas: 10\n" +
                        "\tN?? plazas: 2\n" +
                        "\tPrecio total: 160\n" +
                        "\tTama??o: 45\n" +
                        "\tC??digo postal: 15609\n" +
                        "Anuncio 1:\n" +
                        "\tN?? Ref.: 1\n" +
                        "\tPrecio base: 110\n" +
                        "\tPrecio plazas: 20\n" +
                        "\tN?? plazas: 1\n" +
                        "\tPrecio total: 130\n" +
                        "\tTama??o: 50\n" +
                        "\tC??digo postal: 15630\n" +
                        "Anuncio 2:\n" +
                        "\tN?? Ref.: 2\n" +
                        "\tPrecio base: 150\n" +
                        "\tPrecio plazas: 50\n" +
                        "\tN?? plazas: 0\n" +
                        "\tPrecio total: 150\n" +
                        "\tTama??o: 55\n" +
                        "\tC??digo postal: 15608\n",
                alquilerApartamentos.toString());

    }
}