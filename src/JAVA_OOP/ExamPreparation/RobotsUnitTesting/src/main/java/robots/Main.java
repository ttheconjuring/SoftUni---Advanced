package robots;

public class Main {
    public static void main(String[] args) {
        Service service = new Service("new service", 2);
        service.add(new Robot("RobotOne"));
        service.add(new Robot("RobotTwo"));
        System.out.println(service.report());
    }
}
