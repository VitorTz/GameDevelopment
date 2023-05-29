package ougi.math;

public class Vector<T> {

    public T x, y;

    public Vector(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public Vector<T> copy() {
        return new Vector<>(this.x, this.y);
    }

    public void set(Vector<T> vec) {
        this.x = vec.x;
        this.y = vec.y;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
