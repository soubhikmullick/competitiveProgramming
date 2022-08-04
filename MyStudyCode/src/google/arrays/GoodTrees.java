package google.arrays;
/*
Array consists of N integers. Need to remove one element, so that will have alternate high and low elements.
No two alternate numbers should be equal after removal. Only one elements has to be removed.

Example:
1.
A=[3,4,5,3,7]

return answer as 3

Removing A[0] gives [4,5,3,7]
Removing A[1] gives [3,5,3,7]
Removing A[2] gives [3,4,3,7]

A= [1,2,3,4] return -1

A = [4,5,6,5] return 2

Removing A[0] gives [5,6,5]
Removing A[1] gives [4,6,5]
 */
public class GoodTrees {
  private static int ans = 0;
  public static void solution (int[] array, int index) {
    if(index==array.length) {
      return;
    }
    int[] subArray = new int[array.length-1];
    for (int i = 0, j=0; i < array.length; i++) {
      if(i!=index) {
        subArray[j++] = array[i];
      }
    }
    if (isAlternates(subArray)) ++ans;
    solution(array, index+1);
    return;
  }

  public static boolean isAlternates(int[] array) {
    boolean asc = false;
    if(array[0]<array[1]) asc = true;
    for (int i = 1; i < array.length-1; i++) {
      if(array[i]>array[i+1] && asc) asc = false;
      else if(array[i]<array[i+1] && !asc) asc = true;
      else return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[] array = {1,3,1,2};
    if (isAlternates(array)) System.out.println(0);
    solution(array, 0);
    System.out.println(ans);
  }

//  public static void main(String[] args) {
//    int[] array = {3,4,5,3,7};
//    int ans = -1;
//    int asc = -1;
//    for (int i = 0; i < array.length; i++) { //number to skip
//      int tempAns = -1;
//      for (int j = 0; j < array.length-1;) {
//        int k=0;
//        if(j==i-1) {
//          k=i+1;
//        } else k=j+1;
//        if(i==j) {
//          j++;
//          continue;
//        }
//        System.out.println("i:"+i+" k:"+k+" j:"+j);
//        System.out.println(array[j]+" "+array[k]);
//        if(asc == -1) {
//          asc = array[k]>array[j]?1:0;
//          tempAns=1;
//        } else {
//          if(asc==1) {
//            if(array[j]<array[k]) {
//              tempAns=-1;
//              break;
//            }
//            asc = 0;
//          } else {
//            if(array[j]>array[k]) {
//              tempAns=-1;
//              break;
//            }
//            asc = 1;
//          }
//        }
//
//        j=k;
//      }
//      if(i!=array.length-1) {
//          ans = ans==-1&&tempAns!=-1?tempAns:Math.max(tempAns+ans, ans);
//      }
//      asc=-1;
//    }
//    System.out.println(ans);
//  }


}


/*

 */
