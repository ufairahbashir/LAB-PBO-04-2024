public abstract class Dog extends Audio implements Mover {
    protected String name, barkingFile;
    protected int position, averageLength;

    public Dog(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void getPosition() {
        System.out.println(this.name + " sedang berada di posisi " + this.position + ".\n");
    }

    public abstract void describe();

    public void barking() {
        System.out.println(this.name + " menggonggong...\n");
        playAudio(barkingFile);
    }
}

class Pitbull extends Dog {
    public Pitbull(String name, int position) {
        super(name, position);
        this.averageLength = 49;
        this.barkingFile = "BarkingSound/PitbullBark.wav";
    }

    @Override
    public void move() { // +3 position
        System.out.println(super.name + " bergerak sebanyak 3 satuan ke kanan.\n");
        super.position += 3;
    }

    @Override
    public void describe() {
        System.out.println("-".repeat(80));
        System.out.println(
                super.name + " merupakan anjing berjenis Pitbull.\n" +
                "Ciri-cirinya adalah bertubuh atletis, kepala lebar,\n" +
                "berbulu pendek atau sedang dengan berbagai warna, serta\n" +
                "panjang rata-rata anjing Pitbull adalah " + super.averageLength + " cm. Pitbull\n" +
                "dikenal karena kesetiaan dan keberaniannya terhadap pemiliknya."
        );
        System.out.println("-".repeat(80) + "\n");
    }
}

class SiberianHusky extends Dog {
    public SiberianHusky(String name, int position) {
        super(name, position);
        this.averageLength = 55;
        this.barkingFile = "BarkingSound/HuskyBark.wav";
    }

    @Override
    public void move() {
        System.out.println(super.name + " bergerak sebanyak 2 satuan ke kanan.\n");
        super.position += 2;
    }

    @Override
    public void describe() {
        System.out.println("-".repeat(80));
        System.out.println(
                super.name + " merupakan anjing berjenis Siberian Husky.\n" +
                "Ciri-cirinya adalah berbulu tebal dengan berbagai warna,\n" +
                "telinga tegak, warna matanya rata-rata berwarna biru, serta\n" +
                "panjang rata-rata anjing Siberian Husky adalah " + super.averageLength + " cm. Siberian\n" +
                "Husky dikenal karena hiperaktif dan seringkali melakukan drama\n" +
                "terhadap manusia, sesama anjing, maupun hewan jenis lainnya."
        );
        System.out.println("-".repeat(80) + "\n");
    }
}

class Bulldog extends Dog {
    public Bulldog(String name, int position) {
        super(name, position);
        this.averageLength = 36;
        this.barkingFile = "BarkingSound/BulldogBark.wav";
    }

    @Override
    public void move() {
        System.out.println(super.name + " bergerak 1 satuan ke kanan.\n");
        super.position += 1;
    }

    @Override
    public void describe() {
        System.out.println("-".repeat(80));
        System.out.println(
                super.name + " merupakan anjing berjenis Bulldog.\n" +
                "Ciri-cirinya adalah berbulu pendek dengan berbagai warna,\n" +
                "telinga melengkung, hidungnya pesek, terdapat lipatan pada wajah,\n" +
                "serta panjang rata-rata anjing Bulldog adalah " + super.averageLength + " cm. Bulldog dikenal\n" +
                "karena cenderung kurang aktif, suka menggonggong, ramah, dan penyayang."
        );
        System.err.println("-".repeat(80) + "\n");
    }
}

class GermanShepherd extends Dog {
    public GermanShepherd(String name, int position) {
        super(name, position);
        this.averageLength = 60;
        this.barkingFile = "BarkingSound/GermanShepherdBark.wav";
    }

    @Override
    public void move() {
        System.out.println(super.name + " bergerak 3 satuan ke kanan.\n");
        super.position += 3;
    }

    @Override
    public void describe() {
        System.out.println("-".repeat(80));
        System.out.println(
                super.name + " merupakan anjing berjenis German Shepherd.\n" +
                "Ciri-cirinya adalah berbulu ganda yang tebal dengan warna\n" +
                "cenderung hitam dan coklat, telinga berdiri, kepala tegak,\n" +
                "serta panjang rata-rata anjing German Shepherd adalah " + super.averageLength + " cm.\n" +
                "German Shepherd dikenal karena berani, cerdas, serta setia."
        );
        System.out.println("-".repeat(80) + "\n");
    }
}