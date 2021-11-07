package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private final String username;

    private final List<TopicOfInterest> topicsOfInterest = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public List<TopicOfInterest> getTopicsOfInterest() {
        return topicsOfInterest;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return (Objects.equals(username, user.getUsername()) &&
                topicsOfInterest == user.getTopicsOfInterest());
    }

}
