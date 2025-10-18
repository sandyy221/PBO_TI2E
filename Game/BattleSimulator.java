package Game;

import java.util.List;

public class BattleSimulator {
    private Player player;
    private List<Enemy> enemies;
    private int round = 1;

    public BattleSimulator(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    public void startBattle() {
        System.out.println("\n===== MULAI PERTARUNGAN =====");
        System.out.println("Pemain: " + player.getName());
        System.out.println("Lawan: ");
        for (Enemy e : enemies) {
            System.out.println("- " + e.getName() + " (" + e.getClass().getSimpleName() + ")");
        }

        while (player.isAlive() && enemies.stream().anyMatch(Enemy::isAlive)) {
            System.out.println("\n=== ROUND " + round + " ===");

            Enemy target = pilihMusuh();
            if (target != null) {
                player.performTurn(target);
            }
            if (round % 3 == 0) {
                player.heal();
            }
            for (Enemy e : enemies) {
                if (e.isAlive()) {
                    e.performTurn(player);
                }
            }
            tampilkanStatus();
            if (!player.isAlive()) {
                System.out.println(player.getName() + " kalah! Game Over!");
                break;
            }

            if (enemies.stream().noneMatch(Enemy::isAlive)) {
                System.out.println("\nSemua musuh dikalahkan! " + player.getName() + " menang!");
                break;
            }

            round++;
        }

        System.out.println("\n===== PERTARUNGAN SELESAI =====");
    }

    private Enemy pilihMusuh() {
        return enemies.stream().filter(Enemy::isAlive)
                .skip((int) (Math.random() * enemies.size()))
                .findFirst()
                .orElse(null);
    }

    private void tampilkanStatus() {
        System.out.println("\n-- STATUS SAAT INI --");
        System.out.println(player.getName() + " | HP: " + player.getHealth());
        for (Enemy e : enemies) {
            System.out.println(e.getName() + " | HP: " + e.getHealth());
        }
    }
}