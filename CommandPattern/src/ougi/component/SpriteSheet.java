package ougi.component;

import ougi.math.Dimension;
import ougi.math.Vector;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class SpriteSheet {

    private final ArrayList<Sprite> sprites = new ArrayList<>();

    public SpriteSheet(File spriteImagePath, Dimension tileDimension, int spacing, int rows, int columns) {
        Sprite parentSprite = Sprite.newSprite(spriteImagePath);
        String spriteSheetName = parentSprite.getNameId();
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int left = (j * spacing) + (tileDimension.x * j);
                int top = (i * spacing) + (tileDimension.y * i);
                System.out.println(left);
                System.out.println(top);
                BufferedImage subImage = parentSprite.getImage().getSubimage(
                    left, top, tileDimension.x, tileDimension.y
                );
                sprites.add(Sprite.newSprite(spriteSheetName + " -> " + count, subImage));
                count++;
            }
        }
        Sprite.removeSprite(parentSprite.getNameId());
    }

    public int getSize() {
        return this.sprites.size();
    }

    public Sprite get(int index) {
        return this.sprites.get(index);
    }

    @Override
    public String toString() {
        return "SpriteSheet{" +
                "sprites=" + sprites +
                '}';
    }
}
