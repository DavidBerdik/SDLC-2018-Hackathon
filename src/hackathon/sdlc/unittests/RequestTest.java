package hackathon.sdlc.unittests;

import hackathon.sdlc.cognitive.APIRequest;

public class RequestTest {

	public RequestTest() {
		System.out.println("Beginning API/JSON unit test.");
		
		String raw_printed = APIRequest.makeRequest("https://i.imgur.com/FHZhjzq.jpg");
		System.out.println("[RAW] PRINTED REQUEST: \n" + raw_printed);
		
		String raw_handwritten = APIRequest.makeRequest("https://i.imgur.com/To1ZhKV.jpg");
		System.out.println("[RAW] HANDWRITTEN REQUEST: \n" + raw_handwritten);
		
		System.out.println("Finishing API/JSON unit test.");
	}
	
}