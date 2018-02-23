public class Service {
    private static int nextId = 0;

    private int id;
    private String name;
    private double price;
    private int durationInMinutes;

    Service(String name, double price, int durationInMinutes){
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
