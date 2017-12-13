package br.com.caelum.casadocodigo.server;

import java.util.List;

import br.com.caelum.casadocodigo.Delagate.LivroDelegate;
import br.com.caelum.casadocodigo.converter.LivroServiceConverterFactory;
import br.com.caelum.casadocodigo.modelo.Livro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by android7130 on 13/12/17.
 */

public class WebClient {


    private static final String SERVER_URL = "http://cdcmob.herokuapp.com/";

    private LivroDelegate delegate;

    public WebClient(LivroDelegate pDelegate){
        this.delegate = pDelegate;
    }

    public void getLivros(){

        Retrofit client = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(new LivroServiceConverterFactory())
                .build();

        LivroService service = client.create(LivroService.class);

        Call<List<Livro>> call = service.listaLivros();

        call.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {
                delegate.lidaComSucesso(response.body());
            }

            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {
                delegate.lidaComErro(t);
            }
        });
     }
}
