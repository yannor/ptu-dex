package ys.ptu.domain;

import com.google.firebase.database.Exclude;

public class PokemonDex {

    private int sprite;
    private String id;
    private String naam;

    private BaseStats base;

    private TypeEnum type1;
    private TypeEnum type2;

    public PokemonDex() {
    }

    public PokemonDex(int sprite, String id, String name, BaseStats stats, TypeEnum type1, TypeEnum type2) {
        this.sprite = sprite;
        this.id = id;
        this.naam = name;
        this.base = stats;
        this.type1 = type1;
        this.type2 = type2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String name) {
        this.naam = name;
    }

    public int getSprite() {
        return sprite;
    }

    public void setSprite(int sprite) {
        this.sprite = sprite;
    }

    @Exclude
    public TypeEnum getType1AsEnum(){
        return type1;
    }

    public String getType1(){
        if (type1 == null){
            return null;
        } else {
            return type1.name();
        }
    }

    public void setType1(String type){
        if (type == null){
            type1 = null;
        } else {
            this.type1 = TypeEnum.valueOf(type);
        }
    }

    @Exclude
    public TypeEnum getType2AsEnum(){
        return type2;
    }

    public String getType2(){
        if (type2 == null){
            return null;
        } else {
            return type2.name();
        }
    }

    public void setType2(String type){
        if (type == null){
            type2 = null;
        } else {
            this.type2 = TypeEnum.valueOf(type.toUpperCase());
        }
    }
}
