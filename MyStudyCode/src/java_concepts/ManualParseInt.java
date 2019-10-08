package java_concepts;

public class ManualParseInt {

    public static void main(String[] args) {
        String s = "123";
        int ans = 0;
        for(char ch : s.toCharArray()) {
            ans += ch - '0';
            ans *=10;
        }
        ans /= 10;
        System.out.println(ans);
    }
}
