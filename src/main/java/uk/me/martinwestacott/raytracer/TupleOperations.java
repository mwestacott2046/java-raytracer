package uk.me.martinwestacott.raytracer;

public final class TupleOperations {
    private TupleOperations() {}

    public static Tuple add(Tuple a, Tuple b) {
        return new Tuple(a.x() + b.x(), a.y() + b.y(), a.z()+ b.z(), a.w()+ b.w());
    }

    public static Tuple subtract(Tuple a, Tuple b) {
        return new Tuple(a.x() - b.x(), a.y() - b.y(), a.z() - b.z(), a.w() - b.w());
    }

    public static Tuple negate(Tuple a) {
        return subtract(Tuple.ZERO, a);
    }

    public static Tuple multiply(Tuple t, double scalar) {
        return new Tuple(t.x() * scalar, t.y() * scalar, t.z() * scalar, t.w() * scalar);
    }

    public static Tuple divide(Tuple t, double divisor) {
        return new Tuple(t.x() / divisor, t.y() / divisor, t.z() / divisor, t.w() / divisor);
    }

    public static double magnitude(Tuple t) {
        return Math.sqrt(square(t.x()) + square(t.y()) + square(t.z()) + square(t.w()));
    }

    public static Tuple normalize(Tuple t) {
        final double magnitude = magnitude(t);
        return new Tuple(t.x() /magnitude, t.y()/magnitude, t.z()/magnitude, t.w()/magnitude);
    }

    public static double dot(Tuple a, Tuple b) {
        return multiply(a.x(), b.x()) + multiply(a.y(), b.y()) + multiply(a.z(), b.z()) + multiply(a.w(), b.w());
    }

    private static double multiply(double a, double b){
        return a * b;
    }

    private static double square(double x) {
        return x * x;
    }

    public static Tuple cross(Tuple a, Tuple b) {
        return Tuple.vector(
                multiply(a.y(), b.z()) - multiply(a.z(), b.y()),
                multiply(a.z(), b.x()) - multiply(a.x(), b.z()),
                multiply(a.x(), b.y()) - multiply(a.y(), b.x())
        );
    }
}
