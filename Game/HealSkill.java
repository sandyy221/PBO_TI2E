package Game;

public class HealSkill implements Skill {
    private int amount;

    public HealSkill(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Jumlah heal harus > 0");
        this.amount = amount;
    }

    @Override
    public String name() {
        return "Heal +" + amount;
    }

    @Override
    public void apply(Character self, Character target) {
        int newHealth = self.getHealth() + amount;
        if (newHealth > 100) newHealth = 100;

        self.setHealth(newHealth);
        System.out.println(self.getName() + " menggunakan " + name() +
        "! HP sekarang: " + self.getHealth());
    }
}