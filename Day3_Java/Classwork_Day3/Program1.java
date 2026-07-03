public class Program1 {
    public static void main (String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int sum = a + b;

        System.out.println("Addition : "+sum);
    }
}
/*
PS C:\> javac Program1.java
PS C:\> java Program1 10 20
Addition : 30
*/