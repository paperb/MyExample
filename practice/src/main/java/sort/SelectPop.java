package sort;

public class SelectPop {

    public int[] selectPop(int[] arr) {
        int minIndex,temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
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
        SelectPop selectPop = new SelectPop();
        int[] ints = selectPop.selectPop(new int[]{12, 35, 7, 2, 1, 6, 89,451});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
