package twitter.search.activities;

import twitter.search.R;
import twitter.search.model.api.TweetProvider;
import twitter.search.services.TweetProviderMock;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class SearchActivity extends ListActivity {

	private TweetProvider tweetProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* Asociamos search list con la activity */
		setContentView(R.layout.search_list);

		/* TODO: Unmock me! */
		tweetProvider = new TweetProviderMock();

		ListAdapter adapter = new SimpleAdapter(this,
				tweetProvider.getTweetsAsMap(), R.layout.search_item,
				tweetProvider.getMapKeys(), new int[] { R.id.image, R.id.date,
						R.id.title, R.id.description });

		setListAdapter(adapter);
	}
}
