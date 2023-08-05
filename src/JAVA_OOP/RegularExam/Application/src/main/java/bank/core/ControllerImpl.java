package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;


public class ControllerImpl implements Controller {

    private final LoanRepository loans;
    private final Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        switch (type) {
            case "BranchBank":
                bank = new BranchBank(name);
                break;
            case "CentralBank":
                bank = new CentralBank(name);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);
        }
        this.banks.add(bank);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        switch (type) {
            case "StudentLoan":
                loan = new StudentLoan();
                break;
            case "MortgageLoan":
                loan = new MortgageLoan();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }
        this.loans.addLoan(loan);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan returnedLoan = this.loans.findFirst(loanType);
        if (returnedLoan == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }
        for (Bank bank : this.banks) {
            if (bank.getName().equals(bankName)) {
                bank.addLoan(returnedLoan);
                break;
            }
        }
        this.loans.removeLoan(returnedLoan);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        switch (clientType) {
            case "Student":
                for (Bank bank : this.banks) {
                    if (bank.getName().equals(bankName)) {
                        if (bank instanceof BranchBank) {
                            bank.addClient(new Student(clientName, clientID, income));
                        } else {
                            return ConstantMessages.UNSUITABLE_BANK;
                        }
                    }
                }
                break;
            case "Adult":
                for (Bank bank : this.banks) {
                    if (bank.getName().equals(bankName)) {
                        if (bank instanceof CentralBank) {
                            bank.addClient(new Adult(clientName, clientID, income));
                        } else {
                            return ConstantMessages.UNSUITABLE_BANK;
                        }
                    }
                }
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        double allFunds = 0;
        for (Bank bank : this.banks) {
            if (bank.getName().equals(bankName)) {
                allFunds += bank.getClients().stream().mapToDouble(Client::getIncome).sum() + bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
            }
        }
        return String.format(ConstantMessages.FUNDS_BANK, bankName, allFunds);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        this.banks.forEach(bank -> statistics.append(bank.getStatistics()));
        return statistics.toString().trim();
    }
}
