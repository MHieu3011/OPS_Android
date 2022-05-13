package com.ptit.ops.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.ops.R;
import com.ptit.ops.adapter.RecycleViewProductAdapter;
import com.ptit.ops.api.ProductAPI;
import com.ptit.ops.model.ProductModel;
import com.ptit.ops.response.ProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {

    private RecycleViewProductAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewProduct);
        adapter = new RecycleViewProductAdapter();
        adapter.reload();

        ProductAPI.api.findAll().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                ProductResponse productResponse = response.body();
                List<ProductModel> modelList = productResponse.getProducts();
                adapter.setModelList(modelList);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Call API error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
