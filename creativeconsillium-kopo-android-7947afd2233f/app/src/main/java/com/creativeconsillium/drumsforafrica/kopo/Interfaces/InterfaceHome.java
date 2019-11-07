package com.creativeconsillium.drumsforafrica.kopo.Interfaces;

/**
 * Interface to handle communication in the Home module.
 *
 * Created by Edward N. Ndukui,
 * on Saturday, 22nd/June/2019,
 * at 10:55AM.
 */
public interface InterfaceHome {

    /**
     * Method to open loans.
     *
     * @param loansCategoryToOpen                               (String)
     */
    void codeToOpenLoans(String loansCategoryToOpen);

    /**
     * Method to open Unpaid Overdue loans.
     */
    void codeToOpenUnpaidOverdueLoans();

    /**
     * Method to open Loan Reports.
     */
    void codeToOpenLoanReports();

    /**
     * Method to open Loan Payment.
     */
    void codeToOpenLoanPayment();

    /**
     * Method to open Invite a Friend.
     */
    void codeToOpenInviteAFriend();

}
