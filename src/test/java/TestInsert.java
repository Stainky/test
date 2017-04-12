/**
 * Created by sj on 17/4/5.
 */
public class TestInsert {
    public static void main(String[] args) {
        int[] i = new int[]{1, 5, 3, 4, 9, 6, 8, 2, 0};
        int[] j = new int[]{1, 5, 3, 4};
//        insertSort(i);
//        shellSort(i);
//        bubbleSort2(i);
//        String[] as = new String[]{"rjh", "rgsde", "res", "wec", "resx", "asdf"};
//        sort(as, 1);
//        String test = "test";
//        System.out.println(test.charAt(2) + 1);
        System.out.println(test());
    }



    public static int test() {
        try {
            System.out.println("try block...");
            int i = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("catch block...");
//            return 2;
        } finally {
            System.out.println("finally block...");
            return 3;
        }
    }

    public static void showString(String[] as) {
        for(String s : as) {
            System.out.println(s);
        }
//        System.out.println();
    }

    public static void sort(String[] a, int w) {
        // 通过前w个字符将a[] 排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            // 计算出频率
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // 将频率转换为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            // 将元素分类
            for (int i = 0; i < N; i++ ) {
                aux[count[a[i].charAt(d)] ++] =  a[i];
            }
            for (int i = 0; i < N; i ++ ) {
                a[i] = aux[i];
            }
        }
        showString(a);
    }

    public static void bubbleSort2(int[] array) {
        showEnum(array);
        boolean swaped;
        int n = array.length;
        do {
            swaped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swaped = true;
                }
            }
            n--;
        } while (swaped);
        showEnum(array);
    }

    public static void bubbleSort(int[] array) {
        showEnum(array);
        boolean flag; // 用来判断当前这一轮是否有交换数值,若没有则表示已经排好许了
        for (int i = 0; i < array.length; i++) {
            flag = false;
            /**
             * 这边要注意 for (int j = array.length -1; j >= i + 1; j--)。 不要写成
             * for (int j =  i + 1; j < array.length ; j++)
             */
            for (int j = array.length -1; j >= i + 1; j--) {
                if (array[j -1 ] > array[j]) {
                    //数据交换
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    //设置标志位
                    flag = true;
                }
            }
            showEnum(array);
            if (!flag) {
                break;
            }
        }
    }

    public  static void showEnum(int[] i) {
        for(int item : i) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void shellSort(int[] array) {
        int len = array.length / 2; // 分成n/2组
        while (len >= 1) {
            for (int i = len; i < array.length; ++i) { //对每组进行直接插入排序
                int temp = array[i];
                int j = i - len;
                while (j >= 0 && array[j] > temp) {
                    array[j + len] = array[j];
                    j -= len;
                }
                array[j + len] = temp;
                showEnum(array);
            }
            len /= 2;
        }

    }

    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 2; i < array.length; i++ ) {
            int val = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > val) {  // array[j] > val
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = val; //  array[j+1] 不是array[j]
        }
    }
}
