import java.util.Scanner; 
public class TP1_5_H071231012 {
    public static void main(String[] args){
        int[][] nums = {{1, 2, 3}, {4, 5, 2}, {7, 8, 9}};
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nilai yang ingin dicari : ");
        try {
            int angka = input.nextInt();
        String hasil = "";
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[i].length; j++){
                if (nums[i][j] == angka){
                    hasil = String.format("Found %d at [%d][%d]", angka, i, j);
                    break;
                }
            }
            if (hasil != "Angka tidak ada dalam nums"){
                break;
            }
        }
        input.close();
        System.out.println(hasil);
        } catch (Exception e){
            System.out.println("Inputan Bukan Angka");
        }
    }
}