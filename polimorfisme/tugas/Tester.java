package polimorfisme.tugas;

public class Tester {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        System.out.println("Walking Zombie " + wz.getZombieInfo());
        System.out.println("Jumping Zombie " + jz.getZombieInfo());
        System.out.println("Barrier Strength = " + b.getBarrierInfo());

        System.out.println("-------------------------");

        for(int i=0; i<4; i++){
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);
        }
        System.out.println("Walking Zombie " + wz.getZombieInfo());
        System.out.println("Jumping Zombie " + jz.getZombieInfo());
        System.out.println("Barrier Strength = " + b.getBarrierInfo());
    }
}