package net.Mega2223.AguaEngine;

import net.Mega2223.AguaEngine.graphics.Renderer;
import net.Mega2223.AguaEngine.graphics.objects.GraphicObject;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Line;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Oval;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Rectangle;
import net.Mega2223.AguaEngine.physics.PhysicsAmbient;
import net.Mega2223.AguaEngine.physics.props.PhysicsProp;
import net.Mega2223.utils.ImageTools;
import net.Mega2223.utils.objects.GraphRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class runEffectorsTest1 {

    private static double[][] legal = {{0,0},{1,1}};

    public static void main(String[] args) throws InterruptedException {
        PhysicsAmbient physicsAmbient = new PhysicsAmbient();

        PhysicsProp physicsProp = new PhysicsProp(legal);
        GraphicObject graphicObject = new GraphicObject();
        graphicObject.shape = new Oval(50,50);
        graphicObject.shape.color = Color.red;
        physicsProp.graphicObjects.add(graphicObject);

        GraphicObject graphicObject2 = new GraphicObject();
        graphicObject2.shape = new Rectangle(15,15);
        graphicObject2.shape.color = Color.green;
        physicsProp.graphicObjects.add(graphicObject2);

        Renderer renderer = new Renderer();
        renderer.repeatRender = true;
        //System.out.println(renderer.board.dim);
        renderer.board.dim = new Dimension(300,300);

        physicsProp.mass = 1;
        physicsProp.coordinates = new double[]{100,100};

        Line line = new Line();
        line.points = new double[][]{physicsProp.coordinates};
        GraphicObject graphicObject1 = new GraphicObject();
        graphicObject1.shape = line;
        renderer.board.entities.add(graphicObject1);//todo

        physicsAmbient.addProp(physicsProp);
        physicsAmbient.hasGravity = true;
        physicsAmbient.borderCollision = PhysicsAmbient.BORDER_LOOPS;


        renderer.board.entities.addAll(physicsProp.graphicObjects);

        rendererTest1.TestWindow testWindow = new rendererTest1.TestWindow();

        double turn = 0;
        physicsProp.velocity = 1;

        //gráfico

        rendererTest1.TestWindow graphic = new rendererTest1.TestWindow();


        GraphRenderer renderer1 = new GraphRenderer(
                new ArrayList<List<double[]>>(),
                new Dimension(100,100),
                new Color[]{Color.BLUE});
        renderer1.values.add(new ArrayList<double[]>());

        JLabel energia = new JLabel();
        JLabel angulo = new JLabel();

        graphic.add(energia);
        graphic.add(angulo);
        graphic.setLocation(400,200);


        physicsProp.applyForce(1,90);
        line.color = Color.red;
        physicsProp.applyForce(10,90);
        physicsAmbient.airRes = 0.1;
        while (true){

            //physicsProp.applyForce(1,0);

            turn = turn + 1;
            physicsAmbient.runEffectors();
            physicsAmbient.updateEffectors();

            renderer.board.dim = new Dimension(testWindow.getWidth() -60,testWindow.getHeight() - 60);
            physicsAmbient.dimension = new Dimension(testWindow.getWidth() -60,testWindow.getHeight() -60);

            //System.out.println(physicsProp.coordinates[0] + ":" + physicsProp.coordinates[1]);
            testWindow.icon.setIcon(new ImageIcon(renderer.render().getScaledInstance(testWindow.getWidth() -60,testWindow.getHeight() - 60, BufferedImage.SCALE_AREA_AVERAGING)));

            List<double[]> lines = Arrays.asList(line.points);
            lines = new ArrayList(lines);
            lines.add(physicsProp.coordinates);
            while (lines.size() > 100){lines.remove(0);}
            line.points = lines.toArray(line.points);
            //System.out.println(line.points.length);
            //line.points = (double[][]) lines.toArray();

            renderer1.values.get(0).add(new double[]{turn, (double) physicsProp.velocity*1});
            graphic.icon.setIcon(new ImageIcon(renderer1.renderWithGrid(new ArrayList<List<double[]>>(), 1)));
            energia.setText("Energia no sistema: " + (int)physicsProp.velocity);
            angulo.setText("Ângulo: " + (int)physicsProp.direction);
            Thread.sleep(40);
        }


    }
}
