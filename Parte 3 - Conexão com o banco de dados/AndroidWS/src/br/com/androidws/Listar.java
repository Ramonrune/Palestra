package br.com.androidws;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Listar extends ListActivity {	
	
	static final String URL = "http://192.168.0.101/WSConta/consulta.php";
	static final String KEY_ITEM = "conta"; 
	static final String KEY_ID = "numero";
	static final String KEY_NOME = "cliente";
	static final String KEY_SALDO = "saldo";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

		ConversorXML parser = new ConversorXML();
		String xml = parser.pegaXMLDaURL(URL); 
		Document doc = parser.pegaElementoDOM(xml); 

		NodeList nl = doc.getElementsByTagName(KEY_ITEM);
		
		for (int i = 0; i < nl.getLength(); i++) {
			
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			
			map.put(KEY_ID, parser.pegaValor(e, KEY_ID));
			map.put(KEY_NOME, parser.pegaValor(e, KEY_NOME));
			map.put(KEY_SALDO, parser.pegaValor(e, KEY_SALDO));
			
		
			menuItems.add(map);
		}

		ListAdapter adapter = new SimpleAdapter(this, menuItems,
				R.layout.list_item,
				new String[] { KEY_NOME, KEY_SALDO, KEY_ID }, new int[] {
						R.id.nome, R.id.saldo, R.id.numero });

		setListAdapter(adapter);

		
		ListView lv = getListView();

	}
}