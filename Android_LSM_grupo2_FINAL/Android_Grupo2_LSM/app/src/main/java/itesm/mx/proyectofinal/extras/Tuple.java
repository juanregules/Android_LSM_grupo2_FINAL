package itesm.mx.proyectofinal.extras;

public class Tuple<A, B> {

    A a;
    B b;

    public Tuple(A a, B b){
        this.a = a;
        this.b = b;
    }

    public A getFirst(){
        return a;
    }

    public B getSecond(){
        return b;
    }
}
