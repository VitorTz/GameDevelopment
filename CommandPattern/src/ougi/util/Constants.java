package ougi.util;

import ougi.math.Dimension;

public class Constants {

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static final String SCREEN_TITLE = "Command Pattern";
    public static final int FPS = 120;
    public static final long FRAME_IN_MILLIS = 1000 / FPS;


    public static final int COMMAND_HISTORY_MAX_SIZE = 2000;

    public static final Dimension PLAYER_TILE_DIMENSION = new Dimension(37, 40);
    public static final int PLAYER_SPRITE_SHEET_SPACING = 2;

    public static final String SPRITE_SHEET_FOLDER = "assets/SpriteSheets/";
    public static final float ANIMATION_UPDATE_RATE = 7f;
}
