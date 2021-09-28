public class matrixMul implements Runnable {
    private int row;
    private double[][] A;
    private double[][] B;
    private double[][] result;

    public matrixMul(int row, int col, double[][] A, double[][] B, double[][] result) {
        this.row = row;
        this.A = A;
        this.B = B;
        this.result = result;
    }

    // function executed inside threads
    public void run() {
        for(int i = 0; i < 4; i++) {                    // 5 threads
            for(int j = 0; j < 20; j++) {               // 20 rows
                for(int k = 0; k < 20; k++) {           // 20 columns
                    result[row+i][j] += A[row+i][j] * B[k][i];
                }
            }
        }
    }
}
