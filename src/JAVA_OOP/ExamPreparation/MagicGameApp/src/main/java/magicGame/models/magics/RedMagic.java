package magicGame.models.magics;

public class RedMagic extends MagicImpl {
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() - 1 >= 0) {
            super.setBulletsCount(getBulletsCount() - 1);
            return 1;
        }
        return 0;
    }
}
