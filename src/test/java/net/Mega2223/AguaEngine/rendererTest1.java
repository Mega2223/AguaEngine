package net.Mega2223.AguaEngine;

import net.Mega2223.AguaEngine.graphics.Renderer;
import net.Mega2223.AguaEngine.graphics.objects.Board;
import net.Mega2223.AguaEngine.graphics.objects.GraphicObject;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Oval;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Polygon;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class rendererTest1 {

    public static void main(String[] args) {



        Board board = new Board();
        Renderer renderer = new Renderer(board);


        Oval s1 = new Oval(19,19);
        Rectangle s2 = new Rectangle(20,39);
        Polygon s3 = new Polygon(new float[][]{});

        GraphicObject e1 = new GraphicObject();
        GraphicObject e2 = new GraphicObject();
        GraphicObject e3 = new GraphicObject();

        e1.shape = new Polygon(new float[][]{{10,10},{10,-10},{-10,-10}});
        e2.shape = new Oval(30,20);
        e3.shape = new Rectangle(20,30);

        e1.coords = new float[]{10,20};
        e2.coords = new float[]{20,20};
        e3.coords = new float[]{40,40};

        e1.shape.color = Color.black;
        e2.shape.color = Color.CYAN;
        e3.shape.color = Color.YELLOW;

        board.entities.add(e1);
        board.entities.add(e2);
        board.entities.add(e3);


        BufferedImage img = renderer.render();

        TestWindow window = new TestWindow();
        window.icon = new JLabel(new ImageIcon(img));
        window.add(window.icon);
    }

    public static class TestWindow extends JFrame{
        public JLabel icon;
        public TestWindow(){
            setSize(200,200);
            setVisible(true);
            setLocation(150,150);
            setLayout(new FlowLayout());
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            icon = new JLabel();
            add(icon);
        }
    }

}
