package phone.nikolas.com.castflow.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Pleret on 4/12/2017.
 */

public abstract class BaseFragment<B,V,P> extends Fragment {
    protected B binding;
    protected V viewModel;
    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjection();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initBinding(inflater, container, savedInstanceState);
        initPresenter();
        initViewModel();
        onViewReady(savedInstanceState);
        return view;
    }

    protected abstract void initInjection();
    protected abstract View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    protected abstract void initViewModel();
    protected abstract void initPresenter();
    protected abstract void onViewReady(Bundle savedInstanceState);
}
