package Polimorphism.shape;

/**
 * Created by Алекс on 26.09.15.
 */
public class Circle extends Shape{
    @Override
    public void draw(){
        System.out.println("Circle.draw");
    }
    @Override
    public void erase(){
        System.out.println("Circle.erase");
    }
    @Override
    public void frizz(){
        System.out.println("Circle.frizz");
    }
}
