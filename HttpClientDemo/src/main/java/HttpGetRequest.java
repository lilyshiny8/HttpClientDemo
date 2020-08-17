import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Scanner;

public class HttpGetRequest {
    @Test
    public void GetTest() throws IOException {
        //create a httpclient object
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //creat a httpget object
        HttpGet httpget = new HttpGet("http://www.tutorialspoint.com/");
        //execute the get request
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

    }
}
