package twitter.search.model.api;

import java.util.List;
import java.util.Map;

public interface TweetProvider {
	public List<Tweet> getTweets();

	public List<? extends Map<String, ?>> getTweetsAsMap();

	public String[] getMapKeys();
}
