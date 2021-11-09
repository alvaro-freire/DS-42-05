package e3;

import javax.swing.table.DefaultTableModel;
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
    private final int columns = nTopics + 1;
    private int rows = 1;

    DefaultTableModel table = new DefaultTableModel();

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

    @Override
    public void addUser(String username, List<TopicOfInterest> topicsOfInterest) {
        Object[] newRow = new Object[columns];
        boolean changedValue = false;

        if (username == null || topicsOfInterest == null) {
            throw new NullPointerException();
        }

        newRow[0] = username;

        for (int i = 1; i < columns; i++) {
            for (TopicOfInterest topic : topicsOfInterest) {
                if (table.getValueAt(0, i) == topic) {
                    newRow[i] = true;
                    changedValue = true;
                    break;
                }
            }
            if (!changedValue) {
                newRow[i] = false;
            }
            changedValue = false;
        }

        for (int i = 1; i < rows; i++) {
            if (table.getValueAt(i, 0) == username) {
                throw new IllegalArgumentException();
            }
        }

        table.addRow(newRow);
        rows++;

    }

    @Override
    public void removeUser(String username) {

        if (username == null) {
            throw new NullPointerException();
        }

        for (int i = 1; i < rows; i++) {
            if (table.getValueAt(i, 0) == username) {
                table.removeRow(i);
                rows--;
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void addInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (int i = 1; i < rows; i++) {
            if (table.getValueAt(i, 0) == username) {
                for (int j = 1; j < columns; j++) {
                    if (table.getValueAt(0, j) == topicOfInterest) {
                        if (table.getValueAt(i, j).getClass() == boolean.class) {
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

    @Override
    public void removeInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (int i = 1; i < rows; i++) {
            if (table.getValueAt(i, 0) == username) {
                for (int j = 1; j < columns; j++) {
                    if (table.getValueAt(0, j) == topicOfInterest) {
                        table.setValueAt(false, i, j);
                    }
                }
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        List<String> userList = new ArrayList<>();

        for (int i = 1; i < rows; i++) {
            userList.add((String) table.getValueAt(i, 0));
        }

        return userList;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> topiclist = new ArrayList<>();

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if ((boolean) table.getValueAt(i, j)) {
                    topiclist.add((TopicOfInterest) table.getValueAt(0, j));
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
