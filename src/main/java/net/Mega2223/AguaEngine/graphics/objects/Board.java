package net.Mega2223.AguaEngine.graphics.objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    public List<Entity> entities = new ArrayList<Entity>();
    //public List<Shape> shapes = new ArrayList<Shape>();
    public Dimension dim = new Dimension(100,100);

    public Board(){}
    public Board(List<Entity> entities){this.entities = entities;}

}
