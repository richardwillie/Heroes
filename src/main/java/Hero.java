import java.util.*;
public class Hero {
    private String mName;
    private String mAge;
    private String mPower;
    private String mWeakness;
    private String mSquad;
    private static List<Hero> instances = new ArrayList<Hero>();

    public Hero(String name, String age, String power, String weakness, String squad) {
        mName = name;
        mAge = age;
        mPower = power;
        mWeakness = weakness;
        mSquad = squad;
        instances.add(this);
    }

    public String getName() {
        return mName;
    }

    public String getAge() {
        return mAge;
    }

    public String getPower() {
        return mPower;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public static List<Hero> all(){
        return instances;
    }

    public String getSquad() {
        return mSquad;
    }
}

