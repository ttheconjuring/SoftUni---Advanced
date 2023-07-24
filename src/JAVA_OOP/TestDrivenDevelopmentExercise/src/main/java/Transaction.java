public interface Transaction {

    int getId();

    TransactionStatus getTransactionStatus();

    void setTransactionStatus(TransactionStatus status);

    String getFrom();

    String getTo();

    double getAmount();
}
