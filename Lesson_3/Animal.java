public abstract class Animal {
    protected final String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void swim(int distance) throws AnimalSwimException;
    abstract void run(int distance) throws AnimalRunException;
}
