package twitter.search.model.api;

import java.util.Date;

public interface Tweet {

	public String getProfileImageURL();

	public Date getCreationDate();

	public String getUser();

	public String getText();

}
