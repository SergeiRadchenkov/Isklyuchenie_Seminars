public abstract class task1CustomArrayException extends Exception {
    private int x;
    private int y;

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public task1CustomArrayException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }
}
