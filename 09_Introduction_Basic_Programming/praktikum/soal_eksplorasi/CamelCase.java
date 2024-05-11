import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Kata: ");
        String str = sc.nextLine();

        // Logic
        String result = "";
        boolean nextTitleCase = false;
        for (char i : str.toLowerCase().toCharArray()) {
            if (i == ' ') {
                nextTitleCase = true;
            }
            else if (nextTitleCase) {
                result += Character.toUpperCase(i);
                nextTitleCase = false;
            }
            else {
                result += i;
            }
        }
        
        System.out.println("Kata dalam Camel Case: " + result);
        sc.close();
    }
}
