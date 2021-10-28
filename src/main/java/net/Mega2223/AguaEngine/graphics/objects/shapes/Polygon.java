package net.Mega2223.AguaEngine.graphics.objects.shapes;

public class Polygon extends Shape {
    public double[][] points = {};
    public Polygon (double[][] points){
        this.points = points;
        type = Shape.SHAPE_POLYGON;
    }
}
