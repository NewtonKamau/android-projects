package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creativeconsillium.drumsforafrica.kopo.Model.LoansPaidDetail;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.List;

public class LoansPaidDetailAdapter extends RecyclerView.Adapter<LoansPaidDetailAdapter.MyViewHolder> {

    private List<LoansPaidDetail> loansPaidDetailList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView paidDate, paidAmount, paidBorrowed, paidInterest;

        public MyViewHolder(View view) {
            super(view);
            paidDate = (TextView) view.findViewById(R.id.paidDate);
            paidAmount = (TextView) view.findViewById(R.id.paidAmount);
            paidBorrowed = (TextView) view.findViewById(R.id.paidBorrowed);
            paidInterest = (TextView) view.findViewById(R.id.paidInterest);
        }
    }


    public LoansPaidDetailAdapter(List<LoansPaidDetail> loansPaidDetailList) {
        this.loansPaidDetailList = loansPaidDetailList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loans_paid_detail_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LoansPaidDetail loansPaidDetail = loansPaidDetailList.get(position);
        holder.paidDate.setText(loansPaidDetail.getPaidDate());
        holder.paidAmount.setText(loansPaidDetail.getPaidAmount());
        holder.paidBorrowed.setText(loansPaidDetail.getPaidBorrowed());
        holder.paidInterest.setText(loansPaidDetail.getPaidInterest());
    }

    @Override
    public int getItemCount() {
        return loansPaidDetailList.size();
    }
}