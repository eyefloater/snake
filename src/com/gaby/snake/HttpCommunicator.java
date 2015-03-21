package com.gaby.snake;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
 
public class HttpCommunicator {
	
	private String password;
	private String user;
 
    private final String USER_AGENT = "Mozilla/5.0";
    private final String url = "http://localhost:8080/SnakeHttpServer/";
    private HttpClient client = HttpClientBuilder.create().build();
    private String cookies;
 
    public int get(String action) {
    
        try {
            HttpGet request = new HttpGet(url+action);
 
            request.setHeader("User-Agent", USER_AGENT);
            request.setHeader("Accept",
                    "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            request.setHeader("Accept-Language", "en-US,en;q=0.5");
 
            HttpResponse response = client.execute(request);
            int responseCode = response.getStatusLine().getStatusCode();
 
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
 
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
 
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Header cookie = response.getFirstHeader("Set-Cookie");
            Header[] headers = response.getAllHeaders();
            // set cookies
            setCookies(response.getFirstHeader("Set-Cookie") == null ? ""
                    : response.getFirstHeader("Set-Cookie").toString());
 
            return responseCode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
 
    public String post(String username, String password) {
        try {
            HttpPost post = new HttpPost(url+"/login");
 
            // add header
            post.setHeader("User-Agent", USER_AGENT);
 
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("username", username));
            urlParameters.add(new BasicNameValuePair("password", password));
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
 
            HttpResponse response = client.execute(post);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
 
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
 
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
 
   
    public String getCookies() {
        return cookies;
    }
 
    public void setCookies(String cookies) {
        this.cookies = cookies;

    }
 
}
