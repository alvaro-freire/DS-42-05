package e3;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private final List<User> userList = new ArrayList<>();

    public Network() {

    }

    public void addUser(User user) {

        if (user == null) {
            throw new IllegalArgumentException();
        }

        for (User u : userList) {
            if (u.equals(user)) {
                throw new IllegalArgumentException();
            }
        }

        userList.add(user);
    }

    public void removeUser(User user) {
        for (User u : userList) {
            if (u.equals(user)) {
                userList.remove(user);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void clearList() {
        userList.clear();
    }

    public User getUser(int index) {

        if (userList.isEmpty() || index < 0 || index >= userList.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return userList.get(index);
    }


    public List<User> getList() {
        return userList;
    }

}
