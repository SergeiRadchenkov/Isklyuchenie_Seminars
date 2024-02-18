public class Cat extends Animal {
    private Cat(String name) {
        super(name);
    }

    /**
     * Фабричный метод для создания объекта
     * @param name имя котика
     * @return котик
     * @throws AnimalNameException некорректное имя котика
     */
    public static Cat create(String name) throws AnimalNameException {
        if (name == null || name.length() < 3) {
            throw new AnimalNameException("Некорректное имя котика", name);
        }
        return new Cat(name);
    }

    @Override
    void swim(int distance) throws AnimalSwimException {
        throw new AnimalSwimException("Кот не умеет плавать", name, distance);
    }

    @Override
    void run(int distance) throws AnimalRunException {
        if (distance < 60) {
            
        } else {
            throw new AnimalRunException("Котику тяжело бежать", name, distance);
        }
    }
}
