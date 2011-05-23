package twitter.search.model.impl;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import twitter.search.model.api.Tweet;

public class TweetImpl implements Tweet {

	private String profileImageURL;
	private Date creationDate;
	private String user;
	private String text;
	
	public static Tweet fromJSON(JSONObject bornToBeTweet) throws JSONException {
		if ( bornToBeTweet == null || !bornToBeTweet.has("text") ||
				!bornToBeTweet.has("from_user") || !bornToBeTweet.has("created_at")
				|| !bornToBeTweet.has("profile_image_url")) {
			throw new IllegalArgumentException("I cannot build a Tweet from that!");
		}
		
		return new TweetImpl(bornToBeTweet.getString("profile_image_url"),
				new Date (Date.parse(bornToBeTweet.getString("created_at"))),
				bornToBeTweet.getString("from_user"),
				bornToBeTweet.getString("text"));
	}

	public TweetImpl(String profileImageURL, Date creationDate, String user,
			String text) {
		this.profileImageURL = profileImageURL;
		this.creationDate = creationDate;
		this.user = user;
		this.text = text;
	}

	@Override
	public String getProfileImageURL() {
		return profileImageURL;
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public String getUser() {
		return user;
	}

	@Override
	public String getText() {
		return text;
	}

}
