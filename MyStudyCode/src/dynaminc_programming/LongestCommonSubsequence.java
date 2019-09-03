package dynaminc_programming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String[] text = {"ABCABC","ADSVADS"};
        System.out.println(lcs(text[0],text[1], text[0].length(), text[1].length()));
    }

    private static int lcs(String one, String two, int oneL, int twoL) {
        if(oneL == 0 || twoL == 0) {
            return 0;
        }
        if(one.charAt(oneL-1) == (two.charAt(twoL-1)))
            return 1+lcs(one, two, oneL-1, twoL-1);
        else return max(lcs(one, two, oneL, twoL-1), lcs(one, two, oneL-1, twoL));
    }

    static int max(int a, int b)
    {
        return (a > b)? a : b;
    }
}
