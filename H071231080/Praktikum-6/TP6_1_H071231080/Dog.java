public abstract class Dog implements Move {
    int position;
    int averageLength;

    public Dog(int position, int averageLength) {
        this.position = position;
        this.averageLength = averageLength;
    }

    public abstract void describe();
}

class Pitbull extends Dog {

    public Pitbull(int position, int averageLength) {
        super(position, averageLength);
    }

    public void move() {
        position += 3;
        System.out.println("Pitbull bergeser " + position);
    }

    public void describe() {
        System.out.println("Anjing yang keras kepala");
    }
}

class SiberianHusky extends Dog {

    public SiberianHusky(int position, int averageLength) {
        super(position, averageLength);
    }

    public void move() {
        position += 2;
        System.out.println("Siberian Husky bergeser " + position);
    }

    public void describe() {
        System.out.println("Telinga Ciri ciri anjing siberian husky selanjutnya adalah dilihat dari bentuk telinga.");
    }
}

class Bulldog extends Dog {

    public Bulldog(int position, int averageLength) {
        super(position, averageLength);
    }

    public void move() {
        position += 1;
        System.out.println("Bulldog bergeser " + position);
    }

    public void describe() {
        System.out.println("Memiliki tubuh lebar dan besar. Memiliki moncong yang pesek. ");
    }
}

class GermanShepherd extends Dog {

    public GermanShepherd(int position, int averageLength) {
        super(position, averageLength);
    }

    public void move() {
        position += 3;
        System.out.println("German Shepherd bergeser " + position);
    }

    public void describe() {
        System.out.println(
                "Bentuk tubuh yang proporsional dan agak memanjang. Memiliki otot serta struktur tulang yang solid.");
    }
}