package Lab7;

public class SwimmingPoolProgram {
    public static void main(String[] args) {
        // makes a pool object using the Pool class
        Pool ymca = new Pool("YMCA", 50);
        // double field
        double totalSwam = ymca.distanceForLaps(6);
        // prints the total distance swam
        System.out.println("The total distance is " + totalSwam + " meters.");

        // new pool object
        Pool como = new Pool("Como Park", 25);

        // new pool object
        Pool edinaPool = new Pool("Edina", 50);

        // prints the total distance swam in the Como Park pool
        System.out.println(como.distanceForLaps(10));
        // prints the length of the Como Park pool
        System.out.println(como);

        // prints the total distance swam in the Edina pool
        System.out.println(edinaPool.distanceForLaps(12));
        // prints the length of the Edina pool
        System.out.println(edinaPool);
    }
}
