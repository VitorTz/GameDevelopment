package ougi.component;

import ougi.math.Transform;
import ougi.math.Vector2f;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Sprite extends Component<Sprite> {

    private static final HashMap<String, Sprite> sprites = new HashMap<>();

    private BufferedImage image;
    private final String nameId;

    public static Sprite newSprite(File imageFile) {
        String spriteId = imageFile.getAbsolutePath();
        if (!Sprite.sprites.containsKey(spriteId)) {
            Sprite.sprites.put(spriteId, new Sprite(spriteId, imageFile));
        }
        return Sprite.sprites.get(spriteId);
    }

    public static Sprite newSprite(String imagePath) {
        return Sprite.newSprite(new File(imagePath));
    }

    public static Sprite newSprite(String nameId, BufferedImage image) {
        if (!Sprite.sprites.containsKey(nameId)) {
            Sprite.sprites.put(nameId, new Sprite(nameId, image));
        }
        return Sprite.sprites.get(nameId);
    }

    public static Sprite getSprite(String nameId) {
        return Sprite.sprites.get(nameId);
    }

    public static void removeSprite(String nameId) {
        Sprite.sprites.remove(nameId);
    }

    private Sprite(String nameId, BufferedImage image) {
        super("Sprite");
        this.nameId = nameId;
        this.image = image;
    }

    private Sprite(String nameId, File imageFile) {
        super("Sprite");
        this.nameId = nameId;
        try {
            this.image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void draw(Graphics2D g2) {
        Transform transform = this.entity.transform;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToIdentity();
        affineTransform.translate(transform.position.x, transform.position.y);
        affineTransform.rotate(
            Math.toRadians(transform.rotation),
            this.image.getWidth() * transform.scale.x / 2,
            this.image.getHeight() * transform.scale.y / 2
        );
        affineTransform.scale(transform.scale.x, transform.scale.y);
        g2.drawImage(this.image, affineTransform, null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getNameId() {
        return nameId;
    }

    @Override
    public String toString() {
        return "Sprite{image=" + image +
                ", nameId='" + nameId + '\'' +
                '}';
    }
}
