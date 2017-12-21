package br.com.caelum.fj59.casadocodigo.webservice;

import java.io.IOException;

import org.springframework.stereotype.Component;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@Component
public class WebClient {

	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public void sobeParaFirebase(String id) throws IOException {

		OkHttpClient okHttpClient = new OkHttpClient();

		String json = "{\"data\":{\"message\":\"Teste \"}, \"to\":\"" + id + "\"}";

		RequestBody body = RequestBody.create(JSON, json);
		Request req = new Request.Builder().post(body).url("https://fcm.googleapis.com/fcm/send")
				.addHeader("Authorization", "key=AIzaSyCUMkIDdo-SmNE9NJA-u8nvBcBCdlDL5n8").build();

		okHttpClient.newCall(req).execute();

	}
}
