package twitter.search.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import twitter.search.model.api.Tweet;
import twitter.search.model.impl.TweetImpl;

public class TweetProviderMock extends AbstractTweetProvider {

	@Override
	public List<Tweet> getTweets() {
		List<Tweet> tweets = new ArrayList<Tweet>();

		tweets.add(new TweetImpl(
				"http://a0.twimg.com/profile_images/1362890877/206255_193001784077035_172228012821079_470609_7771913_n_normal.jpg",
				new Date(Date.parse("Mon, 23 May 2011 11:59:50 +0000")), "aprilin24",
				"HELLO HELLO i'm back,keke :D ready for trending FTIslandRETURN..!!!"));

		tweets.add(new TweetImpl(
				"http://a0.twimg.com/profile_images/1359910909/230391_1998789539093_1524163148_2173243_3912509_n_normal.jpg",
				new Date(Date.parse("Mon, 23 May 2011 14:30:28 +0000")),
				"Zelda",
				"@Gibishli uuuuuuuuuhm hello,still waiting u don't want me to bring out the big guns now do u"));

		return tweets;
	}

}
