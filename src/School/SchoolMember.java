package School;

public class SchoolMember {
    protected final String SchoolName="二一大學";
    protected String name;
    protected int age;
    protected String gender;

    public SchoolMember(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getDesc(){
        String desc="SchoolMember{" +
                "SchoolName='" + SchoolName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
        return desc;


    }

    @Override
    public String toString() {
        return "SchoolMember{" +
                "SchoolName='" + SchoolName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
