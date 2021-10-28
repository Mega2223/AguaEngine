package net.Mega2223.AguaEngine.physics.props;

public class Circle extends PhysicsProp {
    public double radius ;

    public Circle(double[][] collisionBoundaries, double radius) {
        super(collisionBoundaries);
        this.radius = radius;
    }
}
