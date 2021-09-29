package com.etbakhly.activities_fragments.activity_home_independent.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.etbakhly.R;
import com.etbakhly.activities_fragments.activity_home_independent.HomeActivity;

import com.etbakhly.adapters.MostFamousChefAdapter;
import com.etbakhly.adapters.OfferAdapter;
import com.etbakhly.databinding.FragmnetOfferIndependentBinding;
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

public class FragmentOffers extends Fragment {

    private HomeActivity activity;
    private FragmnetOfferIndependentBinding binding;
    private Preferences preferences;
    private UserModel userModel;
    private String lang;
    private List<Object> list;

    public static FragmentOffers newInstance() {

        return new FragmentOffers();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragmnet_offer_independent, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    private void initView() {
        list = new ArrayList<>();
        activity = (HomeActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", "ar");
        binding.recviewoffer.setLayoutManager(new LinearLayoutManager(activity));
        binding.recviewoffer.setAdapter(new OfferAdapter(list, activity));


    }


}