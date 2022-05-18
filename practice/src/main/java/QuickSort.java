import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);

    }
    public int partition(int[] arr,int left,int right){
        int pivot = left;
        int index = pivot+1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index - 1, pivot);
        return index - 1;
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
        return arr;
    }


    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{3, 2, 1};
        int[] sort = selectSort.sort(arr);
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
