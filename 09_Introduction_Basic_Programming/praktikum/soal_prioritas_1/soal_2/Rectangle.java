import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Panjang: ");
        int p = sc.nextInt();

        System.out.print("Lebar: ");
        int l = sc.nextInt();

        // Output
        if ((p*l) % 2 != 0){
            System.out.println("odd rectangle");
        }
        else {
            System.out.println("even rectangle");
        }

        sc.close();
    }
}
