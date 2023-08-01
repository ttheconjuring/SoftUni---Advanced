package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    private void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (this.getProtection() - points >= 0) {
            this.setProtection(this.getProtection() - points);
        } else {
            this.setProtection(0);
            int damageToTransfer = points - this.getProtection();
            if (this.getHealth() - damageToTransfer >= 0) {
                this.setHealth(this.getHealth() - damageToTransfer);
            } else {
                this.setHealth(0);
            }
            // this.setHealth(Math.max(this.getHealth() - damageToTransfer, 0));
        }
    }

    @Override
    public String toString() {
        String result = String.format("%s: %s%n", this.getClass().getSimpleName(), this.getUsername()) +
                String.format("Health: %d%n", this.getHealth()) +
                String.format("Protection: %d%n", this.getProtection()) +
                String.format("Magic: %s%n", this.getMagic().getName());
        return result.trim();
    }

}
