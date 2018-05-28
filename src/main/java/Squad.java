public class Squad {
    private String Name;
    private String Cause;
    private int Size;

  
    public Squad(String name,String cause, int size) {
      Name = name;
      Cause = cause;
      Size = size;

    }
  
    public String getName() {
      return Name;
    }
    public String getCause() {
        return Cause;
      }
      public int getSize() {
        return Size;
      }
  }