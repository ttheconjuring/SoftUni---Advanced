package bank.entities.client;

public class Student extends BaseClient {

    // private static final int DEFAULT_INTEREST_PERCENTAGE = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, 2, income);
    }

    @Override
    public void increase() {
        this.setInterest(this.getInterest() + 1);
    }
}
