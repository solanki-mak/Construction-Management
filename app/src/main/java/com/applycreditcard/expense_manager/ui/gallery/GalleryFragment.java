package com.applycreditcard.expense_manager.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.applycreditcard.expense_manager.R;
import Adapter.CategoryListAdapter;

import java.util.ArrayList;

import Model.CategoryModel;

public class GalleryFragment extends Fragment implements CategoryListAdapter.OnclickInterface {

    private RecyclerView categoryRV;
    private CategoryListAdapter categoryListAdapter;
    private ArrayList<CategoryModel> categoryModels;
    private Button addCategoryBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        categoryRV = root.findViewById(R.id.idRVCategory);
        categoryModels = new ArrayList<>();
        categoryListAdapter = new CategoryListAdapter(categoryModels, getContext(), this);
        categoryRV.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryRV.setAdapter(categoryListAdapter);

        categoryModels.add(new CategoryModel(R.drawable.labour, "Labour"));
        categoryModels.add(new CategoryModel(R.drawable.material, "Material"));
        categoryModels.add(new CategoryModel(R.drawable.transport, "Transport"));
        categoryModels.add(new CategoryModel(R.drawable.equp, "Equipment"));
        categoryModels.add(new CategoryModel(R.drawable.food, "Food & Travel"));
        categoryModels.add(new CategoryModel(R.drawable.desig, "Designer"));
        categoryModels.add(new CategoryModel(R.drawable.own, "Owner"));
        categoryListAdapter.notifyDataSetChanged();
        return root;
    }


    @Override
    public void onClick(int position) {
        String cat = categoryModels.get(position).getCategoryName();
        Toast.makeText(getContext(), cat, Toast.LENGTH_SHORT).show();
    }
}