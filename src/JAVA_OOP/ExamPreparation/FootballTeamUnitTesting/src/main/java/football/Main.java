package football;

public class Main {
    public static void main(String[] args) {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Footballer footballerOne = new Footballer("Pesho");
        Footballer footballerTwo = new Footballer("Ivan");
        footballTeam.addFootballer(footballerOne);
        footballTeam.addFootballer(footballerTwo);
        System.out.println(footballTeam.getStatistics());
    }
}
