package com.ptit.ops.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.ops.R;
import com.ptit.ops.model.CustomerModel;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewCustomerAdapter extends RecyclerView.Adapter<RecycleViewCustomerAdapter.CustomerViewHolder> {

    private List<CustomerModel> modelList;
    private ItemListener itemListener;

    public RecycleViewCustomerAdapter() {
        modelList = new ArrayList<>();
    }

    public List<CustomerModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<CustomerModel> modelList) {
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
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        CustomerModel model =modelList.get(position);
        holder.id.setText(model.getId()+"");
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddress());
        holder.phone.setText(model.getPhone());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class CustomerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView id;
        private TextView name;
        private TextView address;
        private TextView phone;

        public CustomerViewHolder(@NonNull View view) {
            super(view);
            id = view.findViewById(R.id.textViewIdCustomer);
            name = view.findViewById(R.id.textViewNameCustomer);
            address = view.findViewById(R.id.textViewAddressCustomer);
            phone = view.findViewById(R.id.textViewPhoneCustomer);
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
