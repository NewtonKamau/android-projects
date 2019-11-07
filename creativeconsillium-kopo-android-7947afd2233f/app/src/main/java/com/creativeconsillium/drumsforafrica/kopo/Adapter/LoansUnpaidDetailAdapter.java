package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creativeconsillium.drumsforafrica.kopo.Model.LoansUnpaidDetail;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.List;

public class LoansUnpaidDetailAdapter extends RecyclerView.Adapter<LoansUnpaidDetailAdapter.MyViewHolder> {

    private List<LoansUnpaidDetail> loansUnpaidDetailList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView paidDue, paidAmount, paidBorrowed, paidInterest;

        public MyViewHolder(View view) {
            super(view);
            paidDue = (TextView) view.findViewById(R.id.unpaidDue);
            paidAmount = (TextView) view.findViewById(R.id.unpaidAmount);
            paidBorrowed = (TextView) view.findViewById(R.id.unpaidBorrowed);
            paidInterest = (TextView) view.findViewById(R.id.unpaidInterest);
        }
    }


    public LoansUnpaidDetailAdapter(List<LoansUnpaidDetail> loansUnpaidList) {
        this.loansUnpaidDetailList = loansUnpaidList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loans_unpaid_detail_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LoansUnpaidDetail loansUnpaidDetail = loansUnpaidDetailList.get(position);
        holder.paidDue.setText(loansUnpaidDetail.getPaidDue());
        holder.paidAmount.setText(loansUnpaidDetail.getPaidAmount());
        holder.paidBorrowed.setText(loansUnpaidDetail.getPaidBorrowed());
        holder.paidInterest.setText(loansUnpaidDetail.getPaidInterest());
    }

    @Override
    public int getItemCount() {
        return loansUnpaidDetailList.size();
    }
}