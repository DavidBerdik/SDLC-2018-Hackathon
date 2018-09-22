package hackathon.sdlc.cognitive;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class APIRequest {

	private static HttpClient client = HttpClients.createDefault();
	
	public static String makeRequest(String imageURL) {
		// Build a new URI API connection link.
		URIBuilder builder;
		try {
			builder = new URIBuilder("https://eastus.api.cognitive.microsoft.com/vision/v1.0/ocr");
		} catch (URISyntaxException e) {
			System.out.println("APIRequest::makeRequest -> URISyntaxExceltion");
			return null;
		}
		
		// Construct our HTTP request in JSON format.
		HttpPost request;
		try {
			request = new HttpPost(builder.build());
		} catch (URISyntaxException e) {
			System.out.println("APIRequest::makeRequest -> URISyntaxExceltion");
			return null;
		}
		
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Ocp-Apim-Subscription-Key", "3d5bc87115a94cb4a8aa3a06da9ee1e5");
        
        // Add a particular image to the HTTP Request.
        try {
			request.setEntity(new StringEntity("{\"url\":\"" + imageURL + "\"}"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("APIRequest::makeRequest -> UnsupportedEncodingException");
			return null;
		}
                
        // Execute the request to our URI link.
        HttpEntity entity;
		try {
			entity = client.execute(request).getEntity();
		} catch (ClientProtocolException e) {
			System.out.println("APIRequest::makeRequest -> ClientProtocolException");
			return null;
		} catch (IOException e) {
			System.out.println("APIRequest::makeRequest -> IOException");
			return null;
		}
        
		// Return a null String if we got no data from the connection.
        if (entity == null)
        	return null;
		
        // Check to validate our results and return it if applicable.
		try {
			return EntityUtils.toString(entity);
		} catch (ParseException e) {
			System.out.println("APIRequest::makeRequest -> ParseException");
			return null;
		} catch (IOException e) {
			System.out.println("APIRequest::makeRequest -> IOException");
			return null;
		}
	}

}