package net.Mega2223.AguaEngine.objects;

import net.Mega2223.AguaEngine.graphics.Renderer;
import net.Mega2223.AguaEngine.graphics.objects.GraphicObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Prop {

    public static final int COLLISION_POLYGON = 0;
    public static final int COLLISION_CIRCLE = 1;


    public List<GraphicObject> graphicObjects = new ArrayList<GraphicObject>();
    public int collisionAlgorithm = 0;
    public float[][] collisionBoundaries;
    public float[] coordinates = {0,0};

    public Prop(float[][] collisionBoundaries){this.collisionBoundaries = collisionBoundaries;}

    public BufferedImage getRenderedInstance(Renderer renderer){
        renderer.board.entities.addAll(graphicObjects);
        return renderer.render();
    }
}
