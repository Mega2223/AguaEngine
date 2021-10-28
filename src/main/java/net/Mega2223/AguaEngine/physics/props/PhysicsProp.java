package net.Mega2223.AguaEngine.physics.props;

import net.Mega2223.AguaEngine.objects.Prop;

public class PhysicsProp extends Prop {
    public float mass = 0f;
    public float gravity =0f;
    public float velocity = 0f;
    public float angularVelocity = 0f; //talvez eu precise de um anchor point considerando que a "coordenada" do prop é no inferior esquerdo
    public float /*fixme?*/ direction = 0f;
    public boolean isAffectedByGravity = true;
    public PhysicsProp(float[][] collisionBoundaries) {
        super(collisionBoundaries);
    }

    /**Aplica uma força ao objeto
     * @param direction direção a qual a força é aplicada
     * @param velocity força da força, sim eu sei*/
    public void applyForce(float velocity, float direction){//isso nunca vai dar certo

        float difference = this.direction - direction;
        if (difference < 0){difference = -difference;}
        this.direction = (difference/2)*(this.velocity/velocity);


        double radians = (Math.PI / 180) * (direction);

        float xForce = (float) (velocity * Math.cos(radians));
        float yForce = (float) (velocity * Math.sin(radians));

        double thisRadians = (Math.PI / 180) * (this.direction);
        double thisX = (this.velocity * Math.cos(thisRadians));
        double thisY = (this.velocity * Math.sin(thisRadians));

        this.velocity = (float) ((thisX + xForce) + (thisY + yForce));



    }


    /**Retorna uma double[] que contém os valores (aproximados) X e Y de velocidade do prop respectivamente.*/
    public float[] calculateIndividualSpeeds(){
        return calculateIndividualSpeeds(this);
    }
    /**Retorna uma double[] que contém os valores (aproximados) X e Y de velocidade do prop respectivamente.*///vsf corretor respectivamente é uma palavra
    public static float[] calculateIndividualSpeeds(PhysicsProp prop){
        float thisRadians = ((float)(Math.PI / 180)) * (prop.direction);
        float thisX = (prop.velocity * (float)Math.cos(thisRadians));
        float thisY = (prop.velocity * (float)Math.sin(thisRadians));



        return new float[]{thisX,thisY};
    }
}
