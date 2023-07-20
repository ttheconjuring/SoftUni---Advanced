package p06_TirePressureMinitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

public class AlarmTest {

    @Test
    public void testCheckShouldNotChangeTheStateOfTheAlarmWhenThePressureIsInRange() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19D);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckShouldChangeTheStateOfTheAlarmToTrueWhenThePressureIsOverTheLimit() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22D);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheckShouldChangeTheStateOfTheAlarmToTrueWhenThePressureIsUnderTheLimit() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16D);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

}
