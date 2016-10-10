package com.example.android.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


/**
 * 
 * @author Ramon Lacava Gutierrez Gonçales
 *
 *
 * MainActivity que extende uma FragmentActivity e implementa a interface CabecalhoListener,
 * ou seja, ou "ouvinte" para o cabeçalho.
 */
public class MainActivity extends FragmentActivity 
        implements FragmentoCabecalho.CabecalhoListener {


	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novas_noticias);

        /*
         * Checa qual activity está usando o layout com o 
         * Framelayout. Se estiver sendo usado é necessário adicionar o primeiro fragmento
         */
        
        if (findViewById(R.id.container_do_fragmento) != null) {

        	
        	/*
        	 * No entanto, se o app está a ser restaurado a partir de um estado anterior,
			 * Então não precisa fazer nada e deve retornar
        	 */
           
            if (savedInstanceState != null) {
                return;
            }
            
            /*
             * Cria a instancia de um cabeçalho
             */
            FragmentoCabecalho primeiroFragmento  = new FragmentoCabecalho();
            
            /*
             * Caso a activity foi iniciada com instruções especiais de uma intent,
             * passar os extras da intent para o fragmento na forma de argumentos.
             */
           
            primeiroFragmento.setArguments(getIntent().getExtras()); //setta os argumentos extras da intent

            /*
             * Adiciona o fragmento para o container framelayout
             */
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_do_fragmento, primeiroFragmento).commit();
        }
    }
    
    
    public void naSelecaoDaNoticia(int posicao) {
        
    	/*
    	 * O usuário selecionou uma noticia do FragmentoCabecalho
    	 */

        
    	/*
    	 * Captura a noticia do fragmento
    	 */
        FragmentoNoticia fragNoticia = (FragmentoNoticia)
                getSupportFragmentManager().findFragmentById(R.id.fragmentonoticia);

        if (fragNoticia != null) {
            /*
             * Se o fragmento estiver disponivel, então este é um layout de dois paines.
             * Como por exemplo o de tablets.
             */

          
        	/*
        	 * Chama o método no FragmentoNoticia para atualizar o conteudo dele.
        	 */
        	fragNoticia.atualizaViewNoticia(posicao);

        } else {
        	/*
        	 * Se o fragmento não estiver disponível, estamos em um layout com um painel, como o de 
        	 * celulares normais, e deve-se mudar os layouts.
        	 */
           
         
        	/*
        	 * Cria o fragmento e da a ele um argumento para o artigo selecionado
        	 */
            FragmentoNoticia novoFragmento = new FragmentoNoticia();
            Bundle args = new Bundle();
            args.putInt(FragmentoNoticia.POSICAO_DO_ARGUMENTO, posicao);
            novoFragmento.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

          
            /*
             * Muda qualquer coisa que está no container_do_fragmento com esse fragmento
             * e adiciona a transação para o usuário poder navegar de volta.
             */
            transaction.replace(R.id.container_do_fragmento, novoFragmento);
            transaction.addToBackStack(null); //isso é feito para o usuário poder navegar de volta

            /*
             * Commita a transação
             */
            transaction.commit();
        }
    }
}