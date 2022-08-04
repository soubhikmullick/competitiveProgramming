package google.arrays;

/*
    Given a binary array, find the index of 0 to be replaced with 1 to get the maximum length sequence of continuous ones.
    For example, consider the array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }.
    We need to replace index 7 to get the continuous sequence of length 6 containing all 1’s.
    {}
    {0}
    {1}
    {0,1,1}
    {0,1,0,1}
    {1,1,1}

    Ans : Sliding Window keeping track of atmost 2 zeroes in the window : https://www.techiedelight.com/find-maximum-length-sequence-continuous-ones-sliding-window/
*/

public class Replace0ToFindMaxSequenceOf1 {
  public static void main(String[] args) {
    int[] array = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
    int[] array1 = {};
    int[] array2 = { 0, 0, 1};
    int[] array3 = { 0, 0, 1, 0 };
    int[] array4 = { 1, 1, 1, 1, 1 }; //to do
    int[] array5 = {0};
    int[] array6 = { 0, 0, 0, 0};
    int[] array7 = { 0, 1, 1, 0, 1};
    System.out.println(solution(array));
    System.out.println(solution(array1));
    System.out.println(solution(array2));
    System.out.println(solution(array3));
    System.out.println(solution(array4));
    System.out.println(solution(array5));
    System.out.println(solution(array6));
    System.out.println(solution(array7));
  }

  private static int solution(int[] array) {
    if(array.length == 0) {
      return -1;
    }
    int ans = -1, onesBeforeZero = 0, onesAfterZero = 0, prevZeroIndex = -1, maxCounter = 0;
    for(int i=0; i<array.length; i++) {
      if(array[i]==1) {
        if(i>prevZeroIndex) {
          onesAfterZero++;
        } else {
          onesBeforeZero++;
        }
      } else {
          if(onesBeforeZero+onesAfterZero>maxCounter && i!=array.length-1) {
            ans=i;
            maxCounter=onesBeforeZero+onesAfterZero;//1
          }
          onesBeforeZero = onesAfterZero;//1
          onesAfterZero = 0;
          prevZeroIndex=i;
      }
    }
    return ans;
  }
}