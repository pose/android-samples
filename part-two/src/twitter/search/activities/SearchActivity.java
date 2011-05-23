package twitter.search.activities;

import java.util.List;

import twitter.search.R;
import twitter.search.model.api.Tweet;
import twitter.search.model.api.TweetProvider;
import twitter.search.model.impl.SimpleTweetProvider;
import twitter.search.services.TwitterSearchService;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class SearchActivity extends ListActivity {

	private String TAG = getClass().getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* Asociamos search list con la activity */
		setContentView(R.layout.search_list);

		Intent intent = new Intent(Intent.ACTION_SYNC, null, this,
				TwitterSearchService.class);
		
		/* Se pasa Handler porque si se pasara null se debería llamar a
		 * runOnUiThread con un Runnable para modificar el thread de UI.
		 */
		intent.putExtra("receiver", new ResultReceiver(new Handler()) {
			@Override
			protected void onReceiveResult(int resultCode, Bundle resultData) {
				super.onReceiveResult(resultCode, resultData);
				if (resultCode == TwitterSearchService.STATUS_OK) {

					Log.d(TAG, "ok");

					@SuppressWarnings("unchecked")
					List<Tweet> list = (List<Tweet>) resultData
							.getSerializable("return");

					populateList(new SimpleTweetProvider(list));

				} else if (resultCode == TwitterSearchService.STATUS_CONNECTION_ERROR) {
					Log.d(TAG, "connection error");
				} else {
					Log.d(TAG, "unknown error");
				}
			}

		});
		intent.putExtra("command", TwitterSearchService.GET_TWEETS_CMD);
		startService(intent);

	}
	
	private void populateList(TweetProvider tweetProvider) {
		ListAdapter adapter = new SimpleAdapter(this,
				tweetProvider.getTweetsAsMap(), R.layout.search_item,
				tweetProvider.getMapKeys(), new int[] { R.id.date,
			R.id.title, R.id.description });
		
		setListAdapter(adapter);
		
	}
	
}
