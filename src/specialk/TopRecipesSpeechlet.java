package specialk;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Card;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;

public class TopRecipesSpeechlet implements Speechlet{
	//only uncomment once the following class passes unit test
//	private static final String WEBSOURCE = "https://www.specialk.com/en_US/recipes.html";
//	RequestRecipes recipes = new RequestRecipes(WEBSOURCE);
	private static final Logger log = LoggerFactory.getLogger(TopRecipesSpeechlet.class);
	
	private static Recipes recipes = new TextRecipes();
	
	@Override
	public SpeechletResponse onIntent(final IntentRequest request, final Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
		
		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;
		
		if ("GetTopRecipes".equals(intentName)) {
            return getTopRecipesResponse();
        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            return getHelpResponse();
        } else {
            throw new SpeechletException("Invalid Intent");
        }

	}

	private SpeechletResponse getTopRecipesResponse() {
		// TODO add logic to send recipes
		return getCardResponse();
	}

	private SpeechletResponse getHelpResponse() {
		// TODO change to another help message instead of this default
		return getWelcomeResponse();
	}

	@Override
	public SpeechletResponse onLaunch(final LaunchRequest request, final Session session) throws SpeechletException {

		log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
		
		return getWelcomeResponse();
	}

	@Override
	public void onSessionEnded(final SessionEndedRequest request, final Session session) throws SpeechletException {
		log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        // any cleanup logic goes here
		
	}

	@Override
	public void onSessionStarted(final SessionStartedRequest request, final Session session) throws SpeechletException {
		log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        // any initialization logic goes here
		
	}
	
	/*****************
	 * Helper methods
	 *****************/
	

	private SpeechletResponse getWelcomeResponse() {
		String speechText = "Welcome to the Alexa Special K app. " +
							"You can ask me to send you recipe ideas " +
							"by saying, send me recipe ideas";
		
		String repromptText = "I can send you recipe ideas if you say" +
							" send me recipes ideas";
		

        // Create the plain text output.
        PlainTextOutputSpeech welcomeSpeech = new PlainTextOutputSpeech();
        welcomeSpeech.setText(speechText);
        
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        welcomeSpeech.setText(repromptText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(welcomeSpeech, reprompt);
    }
	
	private SpeechletResponse getCardResponse() {
	      
	   // Create the Simple card content.
	     Card card = recipes.sendRandomRecipe(); 
	     
	  // Create the plain text output.
	     String speechText = "Sending recipe ideas. Check the phone app for details."; 
	     PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
	     speech.setText(speechText);
		
		return SpeechletResponse.newTellResponse(speech, card);
	}

}


