package Polimorphism.shape;

/**
 * Created by Алекс on 27.09.15.
 */
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        for (int i = 0; i < 9; i++) {
            shapes[i] = gen.next();
        }
        for (Shape shp : shapes){
            shp.draw();
            shp.frizz();
        }
    }
}
