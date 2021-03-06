/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 3
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e3;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/*
 *  MODELO TABLA:
 *
 *  NETWORK | TOPIC1 | TOPIC2 | TOPIC3 | TOPIC4 | TOPIC5 |
 *   USER1  |  TRUE  |  FALSE |  TRUE  |  TRUE  |  FALSE |
 *   USER2  |  FALSE |  TRUE  |  TRUE  |  FALSE |  TRUE  |
 *   USER3  |  TRUE  |  TRUE  |  FALSE |  TRUE  |  FALSE |
 *   USER4  |  TRUE  |  FALSE |  FALSE |  FALSE |  FALSE |
 *    ...   |   ...  |   ...  |   ...  |  FALSE |  FALSE |
 */
public class NetworkManager1 implements NetworkManager {

    private final int nTopics = TopicOfInterest.values().length;
    private final int columns = nTopics + 1;
    private int rows = 1;

    DefaultTableModel table = new DefaultTableModel();

    /* constructor of the table: */
    public NetworkManager1() {
        Object[] firstRow = new Object[columns];

        firstRow[0] = "NETWORK";
        firstRow[1] = TopicOfInterest.Viajes;
        firstRow[2] = TopicOfInterest.Deportes;
        firstRow[3] = TopicOfInterest.Libros;
        firstRow[4] = TopicOfInterest.Ropa;
        firstRow[5] = TopicOfInterest.Comida;

        table.addRow(firstRow);

        table.addColumn("NETWORK");
        table.setValueAt("NETWORK", 0, 0);

        table.addColumn(TopicOfInterest.Viajes);
        table.setValueAt(TopicOfInterest.Viajes, 0, 1);

        table.addColumn(TopicOfInterest.Deportes);
        table.setValueAt(TopicOfInterest.Deportes, 0, 2);

        table.addColumn(TopicOfInterest.Libros);
        table.setValueAt(TopicOfInterest.Libros, 0, 3);

        table.addColumn(TopicOfInterest.Ropa);
        table.setValueAt(TopicOfInterest.Ropa, 0, 4);

        table.addColumn(TopicOfInterest.Comida);
        table.setValueAt(TopicOfInterest.Comida, 0, 5);
    }

    /**
     * Adds a user to the user list.
     *
     * @param username                  String with the username of the user
     * @param topicsOfInterest          List of interests of the user
     * @throws IllegalArgumentException if the user is already in the list
     * @throws NullPointerException     if username or topicsOfInterest are null
     */
    @Override
    public void addUser(String username, List<TopicOfInterest> topicsOfInterest) {
        Object[] newRow = new Object[columns];
        boolean changedValue = false;

        if (username == null || topicsOfInterest == null) {
            throw new NullPointerException();
        }

        newRow[0] = username;

        /* se recorren las columnas de topics
         * para asignárselas al usuario:  */
        for (int i = 1; i < columns; i++) {
            /* se recorre la lista de topics a introducir: */
            for (TopicOfInterest topic : topicsOfInterest) {
                /* si la columna coincide con el topic,
                 * se le añade al usuario en su lista: */
                if (table.getValueAt(0, i) == topic) {
                    newRow[i] = true;
                    changedValue = true;
                    break;
                }
            }
            /* si no se le ha puesto el topic
             * a true, se pone a false: */
            if (!changedValue) {
                newRow[i] = false;
            }
            changedValue = false;
        }

        /* si se encuentra un usuario con el
         * mismo username, se lanza un throw */
        for (int i = 1; i < rows; i++) {
            if (table.getValueAt(i, 0) == username) {
                throw new IllegalArgumentException();
            }
        }

        /* se añade la fila con los datos del usuario: */
        table.addRow(newRow);
        rows++;

    }

