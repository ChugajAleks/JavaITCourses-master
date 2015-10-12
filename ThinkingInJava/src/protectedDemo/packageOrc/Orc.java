package protectedDemo.packageOrc;

/**
 * Created by Алекс on 24.09.15.
 */
class Villain{
    private String name;
    protected void set(String nm){
        name = nm;
    }
    public Villain(String name){
        this.name = name;
    }
    public String toString(){
        return "Im object Villain and my name " + name;
    }
}
public class Orc extends Villain{

    private  int orcNumber;
    protected int returnInt(){
        return 12;
    }
    public Orc(String name, int orcNumber){
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber){
        set(name);
        this.orcNumber = orcNumber;
    }
    public String toString(){
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("BURGER", 12);
        System.out.println(orc);
        orc.change("BOB", 19);
        System.out.println(orc);
    }
}

