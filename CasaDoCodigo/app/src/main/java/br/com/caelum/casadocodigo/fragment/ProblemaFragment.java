package br.com.caelum.casadocodigo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.delegates.RefreshListenerDelegate;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matheusbrandino on 12/13/17.
 */

public class ProblemaFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.problema_descricao)
    TextView problema;

    @BindView(R.id.problema_swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_problema, container, false);
        ButterKnife.bind(this, view);


        Throwable throwable = (Throwable) getArguments().getSerializable("problema");

        problema.setText(throwable.getMessage());

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,android.R.color.holo_green_dark, android.R.color.holo_red_dark);

        swipeRefreshLayout.setOnRefreshListener(this);


        return view;
    }

    @Override
    public void onRefresh() {
    /*    RefreshListenerDelegate delegate = (RefreshListenerDelegate) getActivity();
        delegate.fazBusca();*/

        new WebClient().getLivros();

    }
}