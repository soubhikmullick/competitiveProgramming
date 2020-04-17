package others;


class BoyerMoore {
  public static void main(String[] args) {
      int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };
      int count=0, ele = 0;
      for (int i : arr) {
          if (count == 0) {
              ele = i;
              count++;
          } else if (i == ele) {
              count++;
          } else count--;
      }
    System.out.println(ele +" "+ count);
  }
}