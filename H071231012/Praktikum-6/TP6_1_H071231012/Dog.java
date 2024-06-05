package TP6_1_H071231012;

abstract class Dog implements Move {
    int position, averageLength;

    public Dog(int position, int averageLength) {
        this.position = position;
        this.averageLength = averageLength;
    }

    // public abstract void move();
    public abstract void describe();
}

class Pitbull extends Dog {
    public Pitbull(int position, int averageLength) {
        super(position, averageLength);

    }

    public void move() {
        position += 3;
        System.out.println("Pitbull berpindah sejauh " + position + " titik");
    }

    public void describe() {
        System.out.println("Salah satu jenis anjing di dunia yang sering disebut agresif serta berbahaya.");
    }
}

class SiberianHusky extends Dog {
    public SiberianHusky(int position, int averageLength) {
        super(position, averageLength);
    }

    public void move() {
        position += 2;
        System.out.println("Siberian Husky berpindah sejauh " + position + " titik");
    }

    public void describe() {
        System.out.println("Anjing husky memiliki ciri khas bulu tebal dengan perawakannya menyerupai serigala.");
    }
    
}

class Bulldog extends Dog {
    public Bulldog(int position, int averageLength) {
        super(position, averageLength);

    }

    public void move() {
        position += 1;
        System.out.println("Bulldog berpindah sejauh " + position + " titik");
    }

    public void describe() {
        System.out.println("Anjing bulldog memiliki ciri khas wajah ganas dan berkerut, tubuh gempal, dan kaki pendek.");
    }
}

class GermanShepherd extends Dog {
    public GermanShepherd(int position, int averageLength) {
        super(position, averageLength);
    }

    public void move() {
        position += 3;
        System.out.println("German Shepherd berpindah sejauh " + position + " titik");
    }

    public void describe() {
        System.out.println("Anjing ini berukuran besar, cerdas, dan penurut.");
    }
    
}

