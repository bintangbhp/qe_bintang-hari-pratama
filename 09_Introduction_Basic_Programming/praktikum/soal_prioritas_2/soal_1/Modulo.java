import java.util.Scanner;

public class Modulo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
  
        System.out.print("Jumlah angka: ");
        int number = sc.nextInt();

        System.out.print("Nilai n: ");
        int n = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            System.out.println(i*n);
        }

        sc.close();
    }
}
