package Livecode;
import Move.Moveable;

abstract class Dog implements Moveable{
    int position;
    int averageLength;

    public Dog(int position, int averageLength) {
        this.position = position;
        this.averageLength = averageLength;
    }

    //Abstarct method
    void describe() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(int averageLength) {
        this.averageLength = averageLength;
    }
}

class Pitbull extends Dog {
    public Pitbull(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    void describe()  {
        System.out.println("Deskripsi : Pitbull adalah anjing yang berotot, berukuran sedang, \ndengan tubuh yang kokoh dan mantel pendek. Mereka dikenal \nkarena kecerdasan, loyalitas, dan keberanian mereka.");
        System.out.println("Panjang rata rata Pitbull : " + getAverageLength());
    }

    @Override
    public void move() {
        position += 3;
        System.out.println("Pitbull berpindah, posisi saat ini : " + getPosition());
    }
}

class SiberianHusky extends Dog {
    public SiberianHusky(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    void describe() {
        System.out.println("Siberian Husky adalah anjing pekerja berukuran sedang dengan \nbulu tebal ganda dan penampilan mirip serigala. Mereka adalah \nanjing yang aktif, cerdas, dan ramah.");
        System.out.println("Panjang rata rata Siberian Husky: " + getAverageLength());
    }

    @Override
    public void move() {
        position += 1;
        System.out.println("Siberian Husky berpindah, posisi saat ini : " + getPosition());
    }
}

class Bulldog extends Dog {
    public Bulldog(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    void describe() {
        System.out.println("Bulldog adalah anjing berukuran sedang dengan wajah keriput dan \nhidung pesek yang khas. Mereka memiliki tubuh yang kompak dan \nkuat. Meskipun terlihat kasar, bulldog adalah anjing yang ramah, \ntenang, dan setia.");
        System.out.println("Panjang rata rata Bulldog : " + getAverageLength());
    }

    @Override
    public void move() {
        position += 2;
        System.out.println("Bulldog berpindah, posisi saat ini : " + getPosition());
    }
}

class GermanShepherd extends Dog {
    public GermanShepherd(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    void describe() {
        System.out.println("German Shepherd adalah anjing berukuran besar yang dikenal \nkarena kecerdasan, keberanian, dan kesetiaannya serta memiliki \nnaluri melindungi yang kuat terhadap keluarga dan lingkungan mereka.");
        System.out.println("Panjang rata rata German Shepherd : " + getAverageLength());
    }

    @Override
    public void move() {
        position += 3;
        System.out.println("German Shepherd berpindah, posisi saat ini : " + getPosition());
    }
}