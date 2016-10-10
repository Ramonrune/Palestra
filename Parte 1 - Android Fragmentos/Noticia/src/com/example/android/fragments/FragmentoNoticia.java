
package com.example.android.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * 
 * @author Ramon Lacava Gutierrez Gonçales
 * 
 * Classe que representa o fragmento da noticia e herda de um fragmento
 *
 */
public class FragmentoNoticia extends Fragment {
	
	/*
	 * Constante que mostra a posição do argumento
	 */
    final static String POSICAO_DO_ARGUMENTO = "posicao";
    
    /*
     * Posição atual
     */
    int posicaoAtual = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

    	/*
    	 * Se a activity foi recriada (como a rotação de uma tela), restairar
    	 * a seleção do artigo através do onSaveInstanceState().
    	 * É de grande importancia quando estiver em um layout de dois paineis. 
    	 */
        if (savedInstanceState != null) {
        	posicaoAtual = savedInstanceState.getInt(POSICAO_DO_ARGUMENTO);
        }

        /*
         * Infla o layout para esse fragmento.
         */
        return inflater.inflate(R.layout.noticia_completa, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

       
        /*
         * Durante o inicio, checar se há argumentos passados para o fragmento.
         * No método onStart() é um bom local para se fazer isso por que o layout já foi aplicado ao 
         * fragmento e nesse ponto nós podemos chamar o método que setta a noticia do texto.
         */
        Bundle args = getArguments();
        if (args != null) {
            
        	/*
        	 * Setta a noticia baseado no argumento que foi passado.
        	 */
            atualizaViewNoticia(args.getInt(POSICAO_DO_ARGUMENTO));
        } else if (posicaoAtual != -1) {
        
        	/*
        	 * Setta a noticia baseada no estado da instancia salvo, definido durante o método
        	 * onCreateView. 
        	 */
        	atualizaViewNoticia(posicaoAtual);
        }
    }

    /**
     * Atualiza a TextView
     * 
     * @param posicao
     */
    public void atualizaViewNoticia(int posicao) {
    	/*
    	 * Pega a TextView para ser utilizada
    	 */
        TextView noticia = (TextView) getActivity().findViewById(R.id.noticia);
        /*
         * Coloca o texto da noticia na TextView
         */
        noticia.setText(Noticia.ARTIGO[posicao]);
        /*
         * A posição atual é a posição.
         */
        posicaoAtual = posicao;
    }

    /**
     * Salva o estado da instancia para caso seja necessário que o fragmento seja recriado
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        /*
         * Salva a atual selecao de noticia no caso de ser necessário recriar o fragmento.
         */
        outState.putInt(POSICAO_DO_ARGUMENTO, posicaoAtual);
    }
}