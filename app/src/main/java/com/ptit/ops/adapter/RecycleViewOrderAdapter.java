package com.ptit.ops.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.ops.R;
import com.ptit.ops.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewOrderAdapter extends RecyclerView.Adapter<RecycleViewOrderAdapter.OrderViewHolder> {

    private List<OrderModel> modelList;
    private ItemListener itemListener;

    public RecycleViewOrderAdapter() {
        modelList = new ArrayList<>();
    }

    public List<OrderModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<OrderModel> modelList) {
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
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderModel model = modelList.get(position);
        holder.id.setText(model.getId() + "");
        holder.customerId.setText(model.getCustomerId() + "");
        holder.productId.setText(model.getProductId() + "");
        holder.amount.setText(model.getAmount() + "");
        holder.orderDate.setText(model.getOrderDate());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void reload() {
        notifyDataSetChanged();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView id;
        private TextView customerId;
        private TextView productId;
        private TextView amount;
        private TextView orderDate;

        public OrderViewHolder(@NonNull View view) {
            super(view);
            id = view.findViewById(R.id.textViewIdOrder);
            customerId = view.findViewById(R.id.textViewCustomerIdOrder);
            productId = view.findViewById(R.id.textViewProductIdOrder);
            amount = view.findViewById(R.id.textViewAmountOrder);
            orderDate = view.findViewById(R.id.textViewOrderDate);
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
