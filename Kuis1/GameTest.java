package Kuis1;

public class GameTest {
    public static void main(String[] args) {
        Player p1 = new Player("HeroIrsyad", 100, 20, 5);
        Monster m1 = new Monster("Goblin", 80, 15, "Goblin");
        Monster m2 = new Monster("Dragon", 200, 30, "Dragon");

        Character[] characters = { p1, m1, m2 };
        for (Character c : characters) {
            c.attack(p1);
        }
    }
}
