package br.com.caelum.casadocodigo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.Delagate.LivroDelegate;
import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.fragment.DetalhesLivroFragment;
import br.com.caelum.casadocodigo.fragment.EsperaFragment;
import br.com.caelum.casadocodigo.fragment.ListaLivroFragment;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.server.LivroEvent;
import br.com.caelum.casadocodigo.server.WebClient;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements LivroDelegate {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       trocaFragment(new EsperaFragment());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //new WebClient(this).getLivros();
        new WebClient().getLivros();
        EventBus.getDefault().register(this);
    }


    public void lidaComLivroSelecionado(Livro livro) {
        //makeText(this, "Livro Selecionado: "+livro.getNome(), Toast.LENGTH_LONG).show();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        DetalhesLivroFragment detlheslivro = criaDetalhesCom(livro);
        transaction.replace(R.id.frame_principal, detlheslivro);
        transaction.addToBackStack(null);
        transaction.commit();

    }

  /*  @Override
    public void lidaComSucesso(List<Livro> livros) {
        listaLivrosFragment.populaListaCom(livros);
    }*/

    public void trocaFragment(Fragment fragmentEspera){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_principal, fragmentEspera);
        transaction.commit();
    }

    @Subscribe
    public void lidaComSucesso(LivroEvent event) {
       // listaLivrosFragment.populaListaCom(livroEvent.getLivros());

        ListaLivroFragment listaLivroFragment = new ListaLivroFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", event.getLivros());

        listaLivroFragment.setArguments(bundle);
        trocaFragment(listaLivroFragment);


    }


    public void lidaComErro(Throwable erro) {
        Toast.makeText(this, "Não foi possivel carregar os Livros...", Toast.LENGTH_SHORT).show();
    }

    public DetalhesLivroFragment criaDetalhesCom(Livro livro) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("Livro", livro);
        DetalhesLivroFragment detalhes = new DetalhesLivroFragment();
        detalhes.setArguments(bundle);
        return  detalhes;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
