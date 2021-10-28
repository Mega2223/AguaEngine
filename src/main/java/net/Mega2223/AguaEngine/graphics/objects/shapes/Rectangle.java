package net.Mega2223.AguaEngine.graphics.objects.shapes;


public class Rectangle extends Shape {
    public double sizeX = 1;
    public double sizeY = 1;

    public Rectangle(double sizeX, double sizeY){
        type = Shape.SHAPE_RECTANGLE;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    public Rectangle(double[] size){
        type = Shape.SHAPE_RECTANGLE;
        this.sizeX = size[0];
        this.sizeY = size[1];
    }
}
