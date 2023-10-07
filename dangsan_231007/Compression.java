package dangsan_231007;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Compression {
    public int[] solution(int[][] arr) {
        int[] counts = new int[2];

        int start = 0;
        int end = arr.length;
        compress(arr, counts, start, start, end, end);

        return counts;
    }

    public static void compress(int[][] arr, int[] counts,
                                int xStart, int yStart, int xEnd, int yEnd) {
        Integer valueToCheck = arr[xStart][yStart];
        boolean isAllSame = IntStream
                .range(xStart, xEnd)
                .flatMap(i -> Arrays.stream(arr[i], yStart, yEnd))
                .allMatch(valueToCheck::equals);

        if (isAllSame) {
            counts[valueToCheck]++;
            return;
        }

        int xMid = xStart + (xEnd - xStart) / 2;
        int yMid = yStart + (yEnd - yStart) / 2;
        compress(arr, counts, xStart, yStart, xMid, yMid);
        compress(arr, counts, xStart, yMid, xMid, yEnd);
        compress(arr, counts, xMid, yStart, xEnd, yMid);
        compress(arr, counts, xMid, yMid, xEnd, yEnd);
    }
}
