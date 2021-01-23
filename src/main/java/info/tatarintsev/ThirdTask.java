package info.tatarintsev;

public interface ThirdTask {
    public default boolean check1and4InArray(int[] inputArray) {
        boolean result = false;
        for (int value: inputArray) {
            if(value == 1 || value == 4) {
                result = true;
                break;
            }
        }
        return result;
    }
}
