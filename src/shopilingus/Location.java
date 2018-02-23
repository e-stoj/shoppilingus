package shopilingus;

public class Location {
    private int floor;
    private int box;

    public int getFloor() {
        return floor;
    }

    public int getBox() {
        return box;
    }

    public Location(int floor, int box){
        this.floor = floor;
        this.box = box;
    }
}
