package e3;

import java.util.ArrayList;
import java.util.List;

/*
 *  TABLA:
 *
 *  NETWORK | USER1 | USER2 | USER3 | ...
 *  TOPIC1  | TRUE  | FALSE | TRUE  |
 *  TOPIC2  | FALSE | TRUE  | TRUE  |
 *  TOPIC3  | TRUE  | TRUE  | FALSE |
 *  TOPIC4  | TRUE  | FALSE | FALSE |
 *  TOPIC5  | TRUE  | FALSE | TRUE  |
 *    ...   |  ...  |  ...  |  ...  |
 */
public class NetworkManager1 implements NetworkManager {

    private final int nTopics = TopicOfInterest.values().length;
    private int nUsers = 0;
    private final int rows = nTopics + 1;
    private int columns = 2;

    private Object[][] table = new Object[rows][columns];

    public NetworkManager1() {
        table[0][0] = "NETWORK";
        table[1][0] = TopicOfInterest.Viajes;
        table[2][0] = TopicOfInterest.Deportes;
        table[3][0] = TopicOfInterest.Libros;
        table[4][0] = TopicOfInterest.Ropa;
        table[5][0] = TopicOfInterest.Comida;
    }

    @Override
    public void addUser(String username, List<TopicOfInterest> topicsOfInterest) {

        if (username == null || topicsOfInterest == null) {
            throw new NullPointerException();
        }

        table[0][++nUsers] = username;
        for (int i = 1; i <= nTopics; i++) {
            for (TopicOfInterest topic : topicsOfInterest) {
                /* se ponen los topics del usuario a true o a false
                 * en la tabla en función de la lista recibida */
                if (topic == table[i][0]) {
                    table[i][nUsers] = true;
                    break;
                } else {
                    table[i][nUsers] = false;
                }
            }
        }

        table = resizeTable(table);
    }

    private Object[][] resizeTable(Object[][] oldTable) {
        Object[][] newTable = new Object[rows][++columns];
        for (int i = 0; i <= nTopics; i++) {
            System.arraycopy(oldTable[i], 0, newTable[i], 0, nUsers + 1);
        }

        return newTable;
    }

    @Override
    public void removeUser(String username) {
        int column;
        boolean lastPos = false;

        if (username == null) {
            throw new NullPointerException();
        }

        for (column = 1; column <= nUsers; column++) {
            /* se busca el usuario en la tabla: */
            if (username.equals(table[0][column])) {
                /* se elimina el username y se comprueba
                 * si se trataba de la última posición: */
                table[0][column] = null;
                if (column + 1 == nUsers) {
                    lastPos = true;
                }
                break;
            }
        }

        /* se elimina la columna entera: */
        table[0][column] = null;
        for (int row = 1; row <= nTopics; row++) {
            table[row][column] = false;
        }

        if (!lastPos) {
            while (column + 1 != nUsers) {
                for (int row = 0; row <= nTopics; row++) {
                    table[row][column] = table[row][column + 1];
                }
            }
            table[0][column] = null;
            for (int row = 1; row <= nTopics; row++) {
                table[row][column] = false;
            }
        }
    }

    @Override
    public void addInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (int column = 1; column <= nUsers; column++) {
            /* se busca el usuario en la tabla: */
            if (username.equals(table[0][column])) {
                /* se pone su topic a true: */
                table[topicOfInterest.getTopicNumber()][column] = true;
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void removeInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (int column = 1; column <= nUsers; column++) {
            /* se busca el usuario en la tabla: */
            if (username.equals(table[0][column])) {
                /* se pone su topic a true: */
                table[topicOfInterest.getTopicNumber()][column] = false;
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        List<String> userList = new ArrayList<>();

        for (int column = 1; column <= nUsers; column++) {
            userList.add((String) table[0][column]);
        }

        return userList;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> topiclist = new ArrayList<>();

        for (int row = 1; row <= nTopics; row++) {
            for (int column = 1; column <= nUsers; column++) {
                if ((boolean) table[row][column]) {
                    topiclist.add((TopicOfInterest) table[row][0]);
                    break;
                }
            }
        }

        return topiclist;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String username) {
        List<TopicOfInterest> topiclist = new ArrayList<>();

        if (username == null) {
            throw new NullPointerException();
        }

        for (int column = 1; column <= nUsers; column++) {
            /* se busca el usuario en la tabla: */
            if (username.equals(table[0][column])) {
                for (int row = 1; row <= nTopics; row++) {
                    if ((boolean) table[row][column]) {
                        topiclist.add((TopicOfInterest) table[row][0]);
                        break;
                    }
                }
                return topiclist;
            }
        }

        throw new IllegalArgumentException();
    }
}
