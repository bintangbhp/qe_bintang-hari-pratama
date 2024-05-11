import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] findTwoSumIndices(int[] arr, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            numToIndex.put(arr[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6};
        int target1 = 6;
        int[] result1 = findTwoSumIndices(arr1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

        int[] arr2 = {2, 5, 9, 11};
        int target2 = 11;
        int[] result2 = findTwoSumIndices(arr2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");
    }
}
