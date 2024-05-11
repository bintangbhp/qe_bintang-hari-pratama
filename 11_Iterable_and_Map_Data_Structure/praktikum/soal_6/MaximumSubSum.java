public class MaximumSubSum {
    public static void main(String[] args) {
        int[] input1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;

        int[] input2 = {2, 3, 4, 1, 5};
        int k2 = 2;

        int result1 = findMaxSubSum(input1, k1);
        int result2 = findMaxSubSum(input2, k2);

        System.out.println("Input: [2, 1, 5, 1, 3, 2], k=3");
        System.out.println("Output: " + result1);

        System.out.println("\nInput: [2, 3, 4, 1, 5], k=2");
        System.out.println("Output: " + result2);
    }

    public static int findMaxSubSum(int[] arr, int k) {
        int result = 0;

        for(int i = 0; i < k; i++){
            result += arr[i];
        }

        int temp = result;
        for (int i = k; i < arr.length; i++) {
            temp += arr[i] - arr[i - k];
            result = Math.max(temp, result);
        }

        return result;
    }
}
