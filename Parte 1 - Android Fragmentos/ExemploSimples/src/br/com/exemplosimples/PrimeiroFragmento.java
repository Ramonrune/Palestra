package br.com.exemplosimples;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PrimeiroFragmento extends Fragment{

	View viewPrincipal;
	
	/**
	 * Cria a interface na primeira vez e retorna a view
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		/**
		 * Infla o layout para ser retornado pelo método onCreateView
		 * 1º é passado o layout,
		 * Depois o ViewGroup
		 * Após isso, um valor booleano (true ou false)
		 */
		viewPrincipal = inflater.inflate(R.layout.fragmentoum, container, false);
		
		return viewPrincipal;
	}
	
}
