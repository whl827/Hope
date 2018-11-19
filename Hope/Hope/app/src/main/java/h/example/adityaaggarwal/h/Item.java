package h.example.adityaaggarwal.h;

/**
 * Created by jungholim on 11/11/16.
 */

public class Item {
    private String name;
    private String status;
    private double distance;
    private String image;

    public Item(String name, String status, double distance) {
        this.name = name;
        this.status = status;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }
    public String getStatuts() {
        return status;
    }

    public double getDistance() {
        return distance;
    }
}
