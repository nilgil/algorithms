package algorithm.sort;

public class Quick {

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) { // 원소가 1개일 때는 모두 정렬된 것이므로 바로 리턴
            return;
        }
        int key = start; // 피벗 설정
        int tmp;
        int i = start + 1; // start가 피벗이므로 그 이후부터 검색
        int j = end;
        while (i <= j) { // 엇갈릴 때까지 반복
            while (i <= end && arr[i] <= arr[key]) i++; // 피벗보다 큰 값을 찾을 때까지 반복 (큰값이 없으면 end 에서 멈추도록 한다)
            while (j > start && arr[j] >= arr[key]) j--; // 피벗보다 작은 값을 찾을 때까지 반복 (작은값이 없으면 start 다음에서 멈추도록 한다)
            if (i <= j) { // 엇갈린 상태가 아니면 두 값 위치 변경
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        } // 엇갈리면 반복문 탈출하고, 키와 작은값의 위치 변경
        tmp = arr[j];
        arr[j] = arr[key];
        arr[key] = tmp;

        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }

    public static void main(String[] args) {

        int[] arr = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
