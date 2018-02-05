import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

/**
 * Write a description of class ServerConnector here.
 * 
 * @author Bunyarit
 * @version 0.0
 */
public class ServerConnector  
{
  
    public static void get() throws Exception {
     String url = "http://localhost:3030";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     //Read JSON response and print
     JSONObject myResponse = new JSONObject(response.toString());
     JSONArray myR = myResponse.getJSONArray("player");
     System.out.println("result after Reading JSON Response");
     for(int i = 0; i < 2; ++i){
         System.out.println("--------------------------------------------");
         System.out.println("id         - "+ myR.getJSONObject(i).getString("id"));
         System.out.println("name       - "+ myR.getJSONObject(i).getString("name"));
         System.out.println("location.x - "+ myR.getJSONObject(i).getJSONObject("location").getInt("x"));
         System.out.println("location.y - "+ myR.getJSONObject(i).getJSONObject("location").getInt("y"));
         System.out.println("direction  - "+ myR.getJSONObject(i).getInt("direction"));
         System.out.println("hp         - "+ myR.getJSONObject(i).getInt("hp"));
         System.out.println("maxHp      - "+ myR.getJSONObject(i).getInt("maxHp"));
         
     }
     
     
   }
}
