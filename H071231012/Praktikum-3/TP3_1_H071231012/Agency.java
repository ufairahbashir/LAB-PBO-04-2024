public class Agency{
    String name;
    String group;
    int member;
    Type type;

    public Agency(String name,String group){
        this.name = name;
        this.group = group;
        this.member = 0;
    }

    public Agency (String name, String group, int member){
        this.name = name;
        this.group = group;
        this.member = member;
    }

    public void addMember(){
        this.member++;
    }

    public void setType( Type type){
        this.type = type;
    }

    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
    }

    public String getgroup(){
        return group;
    }

    public void setgroup(String group){
        this.group = group;
    }

    public int getmember(){
        return member;
    }

    public Type getType(){
        return type;
    }

    public static void main(String[] args) {
        Agency Agency1 = new Agency("SM Entertaiment", "NCT", 26);
        Agency1.addMember();

        Agency Agency2 = new Agency ("HYBE", "Le Sserafim", 4);
        Agency2.addMember();

        Type type1 = new Type ("BoyGrup","GirlGrup");
        Agency1.setType(type1);

        Type type2 = new Type ("BoyGrup", "GirlGrup");
        Agency2.setType(type2);

        System.out.println("======== Agency Data ========");
        System.out.println("Name Agency      : " + Agency1.getname());
        System.out.println("Name Group       : " + Agency1.getgroup());
        System.out.println("Member         : " + Agency1.getmember());
        Agency1.getType().printAgencyType(Agency1.getname());
        System.out.println("==============================");
        System.out.println("Name Agency      : " + Agency2.getname());
        System.out.println("Name Group       : " + Agency2.getgroup());
        System.out.println("Member         : " + Agency2.getmember());
        Agency2.getType().printAgencyType(Agency2.getname());
        System.out.println("==============================");
    }
}

class Type{
    String boy;
    String girl;

    public Type(String boy, String girl){
        this.boy = boy;
        this.girl = girl;
    }

    public String getBoy(){
        return boy;
    }

    public String getGirl(){
        return girl;
    }

    public void printAgencyType(String AgencyName){
    if(AgencyName.equals("SM Entertaiment")){
        System.out.println("The group is a " + boy);
    }else{
        System.out.println("The group is a " + girl);
    }
}
}