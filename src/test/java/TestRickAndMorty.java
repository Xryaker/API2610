import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static rest.RestGet.Get;
import static org.junit.Assert.*;

public class TestRickAndMorty {
    static String mainUrl = "https://rickandmortyapi.com/api/";
    static JSONObject rickAndMortyJson;

    @BeforeClass
    public static void b() {
        rickAndMortyJson = new JSONObject(Get(mainUrl + "character"));
    }

    @Test
    public void test1() {
        String result;
        result = rickAndMortyJson.getJSONObject("info").get("next").toString();
        System.out.println(result);
    }

    @Test
    public void test2() {
        String result;
        JSONObject infoJson;
        infoJson = rickAndMortyJson.getJSONObject("info");
        result = infoJson.get("count").toString();
        System.out.println(result);
    }

    @Test
    public void test11() {
        assertNotNull(rickAndMortyJson.getJSONObject("info").get("next"));
    }

    @Test
    public void test3() {
        System.out.println(rickAndMortyJson.getJSONArray("results").getJSONObject(0).get("name"));
    }

    @Test
    public void test31() {
        String name;
        JSONArray jsonArray;
        JSONObject haracter;
        jsonArray = rickAndMortyJson.getJSONArray("results");
        haracter = jsonArray.getJSONObject(0);
        name = haracter.get("name").toString();
        System.out.println(name);
    }

    @Test
    public void test311() {
        int id;
        JSONArray jsonArray;
        JSONObject haracter;
        jsonArray = rickAndMortyJson.getJSONArray("results");
        haracter = jsonArray.getJSONObject(0);
        id = haracter.getInt("id");
        System.out.println(id + 10);
    }

    @Test
    public void test4() {
        System.out.println(rickAndMortyJson.getJSONArray("results").getJSONObject(0).getJSONObject("origin").get("name"));
    }

    @Test
    public void test5() {
        JSONArray jsonArray = rickAndMortyJson.getJSONArray("results").getJSONObject(0).getJSONArray("episode");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            stringList.add(jsonArray.get(i).toString());
        }
        System.out.println(stringList);
    }


}
