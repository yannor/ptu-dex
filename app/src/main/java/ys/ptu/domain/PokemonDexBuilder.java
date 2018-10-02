package ys.ptu.domain;

public class PokemonDexBuilder {
    private int sprite;
    private String id;
    private String name;
    private int baseHp;
    private int baseAtt;
    private int baseDef;
    private int baseSpAtt;
    private int baseSpDef;
    private int baseSpeed;

    private TypeEnum type1;
    private TypeEnum type2;

    public PokemonDexBuilder() {
    }

    public PokemonDexBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PokemonDexBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PokemonDexBuilder baseHp(int baseHp) {
        this.baseHp = baseHp;
        return this;
    }

    public PokemonDexBuilder baseAtt(int baseAtt) {
        this.baseAtt = baseAtt;
        return this;
    }

    public PokemonDexBuilder baseDef(int baseDef) {
        this.baseDef = baseDef;
        return this;
    }

    public PokemonDexBuilder baseSpAtt(int baseSpAtt) {
        this.baseSpAtt = baseSpAtt;
        return this;
    }

    public PokemonDexBuilder baseSpDef(int baseSpDef) {
        this.baseSpDef = baseSpDef;
        return this;
    }

    public PokemonDexBuilder baseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
        return this;
    }

    public PokemonDexBuilder type1(TypeEnum type1) {
        this.type1 = type1;
        return this;
    }

    public PokemonDexBuilder type2(TypeEnum type2) {
        this.type2 = type2;
        return this;
    }

    public PokemonDexBuilder sprite(int sprite) {
        this.sprite = sprite;
        return this;
    }

    public PokemonDex build() {
        BaseStats stats = new BaseStats(this.baseHp, this.baseAtt, this.baseDef, this.baseSpAtt, this.baseSpDef, this.baseSpeed);
        return new PokemonDex(this.sprite, this.id, this.name, stats, this.type1, this.type2);
    }
}
