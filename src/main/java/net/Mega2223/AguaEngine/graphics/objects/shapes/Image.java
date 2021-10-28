package net.Mega2223.AguaEngine.graphics.objects.shapes;

import java.awt.image.BufferedImage;
//todo
public class Image extends Shape  {
    public double[] size = {1,1};
    public BufferedImage image;
    public Image(BufferedImage image){
        this.image = image;
    }
}
