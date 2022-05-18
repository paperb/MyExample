package sort;

public class PopSort{
    //冒泡排序
    //首先，来一个数据结构，要排序的一组数字,4,5,6,7,8,2,1
    //数组，arraylist

    public int[] popSort(int[] array){

        //最差情况，数组是倒序的，要排array.lenth次，每一次都移动一位
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length -1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp1 = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp1;
                    }
                }
            }
            return array;


    }

    public static void swap(){

    }

    public static void main(String[] args) {

        PopSort popSort = new PopSort();
        int[] ints = {1,3,56,7,8,2,31,3,1,26,8,232,5456,2,324,6,2,8,9,0,8,76,89,3423,56,2,2,2,2,2,2,2,4,5,54,645,645,6};
        int[] ints1 = popSort.popSort(ints);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

}
