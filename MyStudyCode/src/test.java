import java.util.HashSet;

public class test {

    {
        System.out.println("1");
    }
    test(){
        System.out.println("2");

    }
    static {
        System.out.println("55");
    }

    public static void main(String[] args) {
        int i=1,j=2;
//        System.out.println(i+j+" ");
        String text = "as-df";
        String[] test = text.split("-");
        System.out.println(test[0]+" "+test[1]);

        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);hs.add(1);
        hs.add(3);
        hs.add(4);

        hs.forEach(
                (oo) -> {System.out.println(oo);}
        );

    }

}