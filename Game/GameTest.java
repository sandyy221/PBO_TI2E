package Game;

import java.util.List;

public class GameTest {
    public static void main(String[] args) {
        
        Player p1 = new Player("SANDY", 100, 20, 5);
        p1.addSkill(new HealSkill(25));
        p1.addSkill(new PiercingStrike(1.5));
        p1.addEffect(new Regen(10, 3));
        p1.addEffect(new Shield(5, 2));

        Monster m1 = new Monster("Goblin", 80, 15, 2, "Goblin");
        BosMonster boss = new BosMonster("Calvates", 200, 30, 5, "Dragon");

        m1.setAttackStrategy(new FixedStrategy());
        boss.setAttackStrategy(new LevelScaledStrategy());

        BattleSimulator simulator = new BattleSimulator(p1, List.of(m1, boss));
        simulator.startBattle();
    }
}