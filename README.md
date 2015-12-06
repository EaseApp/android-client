# android-client
Android/Java client for accessing the Ease API.

## Documentation

Java/Android client for accessing the Ease API.

Initializing Ease

Parameters:

The constructor takes three parameters:

`username`: Your username for the ease application. 
`appName`: The name of your application.
`appToken`: The API token for your application.

Example:
```
Ease ease = new Ease("username", "password", "apiToken");
```
## Save Method

Saves a JSON object to the application

Parameters:

The save method takes in 3 paramaters

`path`: The path for the data to be stored in.
`data`: A JsonNode object of the data to store. 
`callback`: A callback function that has failed, completed, and cancelled methods.

Example:
```
ease.save("/home", new JsonNode("{\"data\": \"data\"}"), new Callback<JsonNode>() {

    public void failed(UnirestException e) {
        System.out.println("The request has failed");
    }

    public void completed(HttpResponse<JsonNode> response) {
         int code = response.getStatus();
         Map<String, String> headers = response.getHeaders();
         JsonNode body = response.getBody();
         InputStream rawBody = response.getRawBody();
    }

    public void cancelled() {
        System.out.println("The request has been cancelled");
    }

});
```
## Read Method

Retrieves a JSON object from the application

Parameters:

The read method takes in 2 paramaters

`path`: The path for the data to be read from 
`callback`: A callback function that has failed, completed, and cancelled methods.

Example:
```
ease.read("/home", new Callback<JsonNode>() {

    public void failed(UnirestException e) {
        System.out.println("The request has failed");
    }

    public void completed(HttpResponse<JsonNode> response) {
         int code = response.getStatus();
         Map<String, String> headers = response.getHeaders();
         JsonNode body = response.getBody();
         InputStream rawBody = response.getRawBody();
    }

    public void cancelled() {
        System.out.println("The request has been cancelled");
    }

});
```
## Delete Method

Deletes a JSON object from the application

Parameters:

The delete method takes in 2 paramaters

`path`: The path for the data to be deleted from 
`callback`: A callback function that has failed, completed, and cancelled methods.

Example:
```
ease.delete("/home", new Callback<JsonNode>() {

    public void failed(UnirestException e) {
        System.out.println("The request has failed");
    }

    public void completed(HttpResponse<JsonNode> response) {
         int code = response.getStatus();
         Map<String, String> headers = response.getHeaders();
         JsonNode body = response.getBody();
         InputStream rawBody = response.getRawBody();
    }

    public void cancelled() {
        System.out.println("The request has been cancelled");
    }

});
```
