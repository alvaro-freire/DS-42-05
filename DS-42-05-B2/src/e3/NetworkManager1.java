package e3;

import java.util.ArrayList;
import java.util.List;

public class NetworkManager1 implements NetworkManager {

    private final List<User> userList = new ArrayList<>();

    @Override
    public void addUser(String userName, List<TopicOfInterest> topicsOfInterest) {

        if (userName == null || topicsOfInterest == null) {
            throw new IllegalArgumentException();
        }

        for (User u : userList) {
            if (u.getUserName().equals(userName)) {
                throw new IllegalArgumentException();
            }
        }

        User user = new User(userName, topicsOfInterest);

        userList.add(user);
    }

    @Override
    public void removeUser(String userName) {

        if (userName == null) {
            throw new IllegalArgumentException();
        }

        for (User u : userList) {
            if (u.getUserName().equals(userName)) {
                userList.remove(u);
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void addInterest(String userName, TopicOfInterest topicOfInterest) {

        if (userName == null || topicOfInterest == null) {
            throw new IllegalArgumentException();
        }

        for (User u : userList) {
            if (u.getUserName().equals(userName)) {
                for (TopicOfInterest t : u.getTopicsOfInterest()) {
                    if (t.equals(topicOfInterest)) {
                        throw new IllegalArgumentException();
                    }
                }
                u.getTopicsOfInterest().add(topicOfInterest);
            }
        }
    }

    @Override
    public void removeInterest(String userName, TopicOfInterest topicOfInterest) {

        if (userName == null || topicOfInterest == null) {
            throw new IllegalArgumentException();
        }

        for (User u : userList) {
            if (u.getUserName().equals(userName)) {
                for (TopicOfInterest t : u.getTopicsOfInterest()) {
                    if (t.equals(topicOfInterest)) {
                        u.getTopicsOfInterest().remove(topicOfInterest);
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        List<String> userList = new ArrayList<>();

        for (User u : this.userList) {
            userList.add(u.getUserName());
        }
        return userList;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> topicsOfInterests;

        topicsOfInterests = List.of(TopicOfInterest.values());

        return topicsOfInterests;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String userName) {

        if (userName == null) {
            throw new IllegalArgumentException();
        }

        for (User u : userList) {
            if (u.getUserName().equals(userName)) {
                return u.getTopicsOfInterest();
            }
        }
        throw new IllegalArgumentException();
    }
}
