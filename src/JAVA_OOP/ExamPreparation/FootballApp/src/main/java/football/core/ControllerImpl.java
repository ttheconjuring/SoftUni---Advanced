package football.core;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private final SupplementRepository supplement;
    private final Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    public SupplementRepository getSupplement() {
        return this.supplement;
    }

    public Collection<Field> getFields() {
        return this.fields;
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        this.getFields().add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.getSupplement().add(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement desiredSupplement = this.getSupplement().findByType(supplementType);
        if (desiredSupplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        for (Field field : this.getFields()) {
            if (field.getName().equals(fieldName)) {
                field.addSupplement(desiredSupplement);
                break;
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        Field field2;
        switch (playerType) {
            case "Women":
                field2 = this.getFields().stream().filter(field1 -> field1.getName().equals(fieldName)).findFirst().orElse(null);
                if (field2 instanceof ArtificialTurf) {
                    player = new Women(playerName, nationality, strength);
                } else {
                    return String.format(ConstantMessages.FIELD_NOT_SUITABLE);
                }
                break;
            case "Men":
                field2 = this.getFields().stream().filter(field1 -> field1.getName().equals(fieldName)).findFirst().orElse(null);
                if (field2 instanceof NaturalGrass) {
                    player = new Men(playerName, nationality, strength);
                } else {
                    return String.format(ConstantMessages.FIELD_NOT_SUITABLE);
                }
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        for (Field field : this.getFields()) {
            if (field.getName().equals(fieldName)) {
                field.addPlayer(player);
                break;
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        int dragCount = 0;
        for (Field field : this.getFields()) {
            if (field.getName().equals(fieldName)) {
                field.drag();
                dragCount = field.getPlayers().size();
                break;
            }
        }
        return String.format(ConstantMessages.PLAYER_DRAG, dragCount);
    }

    @Override
    public String calculateStrength(String fieldName) {
        int value = 0;
        for (Field field : this.getFields()) {
            if (field.getName().equals(fieldName)) {
                value = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
            }
        }
        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (Field field : this.getFields()) {
            statistics.append(field.getInfo());
        }
        return statistics.toString().trim();
    }
}
