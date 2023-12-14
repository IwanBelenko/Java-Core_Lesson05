import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Backup {

    public static void main(String[] args) {
        createBackup("/Users/ivan/Desktop/Обучение/GeekBrains/Java Core/Lesson05/Lesson05");
    }

    static void createBackup(String directoryPath) {
        File directory = new File(directoryPath);
        File backupDir = new File(directory, "backup");

        if (!backupDir.exists()) {
            backupDir.mkdir();
            System.out.println("Создана папка для резервной копии: " + backupDir.getAbsolutePath());
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Ошибка чтения содержимого директории");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String backupFilePath = backupDir.getAbsolutePath() + File.separator + file.getName();
                try {
                    Files.copy(file.toPath(), new File(backupFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Создана резервная копия файла: " + backupFilePath);
                } catch (IOException e) {
                    System.out.println("Ошибка при создании резервной копии файла: " + file.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }
    }
}