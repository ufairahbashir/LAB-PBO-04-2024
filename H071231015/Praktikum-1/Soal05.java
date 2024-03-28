import java.util.Scanner;;

public class Soal05 {
    public static void main(String[] args) {
        int[][] nums =  {{1,2,3}, {4,5,6}, {7,8,9}};
        int x;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                x = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan karena " + e);
                input.nextLine();
            }
        }

        int d1 = 0;
        int d2 = 0;

        outerloop:
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                // System.out.println("cek");
                if (x == nums[i][j]) {
                    d1 = i;
                    d2 = j;
                    break outerloop;
                }
            }
        }
        

        if (d1 == 0 && d2 == 0) {
            System.out.println(x + " not found");
        }
        else{
            System.out.println("Found " + x + " at " + "[" + d1 +"]" + "[" + d2 +"]");
        }

    }
}
