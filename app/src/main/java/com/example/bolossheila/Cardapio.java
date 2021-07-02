package com.example.bolossheila;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bolossheila.fragmentos.Bolo_Alpino;
import com.example.bolossheila.fragmentos.Bolo_BabaMoca;
import com.example.bolossheila.fragmentos.Bolo_Beijinho;
import com.example.bolossheila.fragmentos.Bolo_Brigadeiro;
import com.example.bolossheila.fragmentos.Bolo_BrigadeiroNinho;
import com.example.bolossheila.fragmentos.Bolo_BrigadeiroTrufado;
import com.example.bolossheila.fragmentos.Bolo_Chiffon;
import com.example.bolossheila.fragmentos.Bolo_CremeBMorango;
import com.example.bolossheila.fragmentos.Bolo_CremeNinhoMorango;
import com.example.bolossheila.fragmentos.Bolo_DoceLeite;
import com.example.bolossheila.fragmentos.Bolo_DoisAmores;
import com.example.bolossheila.fragmentos.Bolo_FlorestNegra;
import com.example.bolossheila.fragmentos.Bolo_Kitkat;
import com.example.bolossheila.fragmentos.Bolo_Laka;
import com.example.bolossheila.fragmentos.Bolo_Mousse;
import com.example.bolossheila.fragmentos.Bolo_NinhoTrufadoMorango;
import com.example.bolossheila.fragmentos.Bolo_Nutella;
import com.example.bolossheila.fragmentos.Bolo_Oreo;
import com.example.bolossheila.fragmentos.Bolo_Prestigio;
import com.example.bolossheila.fragmentos.Bolo_Qleites;
import com.example.bolossheila.fragmentos.Bolo_QleitesTrufado;
import com.example.bolossheila.fragmentos.Bolo_Sensacao;
import com.example.bolossheila.fragmentos.Bolo_creme_abacaxi;

public class Cardapio extends AppCompatActivity {

