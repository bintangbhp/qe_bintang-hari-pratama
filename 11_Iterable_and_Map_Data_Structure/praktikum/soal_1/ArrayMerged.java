import java.util.Arrays;
import java.util.HashSet;

public class ArrayMerged{
    public static void main(String[] args) {
        //Input 1
        HashSet<String> mergedArray1 = new HashSet<>();
        
        String[] firstArray = {"kazuya", "jin", "lee"};
        String[] secondArray = {"kazuya", "feng"};
        mergedArray1.addAll(Arrays.asList(firstArray));
        mergedArray1.addAll(Arrays.asList(secondArray));
        System.out.println(mergedArray1);

        //Input 2
        HashSet<String> mergedArray2 = new HashSet<>();

        String[] thirdArray = {"lee", "jin"};
        String[] fourthArray = {"kazuya", "panda"};
        mergedArray2.addAll(Arrays.asList(thirdArray));
        mergedArray2.addAll(Arrays.asList(fourthArray));
        System.out.println(mergedArray2);
    }
}
