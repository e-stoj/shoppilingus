public class Service {
    private static int nextId = 0;

    private int id;
    private String name;
    private double price;
    private int durationInMinutes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
