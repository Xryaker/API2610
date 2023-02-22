import org.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;

public class HelpForHomeWork2 {
    static JSONArray jsonArray;
    @BeforeClass
    public static void b(){
        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
        jsonArray=new JSONArray(response);
    }
    @Test
    public void test1(){
        for(int i=0;i< jsonArray.length();i++){
            System.out.println(jsonArray.getJSONObject(i).get("cc"));
        }
    }
}
