package e3;

import e2.Anuncio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class NetworkTest {

    private final Network network1 = new Network(new NetworkManager1());

    private final Network network2 = new Network(new NetworkManager2());

    private final List<TopicOfInterest> list1 = new ArrayList<>();

    private final List<TopicOfInterest> list2 = new ArrayList<>();

    private final List<TopicOfInterest> list3 = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        List<String> userList;

        userList = network1.getUsers();
        for (String s : userList) {
            network1.removeUser(s);
        }

        userList = network2.getUsers();
        for (String s : userList) {
            network2.removeUser(s);
        }

        /* se añaden topics la lista1 */
        list1.add(TopicOfInterest.Viajes);
        list1.add(TopicOfInterest.Libros);

        /* se añaden topics a la lista2 */
        list2.add(TopicOfInterest.Comida);
        list2.add(TopicOfInterest.Deportes);

        /* se añaden topics a la lista3 */
        list3.add(TopicOfInterest.Ropa);
        list3.add(TopicOfInterest.Libros);

    }

    @Test
    public void testAddAndRemove() {
        /* lista auxiliar de usuarios de la red */
        List<String> userList = new ArrayList<>();

        /* lista vacía */
        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se añaden usuarios */
        network1.addUser("user1", list1);
        network1.addUser("user2", list2);
        network1.addUser("user3", list3);

        network2.addUser("user1", list1);
        network2.addUser("user2", list2);
        network2.addUser("user3", list3);

        /* se añaden topics */
        network1.addInterest("user1", TopicOfInterest.Ropa);
        network2.addInterest("user2", TopicOfInterest.Ropa);


        /* se añaden los usuarios en la lista
         * auxiliar en el orden correspondiente */
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se elimina al user1 */
        network1.removeUser("user1");
        network2.removeUser("user1");
        userList.remove("user1");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se elimina al user2 */
        network1.removeUser("user2");
        network2.removeUser("user2");
        userList.remove("user2");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se elimina al user3 */
        network1.removeUser("user3");
        network2.removeUser("user3");
        userList.remove("user3");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

    }

    @Test
    public void testThrows() {

        /* parámetro inválido al instanciar una network */
        assertThrows(NullPointerException.class, () -> new Network(null));

        /* parámetros inválidos enviados a los métodos */
        assertThrows(NullPointerException.class, () -> network1.addUser(null, list1));
        assertThrows(NullPointerException.class, () -> network2.addUser(null, list1));
        assertThrows(NullPointerException.class, () -> network1.addUser("user1", null));
        assertThrows(NullPointerException.class, () -> network2.addUser("user1", null));

        assertThrows(NullPointerException.class, () -> network1.removeUser(null));
        assertThrows(NullPointerException.class, () -> network2.removeUser(null));

        assertThrows(NullPointerException.class, () -> network1.addInterest(null, TopicOfInterest.Viajes));
        assertThrows(NullPointerException.class, () -> network2.addInterest(null, TopicOfInterest.Viajes));
        assertThrows(NullPointerException.class, () -> network1.addInterest("user1", null));
        assertThrows(NullPointerException.class, () -> network2.addInterest("user1", null));

        assertThrows(NullPointerException.class, () -> network1.removeInterest(null, TopicOfInterest.Viajes));
        assertThrows(NullPointerException.class, () -> network2.removeInterest(null, TopicOfInterest.Viajes));
        assertThrows(NullPointerException.class, () -> network1.removeInterest("user1", null));
        assertThrows(NullPointerException.class, () -> network2.removeInterest("user1", null));

        assertThrows(NullPointerException.class, () -> network1.getInterestsUser(null));
        assertThrows(NullPointerException.class, () -> network2.getInterestsUser(null));

        /* se intenta añadir un usuario existente */
        network1.addUser("user1", list1);
        network2.addUser("user1", list1);
        assertThrows(IllegalArgumentException.class, () -> network1.addUser("user1", list1));
        assertThrows(IllegalArgumentException.class, () -> network2.addUser("user1", list1));

        /* se intenta eliminar un usuario inexistente */
        assertThrows(IllegalArgumentException.class, () -> network1.removeUser("user3"));
        assertThrows(IllegalArgumentException.class, () -> network2.removeUser("user3"));

        /* se intenta añadir un topic que un usuario ya tiene */
        assertThrows(IllegalArgumentException.class, () -> network1.addInterest("user1", TopicOfInterest.Viajes));
        assertThrows(IllegalArgumentException.class, () -> network2.addInterest("user1", TopicOfInterest.Viajes));

        /* se intenta añadir un topic a un usuario inexistente */
        assertThrows(IllegalArgumentException.class, () -> network1.addInterest("user3", TopicOfInterest.Viajes));
        assertThrows(IllegalArgumentException.class, () -> network2.addInterest("user3", TopicOfInterest.Viajes));

        /* se intenta eliminar un topic a un usuario inexistente */
        assertThrows(IllegalArgumentException.class, () -> network1.removeInterest("user3", TopicOfInterest.Viajes));
        assertThrows(IllegalArgumentException.class, () -> network2.removeInterest("user3", TopicOfInterest.Viajes));

        /* se intenta obtener la lista de topics de un usuario inexistente */
        assertThrows(IllegalArgumentException.class, () -> network1.getInterestsUser("user3"));
        assertThrows(IllegalArgumentException.class, () -> network2.getInterestsUser("user3"));

    }

    @Test
    public void testToString() {

                    /* ---- TEST FOR NETWORK1 ---- */

        /* Red gestionada mediante una tabla. Utilizando esta    *
         * implementación, el método toString siempre imprimirá  *
         * la lista de Topics de un usuario en un orden          *
         * predefinido: "Viajes, Deportes, Libros, Ropa, Comida" *
         * puesto que las columnas de la tabla son fijas.        */

        network1.addUser("user1", list1);
        network1.addUser("user2", list2);
        network1.addUser("user3", list3);
        network1.addInterest("user1", TopicOfInterest.Comida);
        network1.addInterest("user2", TopicOfInterest.Viajes);
        network1.addInterest("user2", TopicOfInterest.Libros);
        network1.addInterest("user2", TopicOfInterest.Ropa);

        assertEquals(
                "user1 -> Topics { Viajes Libros Comida }\n" +
                        "user2 -> Topics { Viajes Deportes Libros Ropa Comida }\n" +
                        "user3 -> Topics { Libros Ropa }\n",
                network1.toString());

        network1.removeInterest("user1", TopicOfInterest.Libros);
        network1.removeInterest("user2", TopicOfInterest.Deportes);

        assertEquals(
                "user1 -> Topics { Viajes Comida }\n" +
                        "user2 -> Topics { Viajes Libros Ropa Comida }\n" +
                        "user3 -> Topics { Libros Ropa }\n",
                network1.toString());

        network1.removeUser("user2");

        assertEquals(
                "user1 -> Topics { Viajes Comida }\n" +
                        "user3 -> Topics { Libros Ropa }\n",
                network1.toString());


                    /* ---- TEST FOR NETWORK2 ---- */

        /* se debe tener en cuenta que con esta implementación   *
         * el método toString no mantiene el mismo orden que la  *
         * implementación de la tabla (con valores fijos), por   *
         * ello el output no será exactamente el mismo. Lo que   *
         * consideramos imporante es que la lista de Topics de   *
         * cada usuario tenga los mismos elementos,              *
         * independientemente del orden en el que se muestren.   */

        network2.addUser("user1", list1);
        network2.addUser("user2", list2);
        network2.addUser("user3", list3);
        network2.addInterest("user1", TopicOfInterest.Comida);
        network2.addInterest("user2", TopicOfInterest.Viajes);
        network2.addInterest("user2", TopicOfInterest.Libros);
        network2.addInterest("user2", TopicOfInterest.Ropa);

        assertEquals(
                "user1 -> Topics { Viajes Libros Comida }\n" +
                        "user2 -> Topics { Comida Deportes Viajes Libros Ropa }\n" +
                        "user3 -> Topics { Ropa Libros }\n",
                network2.toString());

        network2.removeInterest("user1", TopicOfInterest.Libros);
        network2.removeInterest("user2", TopicOfInterest.Deportes);

        assertEquals(
                "user1 -> Topics { Viajes Comida }\n" +
                        "user2 -> Topics { Comida Viajes Libros Ropa }\n" +
                        "user3 -> Topics { Ropa Libros }\n",
                network2.toString());

        network2.removeUser("user2");

        assertEquals(
                "user1 -> Topics { Viajes Comida }\n" +
                        "user3 -> Topics { Ropa Libros }\n",
                network2.toString());
    }
}