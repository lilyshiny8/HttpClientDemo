import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.params.CoreConnectionPNames;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class test1 {
    @Test
    public void testStatusCode() {
        given().
                get("https://www.baidu.com").
                then().
                statusCode(200);

    }


}
