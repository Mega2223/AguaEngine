package net.Mega2223.AguaEngine.graphics.objects.shapes;

import java.awt.*;

/**Uma shape define a forma de um objeto e suas dimensões*/
public abstract class Shape {

    public static final int SHAPE_OVAL = 0;
    public static final int SHAPE_RECTANGLE = 1;
    public static final int SHAPE_LINE = 2;
    public static final int SHAPE_IMAGE = 3; //todo implementação de imagem
    public static final int SHAPE_POLYGON = -1;

    public int type = 0;
    public Color color = Color.WHITE;

}