    /**
     * Removes a user from the user list.
     *
     * @param username                  String with the username of the user
     * @throws IllegalArgumentException if the user was not found in the list
     * @throws NullPointerException     if username is null
     */
    @Override
    public void removeUser(String username) {

        if (username == null) {
            throw new NullPointerException();
        }

        for (int i = 1; i < rows; i++) {
            /* si se encuentra el usuario: */
            if (table.getValueAt(i, 0) == username) {
                /* se elimina la fila: */
                table.removeRow(i);
                rows--;
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Adds an interest to an user.
     *
     * @param username                  String with the username of the user
     * @param topicOfInterest           Topic to add to the user
     * @throws IllegalArgumentException if the user already had the topic
     * @throws NullPointerException     if username or topicOfInterest are null
     */
    @Override
    public void addInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (int i = 1; i < rows; i++) {
            /* si se encuentra al usuario (primera columna): */
            if (table.getValueAt(i, 0) == username) {
                for (int j = 1; j < columns; j++) {
                    /* cuando se llega al topic: */
                    if (table.getValueAt(0, j) == topicOfInterest) {
                        /* se comprueba que sea un boolean: */
                        if (table.getValueAt(i, j).getClass() == Boolean.class) {
                            /* si ya estaba a true, se lanza un throw */
                            if ((boolean) table.getValueAt(i, j)) {
                                throw new IllegalArgumentException();
                            }
                        }
                        table.setValueAt(true, i, j);
                    }
                }
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Removes an interest from an user.
     *
     * @param username                  String with the username of the user
     * @param topicOfInterest           Topic to add to the user
     * @throws IllegalArgumentException if the user did not have the topic already
     * @throws NullPointerException     if username or topicOfInterest are null
     */
    @Override
    public void removeInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (int i = 1; i < rows; i++) {
            /* si se encuentra al usuario (primera columna): */
            if (table.getValueAt(i, 0) == username) {
                for (int j = 1; j < columns; j++) {
                    /* cuando se llega al topic: */
                    if (table.getValueAt(0, j) == topicOfInterest) {
                        /* se comprueba que sea un boolean: */
                        if (table.getValueAt(i, j).getClass() == Boolean.class) {
                            /* si ya estaba a false, se lanza un throw */
                            if (!((boolean) table.getValueAt(i, j))) {
                                throw new IllegalArgumentException();
                            }
                        }

                        table.setValueAt(false, i, j);
                        return;
                    }
                }
            }
        }

        /* si no se encuentra al usuario en la tabla: */
        throw new IllegalArgumentException();
    }

    /**
     * Gives the list of users.
     *
     * @return the user list
     */
    @Override
    public List<String> getUsers() {
        List<String> userList = new ArrayList<>();

        for (int i = 1; i < rows; i++) {
            userList.add((String) table.getValueAt(i, 0));
        }

        return userList;
    }

    /**
     * Gives a list containing all the interests from the users.
     *
     * @return the topic list
     */
    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> topiclist = new ArrayList<>();
        boolean isInList;

        /* recorremos la parte de la tabla que
         * contiene los intereses de los usuarios: */
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                /* se comprueba que está tratando con un Boolean */
                if (table.getValueAt(i, j).getClass() == Boolean.class) {
                    /* si el topic está a true, se inserta en la lista: */
                    if ((boolean) table.getValueAt(i, j)) {
                        isInList = false;
                        /* se comprueba que el topic no se haya insertado ya: */
                        for (TopicOfInterest topic : topiclist) {
                            if (topic == table.getValueAt(0, j)) {
                                isInList = true;
                            }
                        }
                        /* si no se había insertado antes, se inserta: */
                        if (!isInList) {
                            topiclist.add((TopicOfInterest) table.getValueAt(0, j));
                        }
                    }
                }
            }
        }

        return topiclist;
    }

    /**
     * Gives a list containing the interests from a user.
     *
     * @param username String with the username of the user
     * @return the topic list
     * @throws IllegalArgumentException if the user was not found in the list
     * @throws NullPointerException     if username is null
     */
    @Override
    public List<TopicOfInterest> getInterestsUser(String username) {
        List<TopicOfInterest> topiclist = new ArrayList<>();

        if (username == null) {
            throw new NullPointerException();
        }

        for (int i = 1; i < rows; i++) {
            if (table.getValueAt(i, 0) == username) {
                for (int j = 1; j < columns; j++) {
                    if ((boolean) table.getValueAt(i, j)) {
                        topiclist.add((TopicOfInterest) table.getValueAt(0, j));
                    }
                }
                return topiclist;
            }
        }

        throw new IllegalArgumentException();
    }
}
