package net.Mega2223.AguaEngine;

import net.Mega2223.AguaEngine.graphics.Renderer;
import net.Mega2223.AguaEngine.graphics.objects.GraphicObject;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Oval;
import net.Mega2223.AguaEngine.physics.PhysicsAmbient;
import net.Mega2223.AguaEngine.physics.props.PhysicsProp;

import javax.swing.*;
import java.awt.*;

public class runEffectorsTest1 {

    private static float[][] legal = {{0,0},{1,1}};

    public static void main(String[] args) throws InterruptedException {
        PhysicsAmbient physicsAmbient = new PhysicsAmbient();

        PhysicsProp physicsProp = new PhysicsProp(legal);
        GraphicObject graphicObject = new GraphicObject();
        graphicObject.shape = new Oval(20,20);
        graphicObject.shape.color = Color.red;
        physicsProp.entities.add(graphicObject);

        Renderer renderer = new Renderer();
        System.out.println(renderer.board.dim);
        renderer.board.dim = new Dimension(200,200);

        physicsProp.velocity = 2.0f;
        physicsProp.coordinates = new float[]{60,20};

        physicsAmbient.addProp(physicsProp);

        renderer.board.entities.addAll(physicsProp.entities);

        rendererTest1.TestWindow testWindow = new rendererTest1.TestWindow();


        while (true){

            physicsAmbient.runEffectors();
            System.out.println(physicsProp.coordinates[0] + ":" + physicsProp.coordinates[1]);
            testWindow.icon.setIcon(new ImageIcon(renderer.render()));

            physicsProp.direction = physicsProp.direction + 2.2f;

            System.out.println("C:"+physicsProp.entities.get(0).coords[0]);
            System.out.println("P:"+physicsProp.entities.get(0).coords[0]);
            physicsProp.entities.get(0).setCoords(physicsProp.coordinates);
            Thread.sleep(20);
        }


    }
}
