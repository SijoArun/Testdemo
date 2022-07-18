package api;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import pojo.dummyjson;


public class getapi {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	    String URL="https://dummyjson.com/products/1";
		//String response=given().header("Content-Type","application/json").log().all().when().get(URL).then().log().all()
		//.statusCode(200).body("brand",equalTo("Apple")).extract().response().asString();
		//jsopath response1=given().header("Content-Type","application/json").log().all().when().get(URL).as(dummyjson.class);
		
		dummyjson gc=(dummyjson) given().expect().defaultParser(Parser.JSON).when().get(URL).as(dummyjson.class);
	  
	    //JsonPath ps=new JsonPath(response);
		//String placeid=ps.getString("brand");
        //System.out.println(js.getId());
		
	}

}