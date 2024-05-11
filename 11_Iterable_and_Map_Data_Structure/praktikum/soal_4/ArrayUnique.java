import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayUnique {

    public static int[] findUniqueElements(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> uniqueElements = new ArrayList<>();

        // Tambahkan semua elemen dari arr2 ke dalam set
        for (int num : arr2) {
            set.add(num);
        }

        // Cek setiap elemen di arr1, tambahkan ke uniqueElements jika tidak ada di set
        for (int num : arr1) {
            if (!set.contains(num)) {
                uniqueElements.add(num);
            }
        }

        // Konversi List ke array untuk output
        int[] result = new int[uniqueElements.size()];
        for (int i = 0; i < uniqueElements.size(); i++) {
            result[i] = uniqueElements.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 3, 5, 10, 16};
        int[] result1 = findUniqueElements(arr1, arr2);
        System.out.println("Output: " + java.util.Arrays.toString(result1));

        int[] arr3 = {3, 8};
        int[] arr4 = {2, 8};
        int[] result2 = findUniqueElements(arr3, arr4);
        System.out.println("Output: " + java.util.Arrays.toString(result2));
    }
}