package net.Mega2223.AguaEngine.physics;

import net.Mega2223.AguaEngine.objects.Prop;
import net.Mega2223.AguaEngine.physics.props.PhysicsProp;

import java.util.ArrayList;
import java.util.List;

public class PhysicsAmbient {

    public boolean hasGravity = false;
    public float gravity = 9.8f;
    public float gravityDirection = 0f; //float?
    public float airRes = 1f;

    public List<PhysicsProp> props = new ArrayList<PhysicsProp>();

    public PhysicsAmbient(){}

    public void runEffectors(){

        for(PhysicsProp act : props){
            float CX = act.coordinates[0];
            float CY = act.coordinates[1];

            double radians = (Math.PI / 180) * (act.direction);
            CX = (float) (CX + act.velocity * Math.cos(radians));
            CY = (float) (CY + act.velocity * Math.sin(radians));

            //todo gravidade e os outros

            act.coordinates = new float[]{CX,CY};
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
