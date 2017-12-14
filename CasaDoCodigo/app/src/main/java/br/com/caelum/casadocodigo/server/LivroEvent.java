package br.com.caelum.casadocodigo.server;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by android7130 on 13/12/17.
 */

public class LivroEvent {

    private final List<Livro> livros;

    public LivroEvent(List<Livro> pLivro) {
        this.livros = pLivro;
    }

    public ArrayList<Livro> getLivros() {
        return (ArrayList<Livro>) livros;
    }
}

