package twitter.search.services;

import android.app.IntentService;
import android.content.Intent;

public class TwitterSearchService extends IntentService {

	/*
	 * Se debe crear un constructor sin parámetros y asignarle un nombre al
	 * servicio.
	 */
	public TwitterSearchService() {
		super("TwitterSearchService");
	}

	/*
	 * Evento que se ejecuta cuando se invocó el servicio por medio de un
	 * Intent.
	 */
	@Override
	protected void onHandleIntent(Intent arg0) {

	}

}
