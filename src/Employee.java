public class Employee {
    private static int nextId = 0;

    private int id;
    private String name;
    private String[] skills;
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }
}
