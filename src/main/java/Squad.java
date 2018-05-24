public class Squad {
    private String squadName;
    private String squadCause;
    private int squadSize;

  
    public Squad(String name,String cause, int size) {
      squadName = name;
      squadCause = cause;
      squadSize = size;

    }
  
    public String getName() {
      return squadName;
    }
    public String getCause() {
        return squadCause;
      }
      public int getSize() {
        return squadSize;
      }
  }