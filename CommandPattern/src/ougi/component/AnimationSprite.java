package ougi.component;

import ougi.entity.Entity;
import ougi.util.Constants;

import java.awt.*;
import java.io.File;

public class AnimationSprite extends Component<AnimationSprite> {

    private float currentSpriteIndex = 0;
    private SpriteSheet spriteSheet;

    public AnimationSprite(String animationName) {
        super("AnimationSprite");
        String spritePath = Constants.SPRITE_SHEET_FOLDER + animationName + ".png";
        File f = new File(spritePath);
        if (!f.exists()) {
            System.out.println("File " + f.getAbsolutePath() + " not founded!");
            System.exit(-1);
        }
        this.spriteSheet = new SpriteSheet(f, Constants.PLAYER_TILE_DIMENSION, 2, 1, 4);
    }

    @Override
    public void setEntity(Entity entity) {
        super.setEntity(entity);
        for (int i = 0; i < this.spriteSheet.getSize(); i++)
            this.spriteSheet.get(i).setEntity(entity);
    }

    @Override
    public void update(double deltaTime) {
        this.currentSpriteIndex += deltaTime * Constants.ANIMATION_UPDATE_RATE;
        if (this.currentSpriteIndex >= this.spriteSheet.getSize()) {
            this.currentSpriteIndex = 0;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        this.spriteSheet.get( (int) this.currentSpriteIndex).draw(g2);
    }

    @Override
    public String toString() {
        return "AnimationSprite{" +
                "currentSpriteIndex=" + currentSpriteIndex +
                ", spriteSheet=" + spriteSheet +
                '}';
    }
}
