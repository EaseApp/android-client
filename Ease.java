import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import java.util.concurrent.Future;

public class Ease {

    String username;
    String appName;
    String appToken;
    String baseUrl = "api.easeapp.co";

    public Ease(String username, String appName, String appToken){
        this.username = username;
        this.appName = appName;
        this.appToken = appToken;
    }

    private Future<HttpResponse<JsonNode>> sendRequest(String url, String type, String path, JsonNode dataToSend, Callback<JsonNode> callback){
        try {
            if(type.equals("GET")) {
                return Unirest.get(url)
                        .header("Content-Type", "application/json; charset=utf-8;")
                        .header("Authorization", this.appToken)
                        .asJsonAsync(callback);            }
            else{
                return Unirest.post(url)
                        .header("Content-Type", "application/json; charset=utf-8;")
                        .header("Authorization", this.appToken)
                        .queryString("path",path)
                        .body(dataToSend)
                        .asJsonAsync(callback);
            }
        }
        catch(Exception e){
            return null;
        }
    }

    public Future<HttpResponse<JsonNode>> save(String path, JsonNode data, Callback<JsonNode> callback){
        String pathString = "'path' : " + path;
        String dataString = "'data' : " + data.toString();
        String url = "http://"+this.baseUrl+"/data/"+this.username+"/"+this.appName;
        JsonNode node = new JsonNode("{"+pathString+","+dataString+"}");
        return sendRequest(url,"POST", path, node, callback);
    }

    public Future<HttpResponse<JsonNode>> read(String path, Callback<JsonNode> callback){
        String pathString = "'path' : " + path;
        String url = "http://"+this.baseUrl+"/data/"+this.username+"/"+this.appName;
        JsonNode node = new JsonNode("{"+pathString+"}");
        return sendRequest(url,"GET", path, node, callback);
    }

    public Future<HttpResponse<JsonNode>> delete(String path, Callback<JsonNode> callback){
        String pathString = "'path' : " + path;
        String url = "http://"+this.baseUrl+"/data/"+this.username+"/"+this.appName;
        JsonNode node = new JsonNode("{"+pathString+"}");
        return sendRequest(url,"DELETE", path, node, callback);
    }

}

