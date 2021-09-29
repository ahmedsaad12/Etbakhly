package com.etbakhly.activities_fragments.activity_home_independent.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.etbakhly.R;

import com.etbakhly.activities_fragments.activity_home_independent.HomeActivity;
import com.etbakhly.adapters.OrdersAdapter;
import com.etbakhly.databinding.FragmentOrdersBinding;
import com.etbakhly.models.UserModel;
import com.etbakhly.preferences.Preferences;
import com.etbakhly.remote.Api;
import com.etbakhly.tags.Tags;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPreviousOrder extends Fragment {

    private HomeActivity activity;
    private FragmentOrdersBinding binding;
    private Preferences preferences;
    private String lang;
    private UserModel userModel;
private List<Object> list;


    public static FragmentPreviousOrder newInstance() {
        return new FragmentPreviousOrder();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false);
        initView();

        return binding.getRoot();
    }


    private void initView() {
        list=new ArrayList<>();
        activity = (HomeActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", "ar");
        binding.recView.setLayoutManager(new LinearLayoutManager(activity));
        binding.recView.setAdapter(new OrdersAdapter(list, activity));
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }


}