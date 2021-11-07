package e3;

import java.util.List;

public class User {

    private final String userName;

    private final List<TopicOfInterest> topicsOfInterest;

    public User(String userName, List<TopicOfInterest> topicsOfInterests) {
        this.userName = userName;
        this.topicsOfInterest = topicsOfInterests;
    }

    public String getUserName() {
        return userName;
    }

    public List<TopicOfInterest> getTopicsOfInterest() {
        return topicsOfInterest;
    }

}
