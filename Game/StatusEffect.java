package Game;

public interface StatusEffect {
    void onTurnStart(Character self); 
    void onTurnEnd(Character self);    
    boolean isExpired();              
}