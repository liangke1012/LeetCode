package offerTest.demo20220219;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 */
public class Multiply {

    public static void main(String[] args) {
       int a = 100;
        System.out.println(a >> 1);
       int b = multiply(5,6);
        System.out.println(b);
    }

    public static int multiply(int A,int B){
        if(A > B){
            return multiply(B,A);
        }
        if(A == 1){
            return B;
        }
        if(A%2 == 0){
            return multiply(A >> 1,B)<<1;
        }else{
            return (multiply(A >> 1,B)<<1) + B;
        }
    }
}
