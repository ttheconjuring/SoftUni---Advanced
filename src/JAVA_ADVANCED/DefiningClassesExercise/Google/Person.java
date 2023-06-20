package DefiningClassesExercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;

    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person(String name) {
        setName(name);
        setCompany(null);
        setPokemonList(new ArrayList<>());
        setParentsList(new ArrayList<>());
        setChildrenList(new ArrayList<>());
        setCar(null);
    }

    public static class Company {
        private String name;
        private String department;
        private String salary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public Company() {
        }

        public Company(String name, String department, String salary) {
            setName(name);
            setDepartment(department);
            setSalary(salary);
        }
    }

    public static class Pokemon {
        private String name;
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Pokemon() {
        }

        public Pokemon(String name, String type) {
            setName(name);
            setType(type);
        }
    }

    public static class Parents {
        private String name;
        private String birthday;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Parents() {
        }

        public Parents(String name, String birthday) {
            setName(name);
            setBirthday(birthday);
        }
    }

    public static class Children {
        private String name;
        private String birthday;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Children() {
        }

        public Children(String name, String birthday) {
            setName(name);
            setBirthday(birthday);
        }
    }

    public static class Car {
        private String model;
        private String speed;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public Car() {
        }

        public Car(String model, String speed) {
            setModel(model);
            setSpeed(speed);
        }
    }

}
