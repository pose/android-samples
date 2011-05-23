package twitter.search.activities;

import twitter.search.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends Activity {

	public static final int MILLIS_TIME_TO_WAIT = 1000;
	public static final int STOP = 0;

	private Handler splashHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SplashActivity.STOP:
				// Intent intent = new Intent
				// startActivity()
				SplashActivity.this.finish();
				break;
			}
			super.handleMessage(msg);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Message message = new Message();
		message.what = STOP;
		// XXX ¿Po qué no puedo hacer simplemente sleep(3000) ?
		splashHandler.sendMessageDelayed(message, MILLIS_TIME_TO_WAIT);

	}
}