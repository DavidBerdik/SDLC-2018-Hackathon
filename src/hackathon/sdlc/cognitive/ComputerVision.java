package hackathon.sdlc.cognitive;

public class ComputerVision {

	public static void printedConversion(String imageURL) {
		String json = APIRequest.makeRequest(imageURL);
	}
	
}

