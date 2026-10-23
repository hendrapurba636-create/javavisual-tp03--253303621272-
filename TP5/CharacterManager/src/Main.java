
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // 3 karakter awal
        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        // 2 karakter tambahan untuk TP8
        manager.addCharacter(
                new Character("Bima", CharacterType.WARRIOR, 7));

        manager.addCharacter(
                new Character("Luna", CharacterType.MAGE, 6));

        // Menampilkan GUI
        SwingUtilities.invokeLater(() -> {
            new MainWindow(manager);
        });
    }
}
