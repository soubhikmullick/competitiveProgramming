public class FindMinNumber {
  public static void main(String[] args) {
    String string = "934651";
    System.out.println(findMinNumber(string, 2));
  }

  public static String findMinNumber(String s, int k)
  {
    if(s==null) return "";
    char min = '9';
    int index = -1;
    int i = 0;
    while(k-->=0) {
      for(; i<s.length(); i++) {
        min = s.charAt(i);
        index = -1;
        for(int j=s.length()-1; j>=i; j--) {
          if(min>s.charAt(j)) {
            min = s.charAt(j);
            index = j;
          }
        }
        if(index == -1) {
          continue;
        } else {
          System.out.println(i+" "+min +" "+ index);
          s = swap(s, i, min, index);
          i++;
          break;
        }
      }
    }
    return s;
  }

  private static String swap(String s, int i, char min, int index) {
    char curr = s.charAt(i);
    StringBuilder sb = new StringBuilder(s);
    sb.setCharAt(i, min);
    sb.setCharAt(index, curr);
    return sb.toString();
  }
}
