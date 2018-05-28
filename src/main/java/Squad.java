import java.util.ArrayList;

import java.util.List;


public class Squad {
    private String mName;
    private String mCause;
    private int mSize;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int mId;
    private List<Hero> heroes;

  
    public Squad(String name,String cause, int size) {
      mName = name;
      mCause = cause;
      mSize = size;
      instances.add(this);
      mId = instances.size();
      heroes = new ArrayList<Hero>();
    }
  
    public String getName() {
      return mName;
    }

    public List<Hero> getHeroes() {
      return heroes;
   }

    public String getCause() {
        return mCause;
      }
      public int getSize() {
        return mSize;
      }

      public int getId() {
        return mId;
      }
    public static List<Squad> all(){
      return instances;
    }

    public static Squad find(int id) {
      return instances.get(id - 1);
    }
    public static void clear(){
      instances.clear();
    }  
    public void addHero(Hero newHero){
      heroes.add(newHero);      
   }
  }