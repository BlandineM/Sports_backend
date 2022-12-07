package test;

import main.User;
import org.junit.Test;


public class UserTest {

    @Test
    public void testTrue() throws Exception{
        User test1 = new User("TotoName", "TotoSurname", "TotoEmmail");
        System.out.println("1.Name " + test1.getName() + "\nSurname " +test1.getSurname() + "\nEmail " + test1.getEmail());
        test1.setName("TitiName");
        test1.setSurname("TitiSurnaame");
        test1.setEmail("TitiEmail");
        System.out.println("2.Name " + test1.getName() + "\nSurname " +test1.getSurname() + "\nEmail " + test1.getEmail());
    }
}
