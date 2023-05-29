package ougi.scene;

import ougi.entity.Entity;

import java.awt.Graphics2D;
import java.util.HashMap;


public class Scene {

    protected HashMap<Integer, Entity> entities = new HashMap<Integer, Entity>();
    protected String name;

    protected Scene(String name) {
        this.name = name;
        this.init();
    }

    public void init() {
        return;
    }

    protected void addEntity(Entity entity) {
        this.entities.put(entity.getEntityId(), entity);
    }

    protected void removeEntity(Entity entity) {
        this.entities.remove(entity.getEntityId());
    }

    public void update(double deltaTime) {

    }

    public void draw(Graphics2D g2) {

    }

}
