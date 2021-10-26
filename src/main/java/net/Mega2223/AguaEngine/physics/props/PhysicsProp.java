package net.Mega2223.AguaEngine.physics.props;

import net.Mega2223.AguaEngine.objects.Prop;

public class PhysicsProp extends Prop {
    public float mass = 0f;
    public float gravity =0f;
    public float velocity = 0f;
    public float /*fixme*/ direction = 0f;
    public PhysicsProp(float[][] collisionBoundaries) {
        super(collisionBoundaries);
    }
}
