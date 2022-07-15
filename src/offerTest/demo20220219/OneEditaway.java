package offerTest.demo20220219;

//符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
public class OneEditaway {
    public static void main(String[] args) {
         boolean flag = oneEditAway("intention","execution");
        System.out.println(flag);
    }

    public static boolean oneEditAway(String first, String second) {
        int lf = first.length();
        int ls = second.length();
        if(lf > ls){
            return oneEditAway(second,first);
        }
        if(ls - lf > 1){
            return false;
        }
        if(lf == ls){
            int count= 0;
            for(int i = 0;i<lf;i++){
                if(first.charAt(i) != second.charAt(i)) {
                    count += 1;
                }
            }
            return count <= 1;
        }
        int i =0,ofs = 0;
        while(i < lf){
            if(first.charAt(i) != second.charAt(i + ofs)){
                if(++ofs>1){
                    return false;
                }
            }else{
                i += 1;
            }
        }
        return true;

    }
}
