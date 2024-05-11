import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueNumbers {

    public static List<Integer> findUniqueNumbers(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Menghitung frekuensi masing-masing digit
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Mengumpulkan digit yang frekuensinya hanya satu
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueNumbers.add(Character.getNumericValue(entry.getKey()));
            }
        }
        
        return uniqueNumbers;
    }

    public static void main(String[] args) {
        String input1 = "76523752";
        String input2 = "1122";
        
        System.out.println(findUniqueNumbers(input1)); // Output: [6, 3]
        System.out.println(findUniqueNumbers(input2)); // Output: []
    }
}
