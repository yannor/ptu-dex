package ys.ptu.domain;

public class BaseStats {

    private int baseHp;
    private int baseAtt;
    private int baseDef;
    private int baseSpAtt;
    private int baseSpDef;
    private int baseSpeed;

    public BaseStats(int baseHp, int baseAtt, int baseDef, int baseSpAtt, int baseSpDef, int baseSpeed) {
        this.baseHp = baseHp;
        this.baseAtt = baseAtt;
        this.baseDef = baseDef;
        this.baseSpAtt = baseSpAtt;
        this.baseSpDef = baseSpDef;
        this.baseSpeed = baseSpeed;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseAtt() {
        return baseAtt;
    }

    public void setBaseAtt(int baseAtt) {
        this.baseAtt = baseAtt;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }

    public int getBaseSpAtt() {
        return baseSpAtt;
    }

    public void setBaseSpAtt(int baseSpAtt) {
        this.baseSpAtt = baseSpAtt;
    }

    public int getBaseSpDef() {
        return baseSpDef;
    }

    public void setBaseSpDef(int baseSpDef) {
        this.baseSpDef = baseSpDef;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }
}
