package reusingClasses.upcastiing;

/**
 * Created by јлекс on 24.09.15.
 * восход€щее преобразование типов
 */
class Instrument{
    public void play(){
        System.out.println("la-la-la");
    }
    protected void crash(){
        System.out.println("bah");
    }
    private void superCrash(){}
    static void tune(Instrument i){
        i.play();
    }
}
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        flute.play();
        Instrument.tune(flute);
        flute.crash();


    }

    void demoProtect(){
        crash();
    }

    void demo(){
        demoProtect();
    }
}
