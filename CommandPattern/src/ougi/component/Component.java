package ougi.component;

import ougi.entity.Entity;

import java.awt.Graphics2D;

public class Component<T> {

    protected String name;
    protected Entity entity;

    public Component(String name) {
        this.name = name;
    }

    public void update(double deltaTime) {
        return;
    }

    public void draw(Graphics2D g2) {
        return;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", entity=" + entity +
                '}';
    }
}
