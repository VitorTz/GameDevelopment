package ougi.math;

public class Transform {


    public final Vector2f position = new Vector2f();
    public final Vector2f scale = new Vector2f(1f, 1f);
    public double rotation = 0;

    public Transform() {

    }

    public Transform(Vector2f position) {
        this.position.set(position);
    }

    public Transform(float posX, float posY) {
        this(new Vector2f(posX, posY));
    }

    public Transform(Vector2f position, Vector2f scale) {
        this.position.set(position);
        this.scale.set(scale);
    }

    public Transform(Vector2f position, Vector2f scale, double rotation) {
        this.position.set(position);
        this.scale.set(scale);
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "Transform{" +
                "position=" + position +
                ", scale=" + scale +
                ", rotation=" + rotation +
                '}';
    }
}
