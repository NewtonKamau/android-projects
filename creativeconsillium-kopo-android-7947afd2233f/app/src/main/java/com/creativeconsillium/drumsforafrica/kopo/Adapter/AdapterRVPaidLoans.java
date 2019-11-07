package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.creativeconsillium.drumsforafrica.kopo.Interfaces.InterfaceLoans;
import com.creativeconsillium.drumsforafrica.kopo.Model.ModelPaidLoans;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.List;

public class AdapterRVPaidLoans extends RecyclerView.Adapter<AdapterRVPaidLoans.RVPaidLoansViewHolder> {

    private InterfaceLoans interLoans;

    private List<ModelPaidLoans> lsPaidLoans;


    public AdapterRVPaidLoans(@NonNull Context context, @NonNull List<ModelPaidLoans> listPaidLoans) {

        try {
            interLoans = (InterfaceLoans) context;
        } catch(ClassCastException ccex) {
            throw new ClassCastException("InterfaceLoans is NOT Implemented! ccex: " + ccex);
        }

        this.lsPaidLoans = listPaidLoans;

    }


    @NonNull
    @Override
    public RVPaidLoansViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_rv_paid_loans, parent, false);

        return new RVPaidLoansViewHolder(vItemView, interLoans);
    }

    @Override
    public void onBindViewHolder(@NonNull RVPaidLoansViewHolder holder, int position) {

        ModelPaidLoans modelPaidLoans = lsPaidLoans.get(position);
        holder.paidProvider.setImageResource(modelPaidLoans.getPaidProvider());
        holder.paidAmount.setText(modelPaidLoans.getPaidAmount());
        holder.paidNumber.setText(modelPaidLoans.getPaidNumber());

    }

    @Override
    public int getItemCount() {
        return lsPaidLoans.size();
    }



    /**
     * RecyclerView.ViewHolder class for RecyclerView.Adapter Paid Loans.
     */
    static class RVPaidLoansViewHolder extends RecyclerView.ViewHolder {

        private InterfaceLoans interLoans;

        private RelativeLayout relayRowItem;

        private ImageView paidProvider;
        private TextView paidAmount, paidNumber;


        private RVPaidLoansViewHolder(@NonNull View itemView, @Nullable InterfaceLoans interfaceLoans) {
            super(itemView);

            this.interLoans = interfaceLoans;

            paidProvider = (ImageView) itemView.findViewById(R.id.paidProvider);
            paidAmount = (TextView) itemView.findViewById(R.id.paidAmount);
            paidNumber = (TextView) itemView.findViewById(R.id.paidNumber);

            relayRowItem = (RelativeLayout) itemView.findViewById(R.id.relayPaidLoansRowItem);
            relayRowItem.setOnClickListener(clkPaidLoanItem);

        }


        /**
         * View.OnClickListener interface for handling clicks on RecyclerView items.
         *
         * Called In:
         *          - this.RVPaidLoansViewHolder();
         */
        private View.OnClickListener clkPaidLoanItem = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.e("AdapterRVPaidLoans", "clkPaidLoanItem - onClick() - CALLED!");   //  TODO: For Testing ONLY

                if (interLoans != null) {
                    interLoans.codeToOpenPaidLoanDetail();
                }

            }

        };

    }

}