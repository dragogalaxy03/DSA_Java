class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0, left =0;
        int bottom = n-1, right = m-1;
        List<Integer> myList = new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i=left; i<=right; i++){
                myList.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++){
                myList.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    myList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    myList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return myList;
        
    }
}