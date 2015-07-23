public class StringTest {
    public static void main(String[] args) {

        //System.out.printf("test() = " + test());
    }

    public static String test()
    {
        try {
            System.out.println("Try");
            if(false)throw new Exception();
            System.out.println("Try2");

            return "test";
        } catch (Exception e) {
            System.out.println("Catch");

        } finally {
            System.out.println("Finally");
        }

        return "testall";
    }
}
