package maputo.gdg.com.postsupportlibrary.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import maputo.gdg.com.postsupportlibrary.R;
import maputo.gdg.com.postsupportlibrary.adapters.NavigationDrawerListAdapter;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private Toolbar mtoolbar;

    private ActionBarDrawerToggle mDrawerToogle;

    private ListView mListaDrawer;

    int mPosicaoSelecionada;

    int mUltimaPosicaoDoDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicializarToolbar();

        inicializarDrawer();

    }


    public void inicializarToolbar()
    {
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        //Define titulo do toolbar
        mtoolbar.setTitle("Hello Material");

        //Define o icon do drawer no Toolbar
        mtoolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_menu));

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                mDrawerLayout.openDrawer(mListaDrawer);
            }
        });


    }

    public void inicializarDrawer()
    {

        //Definir a posicao selecionada e a ultima do drawer
        mPosicaoSelecionada = 1;

        mUltimaPosicaoDoDrawer  = mPosicaoSelecionada;

        //Pega o DrawerLayout
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        //Pega a lista
        mListaDrawer = (ListView) findViewById(R.id.nav_drawer);


        //Criar um toogler para abrir e fechar o drawer ao clicar no icon no toolbar
        mDrawerToogle = new ActionBarDrawerToggle(this,mDrawerLayout,mtoolbar,R.string.drawer_aberto,R.string.drawer_fechad0)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                //pintar a antiga posicao ao normal
                pintarItems(mUltimaPosicaoDoDrawer,false);

                //pintar a posicao selecionada com
                pintarItems(mPosicaoSelecionada,true);

                //Pode fazer o commit dos fragments que deseja aqui

            }
        };


        mDrawerLayout.setDrawerListener(mDrawerToogle);

        //Definir os items da lista no adapter

        NavigationDrawerListAdapter mDrawerAdapter = new NavigationDrawerListAdapter(this.getApplicationContext());

        mDrawerAdapter.setDrawerHeader("Defina o link de uma imagem aqui para avatar","Dario Mungoi","Defina  o link para o backgroudn aqui");
        mDrawerAdapter.addRow(R.drawable.ic_comingsoon,"Brevemente");
        mDrawerAdapter.addRow(R.drawable.ic_ticket,"Meus Bilhetes");
        mDrawerAdapter.addRow(R.drawable.ic_settings,"Definicoes");


        mListaDrawer.setAdapter(mDrawerAdapter);


        mListaDrawer.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void pintarItems(int posicao,boolean isSelected)
    {
        View view = mListaDrawer.getChildAt(posicao);

        View mIconView = view.findViewById(R.id.row_icon);

        Drawable iconDrawable = DrawableCompat.wrap(mIconView.getBackground());

        TextView mRowTextView = (TextView)view.findViewById(R.id.drawer_row_line);

        int color = getResources().getColor(R.color.black);

        if(isSelected==true)
        {
            color = getResources().getColor(R.color.primaryColor);
        }

        mRowTextView.setTextColor(color);

        //muda a cor do drawable para as especificadas
        DrawableCompat.setTint(iconDrawable,color);

    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {

            if(position!=0)
            {
                mUltimaPosicaoDoDrawer = mPosicaoSelecionada;
                mPosicaoSelecionada = position;
                selectItem(position);
            }
            else
            {
                mDrawerLayout.closeDrawer(mListaDrawer);
            }

        }
    }

    public void selectItem(int position)
    {

        switch(position)
        {

            case 1:
            {
                break;
            }
            case 2:
            {
                break;
            }
            case 3:
            {
                break;
            }
            default:
            {
                throw new UnsupportedOperationException("Invalid position");
            }
        }
        Toast.makeText(this,"Nova posicao do drawer e: "+mPosicaoSelecionada+" a antiga e: "+mUltimaPosicaoDoDrawer,Toast.LENGTH_LONG).show();
        mDrawerLayout.closeDrawer(mListaDrawer);
    }




}
