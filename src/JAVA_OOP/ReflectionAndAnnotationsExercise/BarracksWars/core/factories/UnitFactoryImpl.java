package JAVA_OOP.ReflectionAndAnnotationsExercise.BarracksWars.core.factories;


import JAVA_OOP.ReflectionAndAnnotationsExercise.BarracksWars.interfaces.Unit;
import JAVA_OOP.ReflectionAndAnnotationsExercise.BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
        // TODO: implement for problem 3
        try {
            Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> constructor = unitClass.getDeclaredConstructor();
            return (Unit) constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        throw new ExecutionControl.NotImplementedException("message");
    }
}
