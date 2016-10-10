package br.com.exemplosimples;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundoFragmento extends Fragment{

	View viewPrincipal;
	Button btPegar;
	TextView tvProduto;
	/**
	 * Método executado na primeira fez que a interface é gerada
	 * 
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		/**
		 * Infla o layout
		 */
		viewPrincipal = inflater.inflate(R.layout.fragmentodois, container, false);
		
		
		return viewPrincipal;
	}
	
	
	/**
	 * Ciclo de vida do fragmento
	 * Quando ele iniciar, será executado o método abaixo
	 */
	@Override
	public void onStart() {
			super.onStart();
			
			/**
			 * Obtem o botão para ser possivel obter o produto
			 */
			btPegar = (Button) viewPrincipal.findViewById(R.id.btPegarProduto);
			/**
			 * Obtem a TextView
			 */
			tvProduto = (TextView) viewPrincipal.findViewById(R.id.tvProduto);
		
			/**
			 * Quando o botão for clicado
			 */
			btPegar.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					/**
					 * Pega os dados do outro fragmento através do método getActivity()
					 */
					String nomeProduto = ((EditText)getActivity().findViewById(R.id.etNome)).getText().toString();
					/**
					 * Coloca o nome no TextView de produto
					 */
					tvProduto.setText(nomeProduto);
				}
			});
	}
}
