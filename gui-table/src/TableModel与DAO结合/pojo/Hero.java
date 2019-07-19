package TableModel与DAO结合.pojo;

public class Hero {
    public Integer id;
    public String name;
    public Float hp;
    public Integer damage;

    public Hero(String name) {
        this.name = name;
    }

    public Hero(Integer id, String name, Float hp, Integer damage) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
}
