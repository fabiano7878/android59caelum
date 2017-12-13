package br.com.caelum.casadocodigo.Delagate;

import java.util.List;

import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by android7130 on 12/12/17.
 */

public interface LivroDelegate {

    public void lidaComLivroSelecionado(Livro livro);

    public void lidaComSucesso(List<Livro> livros);

    public void lidaComErro(Throwable erro);

}
