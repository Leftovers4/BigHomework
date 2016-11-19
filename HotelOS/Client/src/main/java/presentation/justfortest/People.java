package presentation.justfortest;

/**
 * Created by Hitiger on 2016/11/19.
 * Description :
 */
public class People {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
}
