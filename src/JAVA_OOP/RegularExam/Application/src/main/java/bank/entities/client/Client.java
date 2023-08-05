package bank.entities.client;

import bank.repositories.LoanRepository;

public interface Client {
    String getName();

    void setName(String name);

    int getInterest();

    double getIncome();

    void increase();
}
