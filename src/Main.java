import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        ZeroSequence zeroSequence=new ZeroSequence(new int[]{1,2,3,8,25}) ;
        System.out.println(zeroSequence.getMinNumberOperations());
    }
}
