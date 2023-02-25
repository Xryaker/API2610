import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.rickandmorty.Haracters;
import models.rickandmorty.Result;
import org.junit.BeforeClass;
import org.junit.Test;

import static rest.RestGet.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestRickAndMortyModels {
    static String url="https://rickandmortyapi.com/api/";
    static Haracters haracters;

    @BeforeClass
    public static void b() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        haracters=om.readValue(Get(url+"character"), Haracters.class);
    }
    @Test
    public void test1(){
        assertNotNull("haracters info next = null",haracters.info.next);
        System.out.println(haracters.info.next);
    }
    @Test
    public void test2(){
        assertTrue(String.valueOf(haracters.info.count),haracters.info.count>700);
        System.out.println(haracters.info.count);
    }
    @Test
    public void test3(){
        assertEquals("",haracters.results.get(0).name);
    }
    @Test
    public void gtest4(){
        for(Result l:haracters.results){
            assertNotNull(l.name);
        }
    }
    @Test
    public void test6() throws Exception {

        for (Result l: haracters.results){
            for(String ll:l.episode){
                System.out.println(ll);
                if(!ll.contains(url)){
                    throw new Exception("in episodes not conta...");
                }

            }
        }
    }
    @Test
    public void test7(){
        for (Result l: haracters.results){
            for(String ll:l.episode){
                assertEquals(200,getStatuCode(ll));
                System.out.println(ll+" = "+getStatuCode(ll));
            }
        }
    }
}
//Вывести имена всех персонажей мультфильма Рик и Морти по ссылке на АПИ
//
//"https://rickandmortyapi.com/api/character".
//
//1. если поле "next" not null запросить след. страничку используя ссылку этого поля
//
//2 Вывести такие поля например:
//
//"name": "Rick Sanchez",