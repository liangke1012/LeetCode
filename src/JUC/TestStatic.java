package JUC;

public class TestStatic {
    public static int a = 0,b = 0;

    public static void main(String[] args) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               a = a + 1;
           }
       }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                b = b + 1;
            }
        }).start();
        System.out.println(a + "   " + b);
        int c = a + b;
        System.out.println(c);


    }


}
