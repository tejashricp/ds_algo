package misc;

public class TestString {
    static String s2 = "Welcome";

    public static void main(String[] args){
        String s1 = "hello";
        fun1(s1);
        System.out.println(s1);
        fun1(s2);
        System.out.println(s2);
    }

    private static void fun1(String s1) {
        s1 = s1 + " Teja";
        System.out.println(s1);
    }

}
