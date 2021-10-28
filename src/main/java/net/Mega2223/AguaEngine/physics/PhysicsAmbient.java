package net.Mega2223.AguaEngine.physics;

import net.Mega2223.AguaEngine.graphics.objects.GraphicObject;
import net.Mega2223.AguaEngine.physics.props.PhysicsProp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PhysicsAmbient {

    public static final int GRAVITY_QUADRATIC_ALGORITHM = 0;
    public static final int GRAVITY_LINEAR_ALGORITHM = 1;

    public static final int BORDER_COLLIDES = 0;
    public static final int BORDER_LOOPS = 1;
    public static final int BORDER_NO_COLLISION = 2;

    public boolean hasGravity = false;
    public int gravityAlgorithm = GRAVITY_QUADRATIC_ALGORITHM;
    public int borderCollision = BORDER_COLLIDES;
    public double gravity = 9.8f;
    public double gravityDirection = 0; //float?
    public double airRes = 0;
    public double bounciness = 1; //nome horrível
    public Dimension dimension = new Dimension(300,300);

    public List<PhysicsProp> props = new ArrayList<PhysicsProp>();

    public PhysicsAmbient(){}

    public void correctCorners(PhysicsProp act){
        while (act.coordinates[0] > dimension.width && borderCollision == BORDER_LOOPS){
            System.out.println(act.coordinates[0]);
            act.coordinates[0] = act.coordinates[0] - dimension.width;
        }
        while (act.coordinates[1] > dimension.height && borderCollision == BORDER_LOOPS){
            act.coordinates[1] = act.coordinates[1] - dimension.height;
        }
        while (act.coordinates[0] < 0 && borderCollision == BORDER_LOOPS){
            act.coordinates[0] = act.coordinates[0] + dimension.width;
        }
        while (act.coordinates[1] < 0 && borderCollision == BORDER_LOOPS){
            act.coordinates[1] = act.coordinates[1] + dimension.height;
        }

    }

    public void runEffectors(){

        for(PhysicsProp act : props){

            correctCorners(act);

            act.velocity = (float) (act.velocity - (act.velocity/airRes));

            double CX = act.coordinates[0];
            double CY = act.coordinates[1];

            double radians = (Math.PI / 180) * (act.direction);

            double xSpeed = (double) (act.velocity * Math.cos(radians));
            double ySpeed = (double) (act.velocity * Math.sin(radians));

            //todo gravidade e os outros

            if(hasGravity && act.isAffectedByGravity){
                double gravityRadians = (Math.PI / 180) * (gravityDirection);
                double xGravity = (gravity * Math.cos(gravityRadians));
                double yGravity = (gravity * Math.sin(gravityRadians));
                switch (gravityAlgorithm){
                    case GRAVITY_QUADRATIC_ALGORITHM: //todo borda na águalib



                        break;
                }
            }

            CX = (CX + xSpeed);
            CY = (CY + ySpeed);

            //if (CX == 0/0){CX = 0;}
            //if (CY == 0/0){CY = 0;}


            act.coordinates = new double[]{CX,CY};
        }
    }

    /**atualiza a coordenada dos GraphicObjects para que elas continuem relativas ao prop*/
    public void updateEffectors(){
        for(PhysicsProp act : props){
            double propCoords[] = act.coordinates;
            for (GraphicObject grACT : act.graphicObjects){
                double[] relativeCoords = grACT.relativeCoords;
                grACT.coords = new double[]{propCoords[0] + relativeCoords[0], propCoords[1] + relativeCoords[1]};
            }
        }
    }

    public void runCollisions(){
        for(PhysicsProp act : props){

        }
    }
    //todo será que da pra fazer isso em mais coisa?
    public void addProp(PhysicsProp prop){
        props.add(prop);
    }
}
