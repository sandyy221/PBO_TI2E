package Game;

public abstract class Enemy extends Character {
    private int threatLevel;

    public Enemy(String name, int health, int attackPower, int threatLevel) {
        super(name, health, attackPower);

        if (threatLevel < 1 || threatLevel > 5) {
            throw new IllegalArgumentException("Threat level harus antara 1-5!");
        }
        this.threatLevel = threatLevel;
    }

    public int getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(int threatLevel) {
        if (threatLevel < 1 || threatLevel > 5) {
            throw new IllegalArgumentException("Threat level harus antara 1-5!");
        }
        this.threatLevel = threatLevel;
    }
}