public class SelectSort {

    public int[] sort(int[] arr) {
        int temp,minIndex;
        for (int i = 0; i < arr.length -1; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{1,4,6,2,4,45,6,3,2,1,5,7};
        int[] sort = selectSort.sort(arr);
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
