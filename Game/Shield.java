package Game;

public class Shield implements StatusEffect {
    private int flatReduce;
    private int duration;

    public Shield(int flatReduce, int duration) {
        this.flatReduce = flatReduce;
        this.duration = duration;
    }

    public int reduceDamage(int incomingDamage) {
        int reduced = incomingDamage - flatReduce;
        return Math.max(reduced, 0);
    }

    @Override
    public void onTurnStart(Character self) {
        System.out.println(self.getName() + " dilindungi Shield (-" + flatReduce +
        " damage, sisa durasi: " + duration + ")");
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