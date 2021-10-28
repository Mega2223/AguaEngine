package net.Mega2223.AguaEngine.graphics.objects;

import net.Mega2223.AguaEngine.graphics.objects.shapes.Oval;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Shape;

public class GraphicObject {

    public double[] coords = {0,0};
    public double[] relativeCoords = {0,0};
    public Shape shape = new Oval(1,1);

    public void setCoords(double[] coords){
        this.coords = new double[]{coords[0],coords[1]};
    }

}
