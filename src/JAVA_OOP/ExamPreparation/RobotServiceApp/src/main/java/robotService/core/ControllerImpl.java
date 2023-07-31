package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.Repository;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private final Repository supplementRepository;
    private final Collection<Service> services;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        switch (type) {
            case "MainService":
                service = new MainService(name);
                break;
            case "SecondaryService":
                service = new SecondaryService(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }
        this.services.add(service);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            default:
                throw new IllegalStateException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplementRepository.addSupplement(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement desiredSupplement = this.supplementRepository.findFirst(supplementType);
        if (desiredSupplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        for (Service service : this.services) {
            if (service.getName().equals(serviceName)) {
                service.addSupplement(desiredSupplement);
                break;
            }
        }
        this.supplementRepository.removeSupplement(desiredSupplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }
        for (Service service : this.services) {
            if (service.getName().equals(serviceName)) {
                if (service instanceof MainService) {
                    if (robotType.equals("MaleRobot")) {
                        service.addRobot(robot);
                    } else {
                        return ConstantMessages.UNSUITABLE_SERVICE;
                    }
                } else if (service instanceof SecondaryService) {
                    if (robotType.equals("FemaleRobot")) {
                        service.addRobot(robot);
                    } else {
                        return ConstantMessages.UNSUITABLE_SERVICE;
                    }
                }
                break;
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        int count = 0;
        for (Service service : this.services) {
            if (service.getName().equals(serviceName)) {
                service.feeding();
                count = service.getRobots().size();
                break;
            }
        }
        return String.format(ConstantMessages.FEEDING_ROBOT, count);
    }

    @Override
    public String sumOfAll(String serviceName) {
        double sum = 0;
        for (Service service : this.services) {
            if (service.getName().equals(serviceName)) {
                sum = service.getRobots().stream().mapToDouble(Robot::getPrice).sum() + service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
                break;
            }
        }
        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder overallStatistic = new StringBuilder();
        for (Service service : this.services) {
            overallStatistic.append(service.getStatistics());
            overallStatistic.append(System.lineSeparator());
        }
        return overallStatistic.toString().trim();
    }
}
