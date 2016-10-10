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
 * @author Ramon Lacava Gutierrez Gonçales
 *
 *	Classe que representa o cabeçalho das noticias
 *  Ela herda da classe ListFragment, que representa um conjunto de fragmentos
 */
public class FragmentoCabecalho extends ListFragment {
    
	CabecalhoListener chamar;

	/**
	 * 
	 *Interface ouvinte do cabeçalho
	 */
    public interface CabecalhoListener {
       
    	/**
    	 * Método que age na seleção de uma noticia
    	 * É necessário passar uma posição.
    	 * 
    	 * @param posicao
    	 */
        public void naSelecaoDaNoticia(int posicao);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * Obtem o layout. Se a versão da build atual for maior ou igual
         * a versão hony comb, retornará o layout de um item ativado, caso contrario, um layout simples
         * Configuração feita para o aplicativo se adaptar conforme as versões.
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
         * Quando estiver em um layout de dois paineis, a lista irá "focar" o item selecionado.
         * Isso é feito durante o fragmento iniciar por que é o ponto no qual a lista está avaliavel.
         */
        if (getFragmentManager().findFragmentById(R.id.fragmentonoticia) != null) {
        	/*
        	 *Coloca o modo de seleção da lista como único. 
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
         * Isso da certeza que o container da activity implementou a interface. Se não,
         * uma exceção é lançada. 
         */
        try {
        	chamar = (CabecalhoListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " É necessário implementar o Listener do Cabeçalho");
        }
    }

    /**
     * Evento associado quando o item da lista for clicado
     * São passados como argumento, a lista, a view, a posição e o id
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