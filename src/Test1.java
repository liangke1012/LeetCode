import java.util.*;


public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();

        Map<Integer,int[]> map = new HashMap<>();
        int[] dayInts = new int[30];
        for (int i = 0; i < 30; i++) {
            dayInts[i] = sc.nextInt();
        }

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < dayInts[i]; j++) {
                int input = sc.nextInt();
                if(input > N -1){
                    continue;
                }
                int[] temp = new int[2];
                if(map.containsKey(input)){
                    temp = map.get(input);
                    temp[1] ++;
                }else{
                    temp[0] = i;
                    temp[1] = 1;
                }
                map.put(input,temp);
            }
        }

        List<Map.Entry<Integer,int[]>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort( (a,b) -> {
            if(b.getValue()[1] < a.getValue()[1]){
                return -1;
            }else if(b.getValue()[1] == a.getValue()[1]){
                if(b.getValue()[0] > a.getValue()[0]){
                    return -1;
                }
            }
            return 1;
        });

        String res = "";
        for (int i = 0; i < (mapList.size() < 5? mapList.size() : 5); i++) {
              res+= mapList.get(i).getKey() + " ";
        }
        System.out.println(res.substring(0,res.length()-1));
    }

}
