package algorithm.sort;

/**
 * 삽입 정렬 : 앞이 정렬됨을 가정하고, 뒤가 더 작은 경우 앞과 스와핑을 반복하여 제 위치에 도착하면 멈추는 것을 반복 / O(N^2)
 * <p>
 * 제 위치에 도착시 중간에 반복을 멈추기 때문에 O(N^2) 중에서는 가장 효율적
 * 거의 정렬된 상태에 한해서는 다른 어떤 알고리즘보다도 가장 효율적이다.
 */
public class Insert {

    public static void main(String[] args) {

        int[] arr = {10, 1, 5, 8, 7, 6, 4, 3, 2, 9};

//        int j, tmp;
//        for (int i = 0; i < arr.length - 1; i++) {
//            j = i; // 정렬된 부분은 건너뛴다.
//
//            // 뒤가 더 작은 경우 스와핑
//            while (arr[j] > arr[j + 1]) { // 앞은 이미 정렬되었으니 이 조건에 해당하지 않는다는 것은 제 위치에 도착함을 뜻함
//                tmp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = tmp;
//                if (j > 0) j--;
//            }
//        }

        int tmp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j - 1] <= arr[j]) break;
                tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
            }
        }

        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
