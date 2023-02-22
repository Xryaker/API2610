import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.exchanges.Exchange;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;

public class TestAoiWithModel {
    static Exchange[] exchange;
    static Exchange ex1;
    @BeforeClass
    public static void bb() throws JsonProcessingException {
        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json");
        ObjectMapper om = new ObjectMapper();
        exchange= om.readValue(response, Exchange[].class);
        ex1=exchange[0];
    }

    @Test
    public void tets1(){
        Assert.assertNotNull(ex1.getRate());
        System.out.println(ex1.getRate());
    }

}
