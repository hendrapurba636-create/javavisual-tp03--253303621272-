
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");

        // Membuat tiga karakter awal
        Character hero = new Character(
            "Arjuna", CharacterType.WARRIOR, 5
        );

        Character wizard = new Character(
            "Merlin", CharacterType.MAGE, 3
        );

        Character scout = new Character(
            "Athena", CharacterType.ARCHER, 4
        );

        // Menampilkan tiga karakter
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        // Demo level up
        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");

        hero.setLevel(hero.getLevel() + 1);

        System.out.println("After level up: " + hero);

        // Informasi karakter
        System.out.println();
        System.out.println(">> Nama karakter: " + hero.getName());
        System.out.println(">> Jenis karakter: " + hero.getType());
        System.out.println(">> HP saat ini: " + hero.getHitPoints());

        // Mini-Challenge: membuat karakter baru
        System.out.println();
        System.out.println("=== Mini-Challenge ===");

        Character healer = new Character(
            "Luna", CharacterType.HEALER, 2
        );

        healer.setMana(50);

        System.out.println("Karakter baru: " + healer);
        System.out.println(
            "Apakah Luna masih hidup? " + healer.isAlive()
        );

        // Menguji validasi mana negatif
        try {
            healer.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: " + e.getMessage());
        }
    }
}
