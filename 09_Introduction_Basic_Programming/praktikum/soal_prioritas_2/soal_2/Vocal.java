import java.util.Scanner;

public class Vocal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Kata: ");
        String str = sc.nextLine();

        String changedStr = "";
        for (char i: str.toCharArray()){
            if (i == 'a' || i == 'A'){
                changedStr += '4';
            }
            else if (i == 'e' || i == 'E'){
                changedStr += '3';
            }
            else if (i == 'i' || i == 'I'){
                changedStr += '1';
            }
            else if (i == 'o' || i == 'O'){
                changedStr += '0';
            }
            else {
                changedStr += i;
            }
        }

        System.out.println("Kata Terubah: " + changedStr);

        sc.close();
    }
}
