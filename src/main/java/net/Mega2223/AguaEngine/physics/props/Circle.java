package net.Mega2223.AguaEngine.physics.props;

public class Circle extends PhysicsProp {
    public float radius = 0.0f;

    public Circle(float[][] collisionBoundaries, float radius) {
        super(collisionBoundaries);
        this.radius = radius;
    }
}
