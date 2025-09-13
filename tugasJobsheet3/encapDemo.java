package tugasJobsheet3;

public class encapDemo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge > 30) {
            age = 30;
        } 
        if (newAge < 18) {
            age = 18;
            System.out.println("Unur minimal adalah 18!");
        }
        else {
            age = newAge;
        }
    }
}
