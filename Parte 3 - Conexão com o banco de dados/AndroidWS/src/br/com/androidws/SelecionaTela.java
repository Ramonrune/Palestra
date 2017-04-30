package br.com.androidws;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SelecionaTela extends Activity{
	
	private Button adicionar, listar;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seleciona);
		
		adicionar = (Button) findViewById(R.id.adicionar);
		listar = (Button) findViewById(R.id.listar);
		
		
		adicionar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent i = new Intent(SelecionaTela.this, InsereWS.class);
				startActivity(i);
			}
		});
		listar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(SelecionaTela.this, Listar.class);
				startActivity(i);
			}
		});
		
		
	}
	
	
}
