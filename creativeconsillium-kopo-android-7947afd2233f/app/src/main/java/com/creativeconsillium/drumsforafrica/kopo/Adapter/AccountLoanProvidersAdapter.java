package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativeconsillium.drumsforafrica.kopo.Model.AccountLoanProviderModel;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.List;

public class AccountLoanProvidersAdapter extends RecyclerView.Adapter<AccountLoanProvidersAdapter.MyViewHolder> {

    private List<AccountLoanProviderModel> accountLoanProviderModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, actionText;
        public ImageView providerImg;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            providerImg = (ImageView) view.findViewById(R.id.providerImg);
            actionText = (TextView) view.findViewById(R.id.actionText);
        }
    }


    public AccountLoanProvidersAdapter(List<AccountLoanProviderModel> account_loan_providersList) {
        this.accountLoanProviderModelList = account_loan_providersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_loan_provider_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AccountLoanProviderModel accountLoanProviderModel = accountLoanProviderModelList.get(position);
        holder.title.setText(accountLoanProviderModel.getTitle());
        holder.providerImg.setImageResource(accountLoanProviderModel.getProviderImg());
        holder.actionText.setText(accountLoanProviderModel.getActionText());
    }

    @Override
    public int getItemCount() {
        return accountLoanProviderModelList.size();
    }
}