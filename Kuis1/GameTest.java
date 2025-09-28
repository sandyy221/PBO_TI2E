package Kuis1;

public class GameTest {
    public static void main(String[] args) {
        Player p1 = new Player("SANDY", 100, 20, 5);
        Monster m1 = new Monster("Goblin", 80, 15, "Goblin");
        BosMonster boss = new BosMonster("Calvates", 200, 30, "Dragon");

        Character[] enemies = {m1, boss};

        int round = 1;
        while (p1.getHealth() > 0 && (m1.getHealth() > 0 || boss.getHealth() > 0)) {
            System.out.println("\n=== Round " + round + " ===");

            Character target = enemies[(int)(Math.random() * enemies.length)];
            if (target.getHealth() > 0) {
                p1.attack(target);
            }
            if (round % 3 == 0) {
                p1.heal();
            }
            for (Character e : enemies) {
                if (e.getHealth() > 0) {
                    e.attack(p1);
                }
            }

            round++;
            if (p1.getHealth() <= 0) {
                System.out.println( p1.getName() + " kalah! Game Over");
                break;
            } else if (m1.getHealth() <= 0 && boss.getHealth() <= 0) {
                System.out.println("Semua monster kalah! " + p1.getName() + " menang!");
                break;
            }
        }
    }
}
