package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians.stream().filter(magician -> magician instanceof Wizard).collect(Collectors.toList());
        List<Magician> blackWidows = magicians.stream().filter(magician -> magician instanceof BlackWidow).collect(Collectors.toList());
        while (true) {
            for (Magician wizard : wizards) {
                for (Magician blackWidow : blackWidows) {
                    blackWidow.takeDamage(wizard.getMagic().fire());
                }
            }
            if (teamIsCompletelyDead(blackWidows)) {
                return "Wizards win!";
            }
            for (Magician blackWidow : blackWidows) {
                for (Magician wizard : wizards) {
                    wizard.takeDamage(blackWidow.getMagic().fire());
                }
            }
            if (teamIsCompletelyDead(wizards)) {
                return "Black widows win!";
            }
        }
    }

    private boolean teamIsCompletelyDead(List<Magician> team) {
        return team.stream().noneMatch(Magician::isAlive);
    }
}
