package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseBank implements Bank {

    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    protected BaseBank(String name, int capacity) {
        this.setName(name);
        // this.setCapacity(capacity);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    /* private int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }*/

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }


    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (this.getClients().size() < this.capacity) {
            this.getClients().add(client);
            return;
        }
        throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT);
    }

    @Override
    public void removeClient(Client client) {
        this.getClients().remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.getLoans().add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        // return this.getLoans().stream().mapToInt(Loan::getInterestRate).sum();
        int sum = 0;
        for (Loan loan : this.getLoans()) {
            sum += loan.getInterestRate();
        }
        return sum;
    }

    @Override
    public String getStatistics() {
        return String.format("Name: %s, Type: %s", this.getName(), this.getClass().getSimpleName()) + System.lineSeparator() +
                String.format("Clients: %s", !this.getClients().isEmpty() ? this.getClients().stream().map(Client::getName).collect(Collectors.joining(", ")).trim() : "none") + System.lineSeparator() +
                String.format("Loans: %s, Sum of interest rates: %s", this.getLoans().size(), this.sumOfInterestRates()) + System.lineSeparator();
    }
}
