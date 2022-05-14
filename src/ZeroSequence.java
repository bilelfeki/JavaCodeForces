import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * this class perform work for a single sequence
 */

public class ZeroSequence {

    public int[] sequence ;


    /**
     * sort the sequence
     * @param sequence
     */

    public ZeroSequence(int[] sequence) {
        this.sequence = sequence;
        Arrays.sort(this.sequence);
    }

    /**
     * The Algorithm
     * when there is 0 in the sequence, let cnt be the number
     * of 0s, the answer is n−cnt.
     *
     * Otherwise, when 0 does not exist in the sequence,
     * there are two situations:
     *
     * When there exist two equal numbers in the sequence, the answer must be n.
     *
     * When all numbers in the sequence are distinct the answer must be n+1.
     */

    public int  getMinNumberOperations() {
        int min = sequence[0];
        int numberOfZero;

        if (min == 0) {
            numberOfZero = getFirstZeroNumbers(sequence);
            if (numberOfZero > 0) {
                return sequence.length - numberOfZero;
            }
        } else if (existElementDuplicated(sequence)) {
            return sequence.length;
        }
        return sequence.length + 1 ;
    }

    /**
     * get the number of zeros in a sorted sequence
     * @param seq
     * @return
     */

    private int getFirstZeroNumbers(int[] seq){
      int i=0 ;
      while(seq[i]==0){
          i++ ;
      }
      return i ;
    }

    /**
     * if there are duplicated elements in the sequence elements
     * @param seq
     * @return
     */
    private boolean existElementDuplicated(int[] seq ){
        for(int i=0;i< sequence.length-1;i++){
           if(sequence[i] == sequence[i+1]) return true   ;
        }
        return false ;
    }



}

class CodeForce{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int testNumber=scanner.nextInt();
        CodeForcesIteration(testNumber) ;

    }
    private static void   CodeForcesIteration(int testNumber) {
        int result ;
        ZeroSequence zeroSequence ;
        ArrayList<Integer> sequence = new ArrayList<>();

        /**
         * element to be read from the standard input
         */
        int element;

        for (int i = 0; i < testNumber; i++) {
            /**
             * read the sequence length
             */
            Scanner scanner = new Scanner(System.in);
            int sequenceLength = scanner.nextInt();
            /**
             *
             */
            for (int j = 0; j < sequenceLength; j++) {
                element = scanner.nextInt();
                sequence.add(element);
                sequence.clear() ;
            }
            int[] NativeSeq= new int[sequence.size()] ;
            for(int k =0; k<sequence.size();k++){
                NativeSeq[k]=sequence.get(k) ;
            }
            /**
             * instantiate objects
             */
            zeroSequence  = new ZeroSequence(NativeSeq) ;
            result = zeroSequence.getMinNumberOperations() ;
            System.out.println(result);
        }
    }
}
