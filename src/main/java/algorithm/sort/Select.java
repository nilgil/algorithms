package algorithm.sort;

/**
 * 선택 정렬 : 가장 작은 것을 선택하여 제일 앞으로 보내는 것을 반복 / O(N^2)
 */
public class Select {

    public static void main(String[] args) {

        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        int min, tmp, idx = 0;
        for (int i = 0; i < arr.length; i++) { // 총 개수 만큼 스와핑 시도
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) { // 이미 정리된 앞은 최소값 검색에서 제외
                if (min > arr[j]){
                    min = arr[j];
                    idx = j;
                }
            }
            // 스와핑
            tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
