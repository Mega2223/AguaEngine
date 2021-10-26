package net.Mega2223.AguaEngine.graphics.objects.shapes;

import net.Mega2223.AguaEngine.graphics.objects.Shape;

public class Polygon extends Shape {
    public float[][] points = {};
    public Polygon (float[][] points){
        this.points = points;
        type = Shape.SHAPE_POLYGON;
    }
}
