package Game;

public class PiercingStrike implements Skill {
    private double multiplier;

    public PiercingStrike(double multiplier) {
        if (multiplier < 1.0) throw new IllegalArgumentException("Multiplier minimal 1.0");
        this.multiplier = multiplier;
    }

    @Override
    public String name() {
        return "Piercing Strike x" + multiplier;
    }

    @Override
    public void apply(Character self, Character target) {
        int baseDamage = self.getAttackPower();
        int finalDamage = (int) (baseDamage * multiplier);
        System.out.println(self.getName() + " menggunakan " + name() + "! Damage: " + finalDamage);
        target.takeDamage(finalDamage);
    }
}