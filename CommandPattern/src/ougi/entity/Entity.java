package ougi.entity;

import ougi.component.Component;
import ougi.math.Transform;

import java.awt.*;
import java.util.HashMap;

public class Entity {

    private static int newEntityId = 0;

    private final String name;
    private final HashMap<Class<?>, Component<?>> components = new HashMap<>();
    private final int entityId;
    public final Transform transform;

    public static Entity newEntity(String name, Transform transform) {
        Entity e = new Entity(name, transform, Entity.newEntityId);
        Entity.newEntityId++;
        return e;
    }

    public static Entity newEntity(String name) {
        return Entity.newEntity(name, new Transform());
    }

    private Entity(String name, Transform transform, int entityId) {
        this.name = name;
        this.transform = transform;
        this.entityId = entityId;
    }

    public void addComponent(Component<?> component) {
        this.components.put(component.getClass(), component);
        component.setEntity(this);
    }

    public <T extends Component<?>> T getComponent(Class<T> componentClass) {
        return componentClass.cast(this.components.get(componentClass));
    }

    public void update(double deltaTime) {
        for (Component<?> c : this.components.values()) {
            c.update(deltaTime);
        }
    }

    public void draw(Graphics2D g2) {
        for (Component<?> c : this.components.values()) {
            c.draw(g2);
        }
    }

    public int getEntityId() {
        return entityId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "newEntityId=" + newEntityId +
                ", name='" + name + '\'' +
                ", components=" + components +
                ", entityId=" + entityId +
                ", transform=" + transform +
                '}';
    }
}
