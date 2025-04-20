package uk.me.martinwestacott.raytracer;

public final class DoubleCompare {
    public static final double EPSILON = 0.00001;

    private DoubleCompare(){}

    public static boolean equal(double a, double b){
        return Math.abs(a - b) < EPSILON;
    }
}
