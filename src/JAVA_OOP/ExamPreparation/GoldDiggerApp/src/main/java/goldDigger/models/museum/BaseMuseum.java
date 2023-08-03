package goldDigger.models.museum;

import java.util.ArrayList;
import java.util.Collection;

public class BaseMuseum implements Museum {

    private Collection<String> exhibits;

    public BaseMuseum() {
        this.setExhibits();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    private void setExhibits() {
        this.exhibits = new ArrayList<>();
    }

}
