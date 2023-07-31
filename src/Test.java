public class Test {
    
    public static void main (String[] arg) {

        int count = 0;

        Square[][] squares = new Square[20][20];

        int xPlus = 0;
        int yPlus = 0;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                squares[i][j] = new Square(20, xPlus, yPlus);
                xPlus += 20;
            }
            yPlus += 20;
        }


    }

    public static void check(int[][] arr, int r, int c) {

        if(c-1 >= 0) if(arr[r][c-1] == 4) System.out.println(true);
        if(r-1 >= 0) if(arr[r-1][c] == 2) System.out.println(true);
        if(c-1 >= 0 && r-1 >= 0) if(arr[r-1][c-1] == 1) System.out.println(true);
        if(c+1 < arr[0].length && r-1 >= 0) if(arr[r-1][c+1] == 3) System.out.println(true);
        if(r+1 < arr[0].length && c-1 >= 0) if(arr[r+1][c-1] == 7) System.out.println(true);
        if(c+1 < arr[0].length && r+1 < arr[0].length) if(arr[r+1][c+1] == 9) System.out.println(true);
        
    }
     
}
