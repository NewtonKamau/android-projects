package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativeconsillium.drumsforafrica.kopo.Model.ReportProvider;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.List;

public class ReportProvidersAdapter extends RecyclerView.Adapter<ReportProvidersAdapter.MyViewHolder> {

    private List<ReportProvider> reportProviderList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView provNumber, provAmount, provLoans, provInterest;
        public ImageView provImg;

        public MyViewHolder(View view) {
            super(view);
            provNumber = (TextView) view.findViewById(R.id.provNumber);
            provAmount = (TextView) view.findViewById(R.id.provAmount);
            provLoans = (TextView) view.findViewById(R.id.provLoans);
            provInterest = (TextView) view.findViewById(R.id.provInterest);
            provImg = (ImageView) view.findViewById(R.id.provImg);
        }
    }


    public ReportProvidersAdapter(List<ReportProvider> reportProviderList) {
        this.reportProviderList = reportProviderList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reports_loan_providers_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ReportProvider loanProvider = reportProviderList.get(position);
        holder.provNumber.setText(loanProvider.getProvNumber());
        holder.provAmount.setText(loanProvider.getProvAmount());
        holder.provLoans.setText(loanProvider.getProvLoans());
        holder.provInterest.setText(loanProvider.getProvInterest());
        holder.provImg.setImageResource(loanProvider.getProvImg());
    }

    @Override
    public int getItemCount() {
        return reportProviderList.size();
    }
}