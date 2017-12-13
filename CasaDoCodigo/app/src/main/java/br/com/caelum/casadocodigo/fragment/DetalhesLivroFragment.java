package br.com.caelum.casadocodigo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Autor;
import br.com.caelum.casadocodigo.modelo.Livro;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android7130 on 12/12/17.
 */

public class DetalhesLivroFragment extends Fragment {

    @BindView(R.id.detalhes_livro_nome)
    TextView nome;

    @BindView(R.id.detalhes_livro_descricao)
    TextView descricao;

   /* @BindView(R.id.detalhes_livro_num_paginas)
    TextView numPaginas;*/

    @BindView(R.id.detalhes_livro_autores)
    TextView autores;

    @BindView(R.id.detalhes_livro_comprar_fisico)
    TextView textoCompraFisico;

    @BindView(R.id.detalhes_livro_isbn)
    TextView isbn;

    @BindView(R.id.detalhes_livro_data_publicacao)
    TextView dataPblicacao;



    private int numPaginas;
    private String dataPublicacao;
    private String ISBN;
    private double valorFisico;
    private double valorVirtual;
    private double valorDoisJuntos;
    private String urlFoto;



    private Livro livro;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_detalhes_livro, container, false);
        ButterKnife.bind(this, view);

        Bundle arguments = getArguments();
        livro = (Livro) arguments.getSerializable("Livro");
        populaCamposCom(livro);
        return view;
    }

    private void populaCamposCom(Livro livro) {
        nome.setText(livro.getNome());
        descricao.setText(livro.getDescricao());

        String listaDeAutores = "";
        for(Autor autor: livro.getAutores()){
            if(!listaDeAutores.isEmpty()){
                listaDeAutores += ", ";
            }
            listaDeAutores += autor.getNome();
        }


    }



}
