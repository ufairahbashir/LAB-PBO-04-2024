public class TP2_1_H071231060 {
    private String name;
    private int age;
    String gender;
    private boolean isMale;

    public void setName ( String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge ( int age ){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setIsMale(boolean isMale){
        this.isMale = isMale;
    }
    public boolean getIsMale(){
        return isMale;
    }
    public String getGender(){
        if (isMale){
            return "Male";
        } else {
            return "Female";
        }
    }
    
    public static void main(String[] args) {
        TP2_1_H071231060 Orang = new TP2_1_H071231060();
        Orang.setName("Roby");
        Orang.setAge(19);
        Orang.setIsMale(true);
        System.out.println("Name : "+ Orang.getName());
        System.out.println( "Age : "+ Orang.getAge()  );
        System.out.println("Gender : "+ Orang.getGender());
    }
}