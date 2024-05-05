public class Smartphone implements Mover {
    protected int price;
    protected String brand;

    public Smartphone(int price) {
        this.price = price;
    }

    public void phoneInfo() {
        System.out.println("-".repeat(25));
        System.out.println("Brand : " + this.brand);
        System.out.println("Price : " + this.price);
        System.out.println("-".repeat(25) + "\n");
    }

    @Override
    public void move() {
        System.out.println("Smartphone berpindah.\n");
    }
}

class Samsung extends Smartphone {
    public Samsung(int price) {
        super(price);
        this.brand = "Samsung";
    }
}