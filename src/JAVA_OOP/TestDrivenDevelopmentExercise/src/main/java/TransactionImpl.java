public class TransactionImpl implements Comparable<TransactionImpl>, Transaction {

    private final int id;
    private TransactionStatus status;
    private final String from;
    private final String to;
    private final double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int compareTo(TransactionImpl o) {
        return 0;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public TransactionStatus getTransactionStatus() {
        return this.status;
    }

    @Override
    public void setTransactionStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public String getFrom() {
        return this.from;
    }

    @Override
    public String getTo() {
        return this.to;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
