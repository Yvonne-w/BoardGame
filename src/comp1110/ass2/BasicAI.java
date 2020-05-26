package comp1110.ass2;

public class BasicAI {
    private final AIDifficulty AIDifficulty;
    public int index;
    public String name;

    BasicAI(int index, String name, AIDifficulty aiDifficulty){
        this.index = index;
        this.name = name;
        this.AIDifficulty = comp1110.ass2.AIDifficulty.EASY;
    }
}
