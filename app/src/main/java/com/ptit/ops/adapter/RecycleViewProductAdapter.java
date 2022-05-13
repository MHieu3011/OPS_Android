package com.ptit.ops.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.ops.R;
import com.ptit.ops.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewProductAdapter extends RecyclerView.Adapter<RecycleViewProductAdapter.ProductViewHolder> {

    private List<ProductModel> modelList;
    private ItemListener itemListener;

    public RecycleViewProductAdapter() {
        modelList = new ArrayList<>();
    }

    public List<ProductModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<ProductModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    public ItemListener getItemListener() {
        return itemListener;
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel model = modelList.get(position);
        holder.id.setText(model.getId() + "");
        holder.price.setText(model.getPrice() + "");
        holder.type.setText(model.getType());
        holder.totalQuantity.setText(model.getTotalQuantity() + "");

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void reload() {
        notifyDataSetChanged();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView id;
        private TextView price;
        private TextView type;
        private TextView totalQuantity;

        public ProductViewHolder(@NonNull View view) {
            super(view);
            id = view.findViewById(R.id.textViewIdProduct);
            price = view.findViewById(R.id.textViewPriceProduct);
            type = view.findViewById(R.id.textViewTypeProduct);
            totalQuantity = view.findViewById(R.id.textViewTotalQuantityProduct);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemListener != null) {
                itemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemListener {
        void onItemClick(View view, int position);
    }
}
