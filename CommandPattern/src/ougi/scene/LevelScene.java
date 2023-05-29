package ougi.scene;

import ougi.commands.CommandHistory;
import ougi.component.AnimationSprite;
import ougi.entity.Entity;
import ougi.math.Transform;
import ougi.window.KL;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LevelScene extends Scene {


    public LevelScene() {
        super("LevelScene");
    }

    @Override
    public void init() {
        Entity player = Entity.newEntity("Player", new Transform(100f, 100f));
        player.addComponent(new AnimationSprite("player_left"));
        this.addEntity(player);
        System.out.println(player.getComponent(AnimationSprite.class).toString());
    }

    @Override
    public void update(double deltaTime) {
        CommandHistory.setUndoActive(KL.isKeyPressed(KeyEvent.VK_SPACE));
        for (Entity e : this.entities.values()) {
            e.update(deltaTime);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        for (Entity e: this.entities.values()) {
            e.draw(g2);
        }
    }

}
