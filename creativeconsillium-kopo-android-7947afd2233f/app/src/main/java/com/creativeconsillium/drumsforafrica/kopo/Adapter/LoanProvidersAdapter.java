package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativeconsillium.drumsforafrica.kopo.Model.LoanProvider;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.List;

public class LoanProvidersAdapter extends RecyclerView.Adapter<LoanProvidersAdapter.MyViewHolder> {

    private List<LoanProvider> loanProviderList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView providerImg, tickImg;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            providerImg = (ImageView) view.findViewById(R.id.providerImg);
            tickImg = (ImageView) view.findViewById(R.id.tickImg);
        }
    }


    public LoanProvidersAdapter(List<LoanProvider> loan_providersList) {
        this.loanProviderList = loan_providersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loan_provider_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LoanProvider loanProvider = loanProviderList.get(position);
        holder.title.setText(loanProvider.getTitle());
        holder.providerImg.setImageResource(loanProvider.getProviderImg());
        holder.tickImg.setImageResource(loanProvider.getTickImg());
    }

    @Override
    public int getItemCount() {
        return loanProviderList.size();
    }
}