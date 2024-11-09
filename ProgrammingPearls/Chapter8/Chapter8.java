package ProgrammingPearls.Chapter8;

public class Chapter8 {
    public static void main(String[] args) {
        SubMatrix subMatrix = new SubMatrix();
        int[][] matrix = {
            {1, 3, -2},
            {2, 0, -1},
            {3, 1, 4}
        };
        int maxSumRectangle = subMatrix.maxSumRectangle(matrix);
        System.out.println(maxSumRectangle);
    }
}
