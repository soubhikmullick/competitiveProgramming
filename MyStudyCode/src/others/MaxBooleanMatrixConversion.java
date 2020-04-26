package others;

import java.util.ArrayList;
import java.util.List;

public class MaxBooleanMatrixConversion {
    int findNoOfDaysLeft(List<List<Boolean>> mat) {
        boolean flag = false;
        int ans = 0;
        for(int row = 0; row<mat.size(); row++) {
            for(int col = 0 ; col<mat.get(row).size(); col++) {
                if(mat.get(row).get(col) == true) {
                    int currCol = col;
                    int currRow = row;
                    if(currCol<=mat.get(row).size() && mat.get(row).get(currCol+1) == false){
                        mat.get(row).add(currCol+1, true);
                        flag = true;
                    }
                    if( currCol>=0 && mat.get(row).get(currCol-1) == false ) {
                        mat.get(row).add(currCol-1, true);
                        flag = true;
                    }
                    if(currRow<=mat.size() && mat.get(currRow+1).get(col) == false) {
                        mat.get(currRow+1).add(col,true);
                        flag = true;
                    }
                    if(currRow >=0 && mat.get(currRow-1).get(col) == false) {
                        mat.get(currRow-1).add(col , true);
                        flag = true;
                    }
                }
            }
            if(flag) {
                ans++;
                flag = false;
                row = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Boolean>> mat = new ArrayList<>();
        mat.add(0,new ArrayList<>());
    }
}
