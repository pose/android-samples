package twitter.search.model.impl;

import java.util.List;

import twitter.search.model.api.Tweet;
import twitter.search.services.AbstractTweetProvider;

public class SimpleTweetProvider extends AbstractTweetProvider {

	private List<Tweet> tweets;
	
	public SimpleTweetProvider(List<Tweet> tweets) {
		if ( tweets == null ) {
			throw new IllegalArgumentException("tweets cannot be null");
		}
		
		this.tweets = tweets; 
	}
	
	@Override
	public List<Tweet> getTweets() {
		return tweets;
	}

}
