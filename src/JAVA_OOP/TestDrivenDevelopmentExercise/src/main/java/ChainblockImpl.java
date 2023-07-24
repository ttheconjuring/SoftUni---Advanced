import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private final Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new HashMap<>();
    }

    public int getCount() {
        return this.transactionMap.size();
    }

    public void add(Transaction transaction) {
        this.transactionMap.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.transactionMap.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        validateId(id);
        this.transactionMap.get(id).setTransactionStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        validateId(id);
        this.transactionMap.remove(id);
    }

    public Transaction getById(int id) {
        validateId(id);
        return this.transactionMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> result = this.transactionMap.values().stream().filter(transaction -> transaction.getTransactionStatus().equals(status)).sorted(Comparator.comparing(Transaction::getAmount)).collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private void validateId(int id) {
        if (id < 0 || id >= this.transactionMap.size()) {
            throw new IllegalArgumentException();
        }
    }
}
