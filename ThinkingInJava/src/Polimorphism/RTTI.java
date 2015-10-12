package Polimorphism;

/**
 * Created by Алекс on 27.09.15.
 */
class Useful{
    public void f(){}
    public void g(){}
}

class MoreUseful extends Useful{
    public void f(){}
    public void g(){}
    public void u(){}
    public void v(){}
    public void w(){}
}
public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
        ((MoreUseful)x[1]).u();
        try{
            ((MoreUseful)x[0]).u();
        }
        catch (ClassCastException e){
            System.out.println("ups");
        }
    }
}
