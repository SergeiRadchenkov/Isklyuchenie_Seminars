public class task5CustomArraySizeException extends RuntimeException {

    private  int length1;
    private  int length2;
    public int getLenth1() {return length1; }
    public int getLenth2() {return length2; }

    public task5CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}
