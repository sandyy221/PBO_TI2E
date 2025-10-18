package Game;

public class Regen implements StatusEffect {
    private int healPerTurn;
    private int duration;

    public Regen(int healPerTurn, int duration) {
        this.healPerTurn = healPerTurn;
        this.duration = duration;
    }

    @Override
    public void onTurnStart(Character self) {
        int newHealth = self.getHealth() + healPerTurn;
        if (newHealth > 100) newHealth = 100;
        self.setHealth(newHealth);
        System.out.println(self.getName() + " mendapatkan efek Regen +" + healPerTurn +
        " HP (sisa durasi: " + duration + ")");
    }

    @Override
    public void onTurnEnd(Character self) {
        duration--;
    }

    @Override
    public boolean isExpired() {
        return duration <= 0;
    }
}