package 剑指Offer;/*
剑指 Offer 29
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
*
* */

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = spiralOrder1(matrix);
        for (int i = 0; i < row * col; i++) {
            System.out.println(result[i]);
        }

    }

    //错误
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }
        int[][] flag = new int[matrix.length][matrix[0].length];
        int j = 0;
        int k = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row*col];
        for (int i = 0; i <  row * col; i++) {
            flag[j][k] = 1;
            result[i] = matrix[j][k];
            if (k+1<col && flag[j][k+1]==0 ){
                k++;
            }
            else if (j+1<row && flag[j+1][k] == 0 ){
                j++;
            }
            else if (k-1>=0 && flag[j][k-1] == 0){
                k--;
            }
            else if (j-1>=0 && flag[j-1][k] == 0){
                j--;
            }
        }
        return result;
    }

    //正确
    public static int[] spiralOrder1(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }
        int[][] flag = new int[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        int k = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row*col];
        while(i <  row * col - 1){
            while( k+1 < col && flag[j][k+1]==0){
                result[i ++] = matrix[j][k];
                flag[j][k] = 1;
                k ++;
            }
            while( j+1<row && flag[j+1][k] == 0){
                result[i ++] = matrix[j][k];
                flag[j][k] = 1;
                j ++;
            }
            while( k-1>=0 && flag[j][k-1] == 0){
                result[i ++] = matrix[j][k];
                flag[j][k] = 1;
                k--;
            }
            while( j-1>=0 && flag[j-1][k] == 0){
                result[i ++] = matrix[j][k];
                flag[j][k] = 1;
                j--;
            }
        }
        result[i] = matrix[j][k];
        return result;
    }

    //官方
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //存储四个方向（坐标变化方式）
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;   //循环变换方向
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

}
