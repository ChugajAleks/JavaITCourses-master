package Polimorphism.shape;

/**
 * Created by Алекс on 26.09.15.
 */
public class Triangl extends Shape{
    @Override
    public void draw(){
        System.out.println("Triangl.draw");
    }

    @Override
    public void frizz() {
        System.out.println("Triangl.frizz");
    }

    @Override
    public void erase(){
        System.out.println("Triangl.erase");
    }
}
