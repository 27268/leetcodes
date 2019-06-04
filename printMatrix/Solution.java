package printMatrix;

import java.util.ArrayList;

public class Solution {
    //输出矩阵
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();
//        if(row == 1){
//            for(int i=0; i<col; i++){
//                res.add(matrix[0][i]);
//            }
//            return res;
//        }
//        if( col==1 ){
//            for(int i=0; i<row; i++){
//                res.add(matrix[i][0]);
//            }
//            return res;
//        }
        //行：[pointA, pointB_x), 列：[pointA, pointB_y）
        int pointA = 0, pointB_x = row-1, pointB_y = col-1;
        while(pointA <= pointB_x && pointA <= pointB_y){
            for(int i=pointA; i<=pointB_y; i++){ //[pointA][pointA] - [pointA][pointB_y-1]
                res.add(matrix[pointA][i]);
            }
            for(int j=pointA+1; j<=pointB_x; j++){//[pointA][pointB_y] - [pointB_x-1][pointB_y]
                res.add(matrix[j][pointB_y]);
            }
            if(pointA != pointB_x){
                for(int k=pointB_y-1; k>=pointA; k--){//[pointB_x][pointB_y] - [pointB_x][pointA+1]
                    res.add(matrix[pointB_x][k]);
                }
            }
            if(pointA != pointB_y){
                for(int t=pointB_x-1; t>pointA; t--){//[pointB_x][pointA] - [pointA+1][pointA]
                    res.add(matrix[t][pointA]);
                }
            }
            pointA++;
            pointB_x--;
            pointB_y--;

        }
        return res;
    }
    public ArrayList<Integer> printMatrixR(int [][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int pointA = 0, pointB_x = row-1, pointB_y = col-1;
        doMatrix(matrix, pointA, pointB_x, pointB_y, res);
        return res;
    }
    public void doMatrix(int[][] matrix, int pointA, int pointB_x, int pointB_y, ArrayList<Integer> res){

        if(pointA == pointB_x){
            for (int i=pointA; i<=pointB_y; i++){
                res.add(matrix[pointA][i]);
            }
        }
        if(pointA == pointB_y){
            for (int i=pointA; i<=pointB_x; i++){
                res.add(matrix[i][pointA]);
            }
        }

        return;
    }

}
