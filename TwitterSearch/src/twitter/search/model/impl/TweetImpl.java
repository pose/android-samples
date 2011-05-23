package twitter.search.model.impl;

import java.util.Date;

import twitter.search.model.api.Tweet;

public class TweetImpl implements Tweet {

	private String profileImageURL;
	private Date creationDate;
	private String user;
	private String text;

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
