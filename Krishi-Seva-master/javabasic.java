// // [1]...ARTHEMATIC OPERATORS...[+,-,*,/,%]

// import java.util.Scanner;
// public class javabasic {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter first number");
//         int a = sc.nextInt();
//         System.out.println("Enter second number");
//         int b = sc.nextInt();
//         System.out.println("ADD:"+ (a+b));
//         System.out.println("SUB:"+ (a-b));
//         System.out.println("DIV:"+ a/b);
//         System.out.println("MUL:"+ a*b);
//         System.out.println("REM:"+ a%b);
//     }
// }

// UNARY OPERATOR....[++a,a++,--a,a--]

// 1 [Pre-Increment] ++A...
// public class javabasic {

//     public static void main(String[] args) {
//         int a = 5;
//         int b = ++a;
//         System.out.println(a);
//         System.out.println(b);
//     }
// }

// // 2 [Post-Increment] A++...
// public class javabasic {

//     public static void main(String[] args) {
//         int a = 5;
//         int b = a++;
//         System.out.println(a);
//         System.out.println(b);
//     }
// }

// // 3 [Pre-Decrement] --A...
// public class javabasic {

//     public static void main(String[] args) {
//         int a = 5;
//         int b = --a;
//         System.out.println(a);
//         System.out.println(b);
//     }
// }

// // 4 [Post-Decrement] A--...
// public class javabasic {

//     public static void main(String[] args) {
//         int a = 5;
//         int b = a--;
//         System.out.println(a);
//         System.out.println(b);
//     }
// }

// // // [2]...RELATIONAL OPERATORS...[==,!=,<,>,<=,>=]
// import java.util.Scanner;

// public class javabasic {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter first number");
//         int a = sc.nextInt();
//         System.out.println("Enter second number");
//         int b = sc.nextInt();
//         System.out.println(a==b);
//         System.out.println(a!=b);
//         System.out.println(a<b);
//         System.out.println(a>b);
//         System.out.println(a<=b);
//         System.out.println(a>=b);
//     }
// }

// // [3]... Logical OPERATOR...[&&,||,!]

// public class javabasic {

//     public static void main(String[] args) {
//         System.out.println((3>2)&&(2<10));
//         System.out.println((3>2)&&(2>10));
//         System.out.println(!(3>2));
//     }
// } 

// [4]... Bit-wise OPERATOR...[&,|,^,~,<<,>>]

// import java.util.Scanner;
// public class javabasic {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Please sir enter first number");
//         int a =  sc.nextInt();
//         System.out.println("Please sir enter Second number");
//         int b =  sc.nextInt();
//         System.out.println(a&b);
//         System.out.println(a|b);
//         System.out.println(a^b);
//         System.out.println(~0);
//         System.out.println(a<<b);
//         System.out.println(a>>b);
//     }
// }

// // Q:-[1] check if a number is even or odd
// /**
//  * javabasic
//  */
// public class javabasic {

//     public static void oddOreven(int n) {
//         int bitMask = 1;
//         if ((n & bitMask)==0){
//             System.out.println("even");
//         }else{
//             System.out.println("odd");
//         }
        
//     }
//     public static void main(String[] args) {
//         oddOreven(9);
//         oddOreven(8);
//         oddOreven(1);
//     }
// }

