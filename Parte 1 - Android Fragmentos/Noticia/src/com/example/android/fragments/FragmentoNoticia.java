
package com.example.android.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * 
 * @author Ramon Lacava Gutierrez Gon�ales
 * 
 * Classe que representa o fragmento da noticia e herda de um fragmento
 *
 */
public class FragmentoNoticia extends Fragment {
	
	/*
	 * Constante que mostra a posi��o do argumento
	 */
    final static String POSICAO_DO_ARGUMENTO = "posicao";
    
    /*
     * Posi��o atual
     */
    int posicaoAtual = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

    	/*
    	 * Se a activity foi recriada (como a rota��o de uma tela), restairar
    	 * a sele��o do artigo atrav�s do onSaveInstanceState().
    	 * � de grande importancia quando estiver em um layout de dois paineis. 
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
         * Durante o inicio, checar se h� argumentos passados para o fragmento.
         * No m�todo onStart() � um bom local para se fazer isso por que o layout j� foi aplicado ao 
         * fragmento e nesse ponto n�s podemos chamar o m�todo que setta a noticia do texto.
         */
        Bundle args = getArguments();
        if (args != null) {
            
        	/*
        	 * Setta a noticia baseado no argumento que foi passado.
        	 */
            atualizaViewNoticia(args.getInt(POSICAO_DO_ARGUMENTO));
        } else if (posicaoAtual != -1) {
        
        	/*
        	 * Setta a noticia baseada no estado da instancia salvo, definido durante o m�todo
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
         * A posi��o atual � a posi��o.
         */
        posicaoAtual = posicao;
    }

    /**
     * Salva o estado da instancia para caso seja necess�rio que o fragmento seja recriado
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        /*
         * Salva a atual selecao de noticia no caso de ser necess�rio recriar o fragmento.
         */
        outState.putInt(POSICAO_DO_ARGUMENTO, posicaoAtual);
    }
}