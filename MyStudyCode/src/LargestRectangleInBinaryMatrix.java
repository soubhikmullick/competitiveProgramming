import java.util.Stack;

public class LargestRectangleInBinaryMatrix {

    public static int maxHistogramArea(int[] arr) {
        int maxArea = 0;
        int area;
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while(i!=arr.length) {
            if(s.isEmpty() || arr[i] >= arr[s.peek()]) s.push(i++);
            else {
                int val = s.pop();
                area = arr[val] * (s.isEmpty()?i:i-s.peek()-1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while(!s.isEmpty()) {
            int val = s.pop();
            area = arr[val] * (s.isEmpty()?i:i-s.peek()-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    static int maxRectangle(int R,int C,int A[][])
    {
        int result = maxHistogramArea(A[0]);
        for (int i = 1; i < R; i++)
        {
            for (int j = 0; j < C; j++)
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];
            result = Math.max(result, maxHistogramArea(A[i]));
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{6,2,5,0,5,1,6};
        int[][] arr = new int[][]{
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };
        System.out.println(maxRectangle(arr.length, arr[0].length, arr));
    }
}
