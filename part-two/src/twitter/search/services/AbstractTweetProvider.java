package twitter.search.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import twitter.search.model.api.Tweet;
import twitter.search.model.api.TweetProvider;

public abstract class AbstractTweetProvider implements TweetProvider {

	public static final String[] fields = { "date", "user", "text" };

	@Override
	public List<? extends Map<String, ?>> getTweetsAsMap() {
		List<Tweet> tweets = getTweets();
		List<Map<String, String>> transformedTweets = new ArrayList<Map<String, String>>();
		for (Tweet t : tweets) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(fields[0], t.getCreationDate().toString());
			map.put(fields[1], t.getUser());
			map.put(fields[2], t.getText());
			transformedTweets.add(map);
		}
		return transformedTweets;
	}

	@Override
	public String[] getMapKeys() {
		return fields;
	}
}
