package info.tatarintsev;

import java.util.Arrays;

;


public interface SecondTask {
    public default int[] secondTaskAction(int[] inputArray) throws EmptyAfter4Exception {
        int i;
        for (i = inputArray.length - 1; i > -1 ; i--) {
            if(inputArray[i] == 4)
                break;
        }
        if(inputArray.length == 0 || i == inputArray.length) {
            throw new EmptyAfter4Exception();
        } else {
            int[] ints = Arrays.copyOfRange(inputArray, i + 1, inputArray.length);
            return Arrays.copyOfRange(inputArray, i + 1, inputArray.length);
        }
    }
}
