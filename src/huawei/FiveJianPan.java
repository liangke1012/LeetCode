package huawei;

public class FiveJianPan {

    public static void main(String[] args) {
        String input = "1 1 1 5 2 4 3 4 1 4 5 1"; //屏幕上的字
        String screen = "";
        boolean select = false;
        String clip = "";
        String[] split = input.split(" ");
        for (int i = 0; i < split.length; i++) {
            int op = Integer.parseInt(split[i]);
            if (op == 1&&select) {
                screen ="a";
                select=false;
            } else if (op == 1 && !select) {
                screen += "a";
            } else if (op == 2 && select) {
                clip=screen;
            } else if (op == 3 && select) {
                clip = screen;
                screen = "";
                select = false;
            } else if (op == 4 && select) {
                screen = clip;
                select = false;
            } else if (op == 4 && !select) {
                screen+=clip;
            } else if (op == 5) {
                clip = screen;
                select =true;
            }
        }
        System.out.println(screen.length());
    }
}
