

public class TP2_1_H071231080 {
        String name;
        int age;
        boolean isMale;
    
        // Setter dan getter untuk atribut name
        public void setName(String name) { 
            this.name = name;
        }
        public String getName() {
            return name;
        }
    
        // Setter dan getter untuk atribut age
        public void setAge(int age) {
            this.age = age;
        }
        public int getAge() {
            return age;
        }
    
        // Setter dan getter untuk atribut isMale
        public void setGender(boolean isMale) {
            this.isMale = isMale;
        }
        public String getGender() {
            if (isMale) {
                return "Male";
            } else {
                return "Female";
            }
        }
    
        public static void main(String[] args) {
            TP2_1_H071231080 input = new TP2_1_H071231080();
    
            input.setName("Nur Fadillah");
            input.setAge(19);
            input.setGender(false); 

            System.out.println("Name: " + input.getName());
            System.out.println("Age: " + input.getAge());
            System.out.println("Gender: " + input.getGender());
        }
    }

    