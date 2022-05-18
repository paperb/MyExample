import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class TestRandomFileStream {
    public static void main(String[] args) throws IOException{
        read();
        //append();
    }

    private static void append() throws IOException {
        String filePath = "C:\\Users\\93832\\Desktop\\123.txt";
        RandomAccessFile raf = null;
        File file = null;
        try {
            file = new File(filePath);
            raf = new RandomAccessFile(file, "rw");
            raf.seek(raf.length());
            byte[] b = new byte[1000];

            raf.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            raf.close();
        }
    }

    private static void read() throws IOException {
        String filePath = "C:\\Users\\93832\\Desktop\\123.txt";
        RandomAccessFile raf = null;
        File file = null;
        try {
            file = new File(filePath);
            raf = new RandomAccessFile(file, "r");
            System.out.println("输入内容"+raf.getFilePointer());
            raf.seek(6);
            /*byte[] b = new byte[1000];
            int hasRead = 0;
            while ((hasRead = raf.read(b)) > 0) {
                //输出文件读取的内容
                System.out.println(new String(b, 0, hasRead));
                //System.out.println(new String(raf.read(b).getBytes("ISO-8859-1"), "utf-8"));
            }*/
            String s = new String(raf.readLine().getBytes("8859_1"), "utf-8");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            raf.close();
        }
    }
}
