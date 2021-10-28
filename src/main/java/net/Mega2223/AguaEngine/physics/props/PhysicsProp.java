package net.Mega2223.AguaEngine.physics.props;

import net.Mega2223.AguaEngine.objects.Prop;

public class PhysicsProp extends Prop {
    public double mass = 0f;
    public double gravity =0f;
    public double velocity = 0f;
    public double angularVelocity = 0f; //talvez eu precise de um anchor point considerando que a "coordenada" do prop é no inferior esquerdo
    public double /*fixme?*/ direction = 0f;
    public boolean isAffectedByGravity = true;
    public PhysicsProp(double[][] collisionBoundaries) {
        super(collisionBoundaries);
    }

    /**Aplica uma força ao objeto
     * @param direction direção a qual a força é aplicada
     * @param velocity força da força, sim eu sei*/
    public void applyForce(double velocity, double direction){//isso nunca vai dar certo

        double difference = this.direction - direction;
        if (difference < 0){difference = -difference;}
        this.direction = (difference/2)*(this.velocity/velocity);


        double radians = (Math.PI / 180) * (direction);

        double xForce = (double) (velocity * Math.cos(radians));
        double yForce = (double) (velocity * Math.sin(radians));

        double thisRadians = (Math.PI / 180) * (this.direction);
        double thisX = (this.velocity * Math.cos(thisRadians));
        double thisY = (this.velocity * Math.sin(thisRadians));

        this.velocity = (double) ((thisX + xForce) + (thisY + yForce));



    }


    /**Retorna uma double[] que contém os valores (aproximados) X e Y de velocidade do prop respectivamente.*/
    public double[] calculateIndividualSpeeds(){
        return calculateIndividualSpeeds(this);
    }
    /**Retorna uma double[] que contém os valores (aproximados) X e Y de velocidade do prop respectivamente.*///vsf corretor respectivamente é uma palavra
    public static double[] calculateIndividualSpeeds(PhysicsProp prop){
        double thisRadians = ((double)(Math.PI / 180)) * (prop.direction);
        double thisX = (prop.velocity * (double)Math.cos(thisRadians));
        double thisY = (prop.velocity * (double)Math.sin(thisRadians));

        return new double[]{thisX,thisY};
    }
}
