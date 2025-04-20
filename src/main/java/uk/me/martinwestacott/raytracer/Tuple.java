package uk.me.martinwestacott.raytracer;

public record Tuple(double x, double y, double z, double w) {

    public static final Tuple ZERO = new Tuple(0,0,0,0);

    public static Tuple point(double x, double y, double z) {
        return new Tuple(x,y,z,1);
    }

    public static Tuple vector(double x, double y, double z) {
        return new Tuple(x,y,z,0);
    }

    public boolean isVector(){
        return DoubleCompare.equal(0,w);
    }
    public boolean isPoint(){
        return DoubleCompare.equal(1,w);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tuple(double x1, double y1, double z1, double w1))) return false;

        return DoubleCompare.equal(x, x1) && DoubleCompare.equal(y, y1) &&
                DoubleCompare.equal(z, z1) && DoubleCompare.equal(w, w1);
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        result = 31 * result + Double.hashCode(z);
        result = 31 * result + Double.hashCode(w);
        return result;
    }
}
