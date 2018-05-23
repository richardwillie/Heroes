import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void Squad_instantiatesCorrectly_true() {
      Squad mySquad = new Squad("Mow the lawn");
      assertEquals(true, mySquadinstanceof Squad);
    }
  

}