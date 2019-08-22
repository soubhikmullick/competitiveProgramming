public class ReverseWordsAndWholeString {
    static char[] reverseWords(char[] arr) {
        int first = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ' || i == arr.length-1) {
                if(i == arr.length-1)
                    swap(arr, first, i);
                else swap(arr, first, i-1);
                System.out.println(arr);
                first=i+1;
            }
        }
        swap(arr, 0, arr.length-1);
        return arr;
    }

    static void swap(char[] a, int start, int end) {
        char temp;
        while(start<end) {
            temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }

    public static void main(String[] args) {

        String s = "1231";
        System.out.println(s.length());
        char[] test = new char[]{'p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e'};
        System.out.println(reverseWords(test));

    }
}
