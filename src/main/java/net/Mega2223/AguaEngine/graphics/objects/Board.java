package net.Mega2223.AguaEngine.graphics.objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    public List<GraphicObject> entities = new ArrayList<GraphicObject>();
    //public List<Shape> shapes = new ArrayList<Shape>();
    public Dimension dim = new Dimension(100,100);

    public Board(){}
    public Board(List<GraphicObject> entities){this.entities = entities;}

}
