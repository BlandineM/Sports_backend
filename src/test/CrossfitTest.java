package test;

import main.Sports.Crossfit;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CrossfitTest {

    @Test
    public void testTrue() throws Exception{
        String pattern = "dd-MM-yyyy HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date current = new Date();

        Crossfit test1 = new Crossfit(sdf.format(current),"WoodTest");
        System.out.println("Date " + test1.getDate() + "\nTitle " +test1.getTitle());

    }
}
