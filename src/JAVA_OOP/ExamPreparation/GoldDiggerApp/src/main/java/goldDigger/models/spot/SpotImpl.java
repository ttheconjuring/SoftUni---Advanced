package goldDigger.models.spot;

import goldDigger.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SpotImpl implements Spot {

    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name, String... exhibits) {
        this.setName(name);
        this.setExhibits(Arrays.asList(exhibits));
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    private void setExhibits(Collection<String> exhibits) {
        this.exhibits = exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
