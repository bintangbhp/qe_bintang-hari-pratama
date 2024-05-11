import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] input1 = {2, 3, 3, 3, 6, 9, 9};
        int[] input2 = {2, 2, 2, 11};

        int result1 = removeDuplicates(input1);
        int result2 = removeDuplicates(input2);

        System.out.println("Input: [2, 3, 3, 3, 6, 9, 9]");
        System.out.println("Output: " + result1);

        System.out.println("\nInput: [2, 2, 2, 11]");
        System.out.println("Output: " + result2);
    }

    public static int removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int num : arr) {
            set.add(num);
        }

        return set.size();
    }
}
