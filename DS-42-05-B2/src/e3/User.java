package e3;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String userName;

    private final List<TopicOfInterest> topicsOfInterest = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


}
