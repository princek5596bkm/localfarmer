//  OPERATORS...

// [1] Get ith bit...   10 = 1010
public class Operators {
    public static  int getIthbit(int n,int i){
        int bitMask = 1<<i;
        if ((n&bitMask)==0){
            return 0;
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        System.out.println(getIthbit(10, 2));
        
    }
}
