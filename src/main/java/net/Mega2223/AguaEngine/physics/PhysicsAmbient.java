package net.Mega2223.AguaEngine.physics;

import net.Mega2223.AguaEngine.objects.Prop;
import net.Mega2223.AguaEngine.physics.props.PhysicsProp;

import java.util.ArrayList;
import java.util.List;

public class PhysicsAmbient {

    public boolean hasGravity = false;
    public float gravity = 9.8f; //float?
    public float airRes = 1f;

    public List<PhysicsProp> props = new ArrayList<PhysicsProp>();

    public PhysicsAmbient(){}

    public void run(){
        for(PhysicsProp act : props){

        }
    }
}
