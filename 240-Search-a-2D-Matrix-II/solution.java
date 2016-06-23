public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int line=0;
        int len=matrix.length;
        int col=matrix[0].length;
        while (line<len && col>0){
            int num= matrix[line][col-1];
            if (num>target) col--;
            if (num<target) line++;
            if (num==target) return true;}
    
        return false;
    }
    

}