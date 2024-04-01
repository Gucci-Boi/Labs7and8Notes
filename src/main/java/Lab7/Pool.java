package Lab7;

public class Pool {
    private String name; // field/variable
    private double length; // another field
    // constructor to set up the pool object
    Pool(String name, double length) {
        this.name = name;
        this.length = length;
    }
    // makes an instance method
    public double distanceForLaps(int laps) {
        // multiplies the length of the pool with the parameter
        double total = laps * this.length;
        // returns the total
        return total;
    }
//
    @Override // makes sure the toString() is correct and overrides the default method
    public String toString() {
        //
        String description = this.name + " pool is " + length + " meters long.";
        //
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) {
            return;
        }
        this.length = length;
    }
}
