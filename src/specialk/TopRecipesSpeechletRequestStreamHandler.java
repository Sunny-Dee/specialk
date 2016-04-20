package specialk;

import java.util.*;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public class TopRecipesSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
	private static final Set<String> supportedApplicationIds = new HashSet<String>();
	
	static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.ce6bf435-908b-4b6d-a8d4-be0ee07d91af");
    }
	
	public TopRecipesSpeechletRequestStreamHandler() {
		super(new TopRecipesSpeechlet(), supportedApplicationIds);
	}

}
