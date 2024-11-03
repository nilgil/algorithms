package algorithm.sort;

/**
 * 버블 정렬 : 바로 옆과 비교하여 더 작은 값을 앞으로 보내는 것을 반복 / O(N^2)
 *
 * 매 반복마다 스와핑이 있어 O(N^2) 중에서도 가장 비효율적
 */
public class Bubble {

    public static void main(String[] args) {

        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        int tmp;
        for (int i = 0; i < arr.length; i++) { // 총 개수만큼 반복
            for (int j = 0; j < arr.length - 1 - i; j++) { // 매 반복마다 끝에 가장 큰 값이 정리된다. 다음 싸이클에서는 포함되지 않도록 한다.
                if (arr[j] > arr[j + 1]) { // 더 작은 값을 앞으로 보낸다.
                    // 스와핑이 매 반복마다 일어나 가장 효율이 좋지않다.
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