    FragmentManager fg = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = findViewById(R.id.lista_produto);
        String[] menu = new String[]{
                //Preços R$48,00
                "2 Amores",/*case 0**************************/
                "4 Leites",/*case 1**************************/
                "Brigadeiro",/*case 2************************/
                "Beijinho",/*case 3**************************/
                "Creme c/ Abacaxi",/*case 4******************/
                "Doce de Leite",/*case 5*********************/
                "Mousse (Sabores)",/*case 6******************/
                "Prestígio",/*case 7*************************/
                "Sensação",/*case 8**************************/

                //Preços R$ 50,00
                "4 Leites Trufado",/*case 9******************/
                "Bridadeiro de Ninho",/*case 10***********/
                "Brigadeiro Trufado",/*case 11***************/
                "Creme Belga c/ Morango",/*case 12***********/
                "Creme Ninho c/ Morango",/*case 13***********/

                 //Preços R$53,00
                "Floresta Negra",/*case 14*******************/
                "Baba Moça",/*case 15************************/
                "Creme Ninho Trufado c/ Morango",/*case 16***/

                //Preços R$60,00
                "Creme Moça Laka",/*case 17******************/
                "Alpino",/*case 18***************************/
                "Chiffon",/*case 19**************************/
                "Kit-Kat",/*case 20**************************/
                "Nutella",/*case 21**************************/
                "Oreo"/*case 22******************************/
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                Cardapio.this, android.R.layout.simple_expandable_list_item_1, menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                switch (posicao) {
                    case 0:
                        Bolo_DoisAmores frag0 = new Bolo_DoisAmores();
                        FragmentTransaction ft0 = fg.beginTransaction();
                        ft0.replace(R.id.layout_produto, frag0, "frag0");
                        ft0.commit();
                        break;
                    case 1:
                        Bolo_Qleites frag1 = new Bolo_Qleites();
                        FragmentTransaction ft1 = fg.beginTransaction();
                        ft1.replace(R.id.layout_produto, frag1, "frag1");
                        ft1.commit();
                        break;
                    case 2:
                        Bolo_Brigadeiro frag2 = new Bolo_Brigadeiro();
                        FragmentTransaction ft2 = fg.beginTransaction();
                        ft2.replace(R.id.layout_produto, frag2, "frag2");
                        ft2.commit();
                        break;
                    case 3:
                        Bolo_Beijinho frag3 = new Bolo_Beijinho();
                        FragmentTransaction ft3 = fg.beginTransaction();
                        ft3.replace(R.id.layout_produto, frag3, "frag3");
                        ft3.commit();
                        break;
                    case 4:
                        Bolo_creme_abacaxi frag4 = new Bolo_creme_abacaxi();
                        FragmentTransaction ft4 = fg.beginTransaction();
                        ft4.replace(R.id.layout_produto, frag4, "frag4");
                        ft4.commit();
                        break;
                    case 5:
                        Bolo_DoceLeite frag5 = new Bolo_DoceLeite();
                        FragmentTransaction ft5 = fg.beginTransaction();
                        ft5.replace(R.id.layout_produto, frag5, "frag5");
                        ft5.commit();
                        break;
                    case 6:
                        Bolo_Mousse frag6 = new Bolo_Mousse();
                        FragmentTransaction ft6 = fg.beginTransaction();
                        ft6.replace(R.id.layout_produto, frag6, "frag6");
                        ft6.commit();
                        break;
                    case 7:
                        Bolo_Prestigio frag7 = new Bolo_Prestigio();
                        FragmentTransaction ft7 = fg.beginTransaction();
                        ft7.replace(R.id.layout_produto, frag7, "frag7");
                        ft7.commit();
                        break;
                    case 8:
                        Bolo_Sensacao frag8 = new Bolo_Sensacao();
                        FragmentTransaction ft8 = fg.beginTransaction();
                        ft8.replace(R.id.layout_produto, frag8, "frag8");
                        ft8.commit();
                        break;
                    case 9:
                        Bolo_QleitesTrufado frag9 = new Bolo_QleitesTrufado();
                        FragmentTransaction ft9 = fg.beginTransaction();
                        ft9.replace(R.id.layout_produto, frag9, "frag9");
                        ft9.commit();
                        break;
                    case 10:
                        Bolo_BrigadeiroNinho frag10 = new Bolo_BrigadeiroNinho();
                        FragmentTransaction ft10 = fg.beginTransaction();
                        ft10.replace(R.id.layout_produto, frag10, "frag10");
                        ft10.commit();
                        break;
                    case 11:
                        Bolo_BrigadeiroTrufado frag11 = new Bolo_BrigadeiroTrufado();
                        FragmentTransaction ft11 = fg.beginTransaction();
                        ft11.replace(R.id.layout_produto, frag11, "frag11");
                        ft11.commit();
                        break;
                    case 12:
                        Bolo_CremeBMorango frag12 = new Bolo_CremeBMorango();
                        FragmentTransaction ft12 = fg.beginTransaction();
                        ft12.replace(R.id.layout_produto, frag12, "frag12");
                        ft12.commit();
                        break;
                    case 13:
                        Bolo_CremeNinhoMorango frag13 = new Bolo_CremeNinhoMorango();
                        FragmentTransaction ft13 = fg.beginTransaction();
                        ft13.replace(R.id.layout_produto, frag13, "frag13");
                        ft13.commit();
                        break;
                    case 14:
                        Bolo_FlorestNegra frag14 = new Bolo_FlorestNegra();
                        FragmentTransaction ft14 = fg.beginTransaction();
                        ft14.replace(R.id.layout_produto, frag14, "frag14");
                        ft14.commit();
                        break;
                    case 15:
                        Bolo_BabaMoca frag15 = new Bolo_BabaMoca();
                        FragmentTransaction ft15 = fg.beginTransaction();
                        ft15.replace(R.id.layout_produto, frag15, "frag15");
                        ft15.commit();
                        break;
                    case 16:
                        Bolo_NinhoTrufadoMorango frag16 = new Bolo_NinhoTrufadoMorango();
                        FragmentTransaction ft16 = fg.beginTransaction();
                        ft16.replace(R.id.layout_produto, frag16, "frag16");
                        ft16.commit();
                        break;
                    case 17:
                        Bolo_Laka frag17 = new Bolo_Laka();
                        FragmentTransaction ft17 = fg.beginTransaction();
                        ft17.replace(R.id.layout_produto, frag17, "frag17");
                        ft17.commit();
                        break;
                    case 18:
                        Bolo_Alpino frag18 = new Bolo_Alpino();
                        FragmentTransaction ft18 = fg.beginTransaction();
                        ft18.replace(R.id.layout_produto, frag18, "frag18");
                        ft18.commit();
                        break;
                    case 19:
                        Bolo_Chiffon frag19 = new Bolo_Chiffon();
                        FragmentTransaction ft19 = fg.beginTransaction();
                        ft19.replace(R.id.layout_produto, frag19, "frag19");
                        ft19.commit();
                        break;
                    case 20:
                        Bolo_Kitkat frag20 = new Bolo_Kitkat();
                        FragmentTransaction ft20 = fg.beginTransaction();
                        ft20.replace(R.id.layout_produto, frag20, "frag20");
                        ft20.commit();
                        break;
                    case 21:
                        Bolo_Nutella frag21 = new Bolo_Nutella();
                        FragmentTransaction ft21 = fg.beginTransaction();
                        ft21.replace(R.id.layout_produto, frag21, "frag21");
                        ft21.commit();
                        break;
                    case 22:
                        Bolo_Oreo frag22 = new Bolo_Oreo();
                        FragmentTransaction ft22 = fg.beginTransaction();
                        ft22.replace(R.id.layout_produto, frag22, "frag22");
                        ft22.commit();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}