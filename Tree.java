import java.io.File;

public class Tree {

    public static void main(String[] args) {
        printTree("/Users/ivan/Desktop/Обучение/GeekBrains/Java Core/Lesson05/Lesson05", "");
    }

    static void printTree(String directoryPath, String indent) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Директория не существует: " + directory.getAbsolutePath());
            return;
        }

        
        System.out.println(indent + "+ " + directory.getName() + "/");
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Ошибка чтения содержимого директории");
            return;
        }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isFile()) {
                System.out.println(indent + "  |- " + file.getName());
            } else if (file.isDirectory()) {
                String childIndent = indent + "  |";
                if (i == files.length - 1) {
                    childIndent = indent + "   ";
                }
                printTree(file.getAbsolutePath(), childIndent);
            }
        }
    }
}
