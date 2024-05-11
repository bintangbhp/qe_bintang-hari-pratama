import java.util.Scanner;

public class Paket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        // Input
        System.out.print("Berat paket (kg): ");
        int weight = sc.nextInt();

        System.out.print("Jarak tempuh (km): ");
        int distance = sc.nextInt();

        // Branching
        int weightCost = 0;
        if(weight < 2){
            weightCost = 10000;
        }
        else if(weight >= 2 && weight <= 7){
            weightCost = 15000;
        }
        else  if(weight >= 8 && weight <= 15){
            weightCost = 25000;
        }
        else{
            weightCost = 40000;
        }

        int distanceCost = 0;
        if(distance < 1){
            distanceCost = 2000;
        }
        else if(distance >= 1 && distance <= 7){
            distanceCost = 5000;
        }
        else  if(distance >= 8 && distance <= 15){
            distanceCost = 10000;
        }
        else if (distance > 15) {
            distanceCost = 20000;
        }

        // Output
        System.out.println("Biaya: Rp " + (weightCost + distanceCost));

        sc.close();
    }
}
