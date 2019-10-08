package others;

public class MysteryNumber {

    static int reverseNum(int x)
    {
        String s = Integer.toString(x);
        String str="";
        for(int i=s.length()-1;i>=0;i--)
        {

            str=str+s.charAt(i);
        }

        int rev=Integer.parseInt(str);
        return rev;
    }

    static boolean isMysteryNumber(int n, int i)
    {
        if(i+reverseNum(i) == n) System.out.println(i+" "+(n-i));
        else if(i+reverseNum(i) > n) return isMysteryNumber(n, i-1);
        else if(i+reverseNum(i) < n) return isMysteryNumber(n, i+1);
        return true;
    }

    public static void main(String []args)
    {
        int n = 121;
        isMysteryNumber(n, n/2);

    }

}
