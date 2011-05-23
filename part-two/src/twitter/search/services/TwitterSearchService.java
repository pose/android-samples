package twitter.search.services;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import twitter.search.model.api.Tweet;
import twitter.search.model.impl.TweetImpl;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

public class TwitterSearchService extends IntentService {

	private final String TAG = getClass().getSimpleName();

	public static final String GET_TWEETS_CMD = "GetTweets";

	public static final int STATUS_CONNECTION_ERROR = -1;
	public static final int STATUS_ERROR = -2;
	public static final int STATUS_ILLEGAL_ARGUMENT = -3;
	public static final int STATUS_OK = 0;

	/*
	 * Se debe crear un constructor sin parámetros y asignarle un nombre al
	 * servicio.
	 */
	public TwitterSearchService() {
		super("TwitterSearchService");
	}

	/*
	 * Evento que se ejecuta cuando se invocó el servicio por medio de un
	 * Intent.
	 */
	@Override
	protected void onHandleIntent(final Intent intent) {
		final ResultReceiver receiver = intent.getParcelableExtra("receiver");
		final String command = intent.getStringExtra("command");

		final Bundle b = new Bundle();
		try {
			if (command.equals(GET_TWEETS_CMD)) {
				getTweets(receiver, b);
			} 
		} catch (SocketTimeoutException e) {
			Log.e(TAG, e.getMessage());
			receiver.send(STATUS_CONNECTION_ERROR, b);
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage());
			receiver.send(STATUS_ERROR, b);
		} catch (ClientProtocolException e) {
			Log.e(TAG, e.getMessage());
			receiver.send(STATUS_ERROR, b);
		} catch (IllegalArgumentException e) {
			Log.e(TAG, e.getMessage());
			receiver.send(STATUS_ILLEGAL_ARGUMENT, b);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
			receiver.send(STATUS_ERROR, b);
		}

		// Es importante terminar el servicio lo antes posible
		this.stopSelf();


	}

	private void getTweets(ResultReceiver receiver, Bundle b) throws ClientProtocolException, IOException, JSONException {
		final DefaultHttpClient client = new DefaultHttpClient();
		final HttpResponse response = client.execute(new HttpGet("http://search.twitter.com/search.json?q=hello"));
		if ( response.getStatusLine().getStatusCode() != 200 ) {
			throw new IllegalArgumentException(response.getStatusLine().toString());
		}
		final String jsonToParse = EntityUtils.toString(response.getEntity());
		
		b.putSerializable("return", (Serializable) fromJSONtoTweets(jsonToParse));

		receiver.send(STATUS_OK, b);

	}
	
	private List<Tweet> fromJSONtoTweets(final String jsonToParse) throws JSONException {
		List<Tweet> tweets = new ArrayList<Tweet>();
		
		Log.d(TAG, "Json received: " + jsonToParse);
		
		JSONObject parsedJson = new JSONObject(jsonToParse);
		if ( !parsedJson.has("results")) {
			throw new JSONException("results not found");
		}
		
		JSONArray results = parsedJson.getJSONArray("results");
		
		/* XXX Dear org.json maintainers: 
		 * 		Please make JSONArray iterable in the near future :(
		 * Cheers,
		 */
		for ( int i = 0; i < results.length(); i++ ) {
			JSONObject bornToBeTweet = results.getJSONObject(i);
			tweets.add(TweetImpl.fromJSON(bornToBeTweet));			
		}
		
		return tweets;
	}

}
