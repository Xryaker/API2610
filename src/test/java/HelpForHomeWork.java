import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.exchanges.Exchange;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;

public class HelpForHomeWork {

    static Exchange[] exchangesMass;
    @BeforeClass
    public static void b() throws JsonProcessingException {
        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
        ObjectMapper om = new ObjectMapper();
        exchangesMass= om.readValue(response, Exchange[].class);
    }
    @Test
    public void test1(){
        for (Exchange mass : exchangesMass) {
            System.out.println(mass.cc);
        }

    }
}
