public class matrixMul implements Runnable {
    protected int p;
    protected int q;
    protected int r;
    protected int[][] A;
    protected int[][] B;
    protected int[][] result;

    public matrixMul(){ //default constructor for martixMul
        p = 0;
        q = 0;
        r = 0;
    }

    public matrixMul(int p, int q, int r, int[][] A, int[][] B) {
        this.p = p;
        this.q = q;
        this.r = r;
        this.A = A;
        this.B = B;
        result = new int[p][r]; //result has dimensions equal to A rows and B cols
        for(int i = 0; i < p; i++){ //initializes the result matrix with 0s
            for(int j = 0; j < r; j++){
                result[i][j] = 0;
            }
        }
    }

    public void run() { //single thread run version
        for(int i = 0; i < p; i++) {                    
            for(int k = 0; k < r; k++) {               
                for(int j = 0; j < q; j++) {           
                    result[i][k] += A[i][j] * B[j][k];
                }
            }
        }
    }

    public class firstComputer implements Runnable{ //first thread's work; calculates section 1 of resulting matrix
        public void run(){
            for(int i = 0; i < p/5; i++) {                    
                for(int k = 0; k < r; k++) {               
                    for(int j = 0; j < q; j++) {           
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
    }

    public class secondComputer implements Runnable{ //second thread's work; calculates section 2 of resulting matrix
        public void run(){
            for(int i = p/5; i < 2*p/5; i++) {                    
                for(int k = 0; k < r; k++) {               
                    for(int j = 0; j < q; j++) {          
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
    }

    public class thirdComputer implements Runnable{ //third thread's work; calculates section 3 resulting matrix
        public void run(){
            for(int i = 2*p/5; i < 3*p/5; i++) {
                for(int k = 0; k < r; k++) {               
                    for(int j = 0; j < q; j++) {           
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
    }

    public class fourthComputer implements Runnable{ //fourth thread's work; calculates section 4 of resulting matrix
        public void run(){
            for(int i = 3*p/5; i < 4*p/5; i++) {                    
                for(int k = 0; k < r; k++) {               
                    for(int j = 0; j < q; j++) {           
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
    }

    public class fifthComputer implements Runnable{ //fifth thread's work; calculates section 5 of resulting matrix
        public void run(){
            for(int i = 4*p/5; i < p; i++) {                    // 5 threads
                for(int k = 0; k < r; k++) {               // 20 columns
                    for(int j = 0; j < q; j++) {           // 20 rows
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
    }

    public void printResult() { //prints the resulting matrix
        for(int i = 0; i < p; i++){
            for(int j = 0; j < r; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
