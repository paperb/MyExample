import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class GetQuestionList {

    public List<String> getQuestionList(int[] array,List<String> word) {
        List<String> list = new ArrayList<>();

        for (int i=0;i<array.length;i++) {
            String s = word.get(i)+":";
            int v = (int)(Math.random() * (array[i])+1);
            list.add(s+v);
        }

        return list;
    }


    public String getQuestionList(int range) {
        int num = (int) (Math.random() * range)+1;
        return "本次抽到的是第"+num+"题";
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int va = scanner.nextInt();
        int[] a = {18, 10, 16, 6, 13, 13, 11, 29, 6, 13, 7, 21,20,4,18};
        List<String> list = new ArrayList<>();
        list.add("上");
        list.add("中");
        list.add("下");
        list.add("重要");
        list.add("上");
        list.add("下");
        list.add("基础");
        list.add("进阶");
        list.add("JVM");
        list.add("MySQL");
        list.add("重要");
        list.add("Redis");
        list.add("Spring常见问题");
        list.add("Spring");
        list.add("Mybatis");

        GetQuestionList getQuestionList = new GetQuestionList();
        List<String> questionList = getQuestionList.getQuestionList(a,list);
        System.out.println(questionList);

//        for (int i = 0; i < 100; i++) {
//
//        }
        System.out.println(getQuestionList.getQuestionList(va));

    }
}

