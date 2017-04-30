package br.com.androidws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InsereWS extends Activity {

	private Button addconta;
	private EditText numero, cliente, saldo;
	private static String ADICIONA = "http://192.168.0.101/WSConta/Insere.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adiciona);

		addconta = (Button) findViewById(R.id.addconta);
		numero = (EditText) findViewById(R.id.addnumero);
		cliente = (EditText) findViewById(R.id.addnomecliente);
		saldo = (EditText) findViewById(R.id.addsaldo);

		addconta.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String num = numero.getText().toString();
				String cli = cliente.getText().toString();
				String sal = saldo.getText().toString();
				ADICIONA += "?numero=" + num + "&cliente=" + cli + "&saldo=" + sal;

				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpGet httpget = new HttpGet(ADICIONA);
					HttpResponse response = httpclient.execute(httpget);
					HttpEntity entity = response.getEntity();
					InputStream webs = entity.getContent();
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(webs, "iso-8859-1"), 8);
						Log.i("lendo linha", reader.readLine());
						webs.close();
					} catch (Exception e) {
						Log.e("Erro na conversão: ", e.toString());
					}
				} catch (Exception e) {
					Log.e("Erro na conexão: ", e.toString());
				}

				ADICIONA = "http://192.168.0.101/WSConta/Insere.php";
			}
		});

	}
}
