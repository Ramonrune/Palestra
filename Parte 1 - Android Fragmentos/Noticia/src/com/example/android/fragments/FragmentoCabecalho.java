package com.example.android.fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Ramon Lacava Gutierrez Gon�ales
 *
 *	Classe que representa o cabe�alho das noticias
 *  Ela herda da classe ListFragment, que representa um conjunto de fragmentos
 */
public class FragmentoCabecalho extends ListFragment {
    
	CabecalhoListener chamar;

	/**
	 * 
	 *Interface ouvinte do cabe�alho
	 */
    public interface CabecalhoListener {
       
    	/**
    	 * M�todo que age na sele��o de uma noticia
    	 * � necess�rio passar uma posi��o.
    	 * 
    	 * @param posicao
    	 */
        public void naSelecaoDaNoticia(int posicao);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * Obtem o layout. Se a vers�o da build atual for maior ou igual
         * a vers�o hony comb, retornar� o layout de um item ativado, caso contrario, um layout simples
         * Configura��o feita para o aplicativo se adaptar conforme as vers�es.
         */
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        /*
         * Setta o adaptador de lista como um array de strings adaptaveis
         * Passa como parametro a activity, o layout e o o vetor do cabecalho na classe Noticia
         */
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Noticia.CABECALHO));
    }

    /**
     * Quando o fragmento iniciar
     */
    @Override
    public void onStart() {
        super.onStart();

        /*
         * Quando estiver em um layout de dois paineis, a lista ir� "focar" o item selecionado.
         * Isso � feito durante o fragmento iniciar por que � o ponto no qual a lista est� avaliavel.
         */
        if (getFragmentManager().findFragmentById(R.id.fragmentonoticia) != null) {
        	/*
        	 *Coloca o modo de sele��o da lista como �nico. 
        	 */
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    /**
     * Quando o fragmento estiver associado a activity.
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    
        /*
         * Isso da certeza que o container da activity implementou a interface. Se n�o,
         * uma exce��o � lan�ada. 
         */
        try {
        	chamar = (CabecalhoListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " � necess�rio implementar o Listener do Cabe�alho");
        }
    }

    /**
     * Evento associado quando o item da lista for clicado
     * S�o passados como argumento, a lista, a view, a posi��o e o id
     */
    @Override
    public void onListItemClick(ListView l, View v, int posicao, long id) {
        
    	/*
    	 * Notifica a activity pai do item selecionado
    	 */
    	chamar.naSelecaoDaNoticia(posicao);
        
        
    	/*
    	 * Setta o item como checado para ser "focado em um layout de dois paineis, como o de um tablet. 
    	 */
        getListView().setItemChecked(posicao, true);
    }
}