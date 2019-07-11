public class test {
    {
        System.out.println("1");
    }
    test(){
        System.out.println("2");

    }
    static {
        System.out.println("3");
    }

    public static void main(String[] args) {
        test t = new test();
    }
}
