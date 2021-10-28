package net.Mega2223.AguaEngine.graphics.objects;

import net.Mega2223.AguaEngine.graphics.objects.shapes.Oval;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Shape;

public class GraphicObject {

    public float[] coords = {0,0};
    public float[] relativeCoords = {0,0};
    public Shape shape = new Oval(1,1);

    public void setCoords(float[] coords){
        this.coords = new float[]{coords[0],coords[1]};
    }

}
