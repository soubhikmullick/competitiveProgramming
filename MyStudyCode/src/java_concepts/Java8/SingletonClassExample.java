package java_concepts.Java8;

class Singleton {
    private Singleton(){};
    private volatile static Singleton object;

    public Singleton getObject() {
        if(object == null) {
            synchronized(Singleton.class) {
                if (object == null)
                    this.object = new Singleton();
            };
        }
        return object;
    }
}

public class SingletonClassExample {
}
