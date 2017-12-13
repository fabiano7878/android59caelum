package br.com.caelum.casadocodigo.server;

import java.util.List;

import br.com.caelum.casadocodigo.modelo.Livro;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android7130 on 13/12/17.
 */

public interface LivroService {

    @GET("listarLivros?indicePrimeiroLivro=0&qtdLivros=20")
    Call<List<Livro>> listaLivros();
}
