package com.etbakhly.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.etbakhly.R;
import com.etbakhly.activities_fragments.banquete.activity_home_banquete.fragments.Fragment_Home;
import com.etbakhly.databinding.SpecialDishesProductRowBinding;
import com.etbakhly.models.KitchenModel;

import java.util.List;

public class SpecialDishesProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<KitchenModel> list;
    private Context context;
    private LayoutInflater inflater;
    private Fragment fragment;


    public SpecialDishesProductAdapter(List<KitchenModel> list, Context context,Fragment fragment) {
        this.list = list;
        this.context = context;
        this.fragment=fragment;
        inflater = LayoutInflater.from(context);


    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        SpecialDishesProductRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.special_dishes_product_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        myHolder.binding.setModel(list.get(position));
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragment instanceof Fragment_Home){
                    Fragment_Home fragment_home= (Fragment_Home) fragment;
                    fragment_home.showSpecial(list.get(holder.getLayoutPosition()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public SpecialDishesProductRowBinding binding;

        public MyHolder(@NonNull SpecialDishesProductRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }




}
