package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree0011 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String treeStr = scanner.nextLine();
            solution(treeStr);
        }
    }

    private static void solution(String treeStr) {
        String[] split = ("0 " + treeStr).split(" ");
        int min = Integer.MAX_VALUE;
        int minPos = 0;
        for (int i = 2; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);
            if (tmp != 0 && tmp != -1 && tmp < min && i * 2 > split.length) {
                min = tmp;
                minPos = i;
            }
        }
        List<String> path = new ArrayList<>();
        back(split, minPos, path);

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }

    private static void back(String[] split, int minPos, List<String> path) {
        path.add(split[minPos]);
        if (minPos == 1) {
            return;
        }
        if (minPos % 2 == 0) {
            back(split, minPos / 2, path);
        } else {
            back(split, (minPos - 1) / 2, path);
        }
    }

}
