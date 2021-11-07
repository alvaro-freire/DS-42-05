package e3;

public enum TopicOfInterest {

    Viajes("Viajes"),
    Deportes("Deportes"),
    Libros("Libros"),
    Ropa("Ropa"),
    Comida("Comida");

    private final String topic;

    TopicOfInterest(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

}
