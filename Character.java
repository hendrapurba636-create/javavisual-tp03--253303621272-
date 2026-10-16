
package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi.
 * Menggunakan encapsulation melalui atribut private.
 */
public class Character {

    // Atribut
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Constructor 1: membuat karakter baru
    public Character(String name, CharacterType type, int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1"
            );
        }

        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;
    }

    // Constructor 2: memuat karakter yang sudah memiliki data
    public Character(
            int id,
            String name,
            CharacterType type,
            int level,
            int hitPoints,
            int attackPower) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;
    }

    // Menghitung HP berdasarkan level
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    // Menghitung attack berdasarkan level
    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    // Setter ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter level dengan validasi dan perhitungan ulang
    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1"
            );
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    // Setter mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    // Mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Representasi teks karakter
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana +
               '}';
    }
}
