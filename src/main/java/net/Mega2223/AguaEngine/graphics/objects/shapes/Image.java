package net.Mega2223.AguaEngine.graphics.objects.shapes;

import java.awt.image.BufferedImage;

public class Image extends Shape  {
    public float[] size = {1,1};
    public BufferedImage image;
    public Image(BufferedImage image){
        this.image = image;
    }
}
