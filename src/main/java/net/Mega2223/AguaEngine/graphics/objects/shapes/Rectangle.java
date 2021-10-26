package net.Mega2223.AguaEngine.graphics.objects.shapes;


public class Rectangle extends Shape {
    public float sizeX = 1;
    public float sizeY = 1;

    public Rectangle(float sizeX, float sizeY){
        type = Shape.SHAPE_RECTANGLE;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    public Rectangle(float[] size){
        type = Shape.SHAPE_RECTANGLE;
        this.sizeX = size[0];
        this.sizeY = size[1];
    }
}
