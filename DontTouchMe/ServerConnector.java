import java.io.*;
import java.net.HttpURLConnection;
import java.net.*;
import org.json.*;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Write a description of class ServerConnector here.
 * 
 * @author Bunyarit
 * @version 0.0
 */
public class ServerConnector
{
    public static String id;
    public static String path = "http://10.4.38.181:3030/";
    public static void get() throws Exception {
     String url = path;
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
  
     for(int i = 0; i < myR.length() ; ++i){
         String temp = myR.getJSONObject(i).getString("id");
         if( !id.equals(temp) ){
             System.out.println("--------------------------------------------");
             int x = myR.getJSONObject(i).getJSONObject("location").getInt("x");
             int y = myR.getJSONObject(i).getJSONObject("location").getInt("y");
             int direction = myR.getJSONObject(i).getInt("direction");
             
             System.out.println("id         - "+ temp);
             System.out.println("name       - "+ myR.getJSONObject(i).getString("name"));
             System.out.println("location.x - "+ x);
             System.out.println("location.y - "+ y);
             MyWorld.player.setXY( x, y );
             System.out.println("direction  - "+ myR.getJSONObject(i).getInt("direction"));
             System.out.println("hp         - "+ myR.getJSONObject(i).getInt("hp"));
             System.out.println("maxHp      - "+ myR.getJSONObject(i).getInt("maxHp"));
             
             if( MyWorld.anotherPlayer[0] == null ){
                  MyWorld.anotherPlayer[0] = new Archer( myR.getJSONObject(i).getString("name"), x, y);
             }else{
                  MyWorld.anotherPlayer[0].setXY( x. y );
             }
             
             
         }
     }
    }
    public static void post(String value, Archer player) throws Exception{
        URL url = new URL(path);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);
        Map<String,String> arguments = new HashMap<>();
        id = value;
        arguments.put("id", value);
        arguments.put("name", player.getName()); // This is a fake password obviously
        arguments.put("x",  "" + player.getX());
        arguments.put("y", "" + player.getY());
        arguments.put("direction", "" + player.getDirect());
        arguments.put("hp", "" + player.getHp());
        arguments.put("maxHp", "" + player.getMaxHp());
        arguments.put("isDead", "false");
        arguments.put("started", "true");
        arguments.put("updatedTime", "" + new Date().getTime());
        arguments.put("currentFrame", "" + player.getAnimation().getCurrentFrame());
        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
                 + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
    }
    public static void put(String value, Archer player) throws Exception{
        URL url = new URL(path + id);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("PUT"); // PUT is another valid option
        http.setDoOutput(true);
        Map<String,String> arguments = new HashMap<>();
        arguments.put("id", value);
        arguments.put("name", player.getName()); // This is a fake password obviously
        arguments.put("x",  "" + player.getX());
        arguments.put("y", "" + player.getY());
        arguments.put("direction", "" + player.getDirect());
        arguments.put("hp", "" + player.getHp());
        arguments.put("maxHp", "" + player.getMaxHp());
        arguments.put("isDead", "" + player.isDead());
        arguments.put("started", "true");
        arguments.put("updatedTime", "" + new Date().getTime());
        arguments.put("currentFrame", "" + player.getAnimation().getCurrentFrame());
        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
                 + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
    }
}
