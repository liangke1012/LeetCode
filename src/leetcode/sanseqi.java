package leetcode;

public class sanseqi {
    static int count;
    public static void main(String[] args) {
        char color[] = "brwwrbrbwr".toCharArray();
        count = 0;
        for (int i = 0; i < color.length; i++) {
            System.out.printf(" %c", color[i]);
        }
        System.out.println();

        threeFlags(color,count);

        System.out.printf("通过%d次完成对调后，结果如下：", count);
        for (int i = 0; i < color.length; i++) {
            System.out.printf(" %c", color[i]);
        }
    }

    private static void threeFlags(char[] color, int count) {
        int blue  = 0;
        int white = 0;
        int red = color.length - 1;
        while(color[white] == 'b'){
            blue++;
            white++;
        }
        while(color[red] == 'r'){
            red--;
        }
        while (white <= red) {
            //如果White所在位置的元素是红旗r，表示需将红旗与Red变量的元素对调，然后将Red--，，继续处理下一个位置
            if (color[white] == 'r') {
                swap(color, white, red);
                red--;
                //如果Red所在位置的元素是红旗r，继续向前移动Red位置，即Red--
                while (color[red] == 'r') {
                    red--;
                }
            }

            //如果White所在位置的元素是白旗w，表示该位置的元素应该在此，然后将White++，继续处理下一个位置
            while (color[white] == 'w') {
                white++;
            }

            //如果White所在位置的元素是蓝旗b，表示需将蓝旗与Blue变量所在位置的元素对调，然后将Blue++、White++
            if (color[white] == 'b') {
                swap(color,white, blue);
               blue++;
                white++;
            }
        }

    }

    private static void swap(char[] c, int x, int y) {
        int i;
        char temp;
        temp = c[x];
        c[x] = c[y];
        c[y] = temp;
        count++;

        System.out.printf("第%d次对调后：", count);
        for (i = 0; i < c.length; i++) {
            System.out.printf(" %c", c[i]);
        }
        System.out.println();

    }


}
