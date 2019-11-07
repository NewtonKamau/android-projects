package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creativeconsillium.drumsforafrica.kopo.Model.LoansPaymentInstruction;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.List;

public class LoanPaymentInstructionsAdapter extends RecyclerView.Adapter<LoanPaymentInstructionsAdapter.MyViewHolder> {

    private List<LoansPaymentInstruction> loansPaymentInstructionList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView instNumber, instText;

        public MyViewHolder(View view) {
            super(view);
            instNumber = (TextView) view.findViewById(R.id.instNumber);
            instText = (TextView) view.findViewById(R.id.instText);
        }
    }


    public LoanPaymentInstructionsAdapter(List<LoansPaymentInstruction> loansPaymentInstructionList) {
        this.loansPaymentInstructionList = loansPaymentInstructionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_instruction_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LoansPaymentInstruction payment_instruction = loansPaymentInstructionList.get(position);
        holder.instNumber.setText(payment_instruction.getInstNumber());
        holder.instText.setText(payment_instruction.getInstText());

    }

    @Override
    public int getItemCount() {
        return loansPaymentInstructionList.size();
    }
}