import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;

public class TestApiJson {
    static JSONArray jsonArray;
   static JSONObject jsObject;
    @BeforeClass
    public static void beforeTest(){
        jsonArray= new JSONArray(RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json"));
        System.out.println(jsonArray);
        jsObject=jsonArray.getJSONObject(0);
        System.out.println(jsObject);
    }

    @Test
    public void test1(){
        Assert.assertNotNull("field \"rate\" is null",jsObject.get("rate"));
        System.out.println(jsObject.get("rate"));
    }


}
