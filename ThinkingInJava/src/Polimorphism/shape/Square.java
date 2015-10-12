package Polimorphism.shape;

/**
 * Created by Алекс on 26.09.15.
 */
public class Square extends Shape{
    @Override
    public void draw(){
        System.out.println("Square.draw");
    }
    @Override
    public void erase(){
        System.out.println("Square.erase");
    }

    @Override
    public void frizz() {
        System.out.println("Square.frizz");
    }
}
