package net.Mega2223.AguaEngine.graphics.objects.shapes;

public class Polygon extends Shape {
    public float[][] points = {};
    public Polygon (float[][] points){
        this.points = points;
        type = Shape.SHAPE_POLYGON;
    }
}
