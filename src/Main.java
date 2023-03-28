import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source file: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination file: ");
        String desPath = scanner.nextLine();
        File sourceFile = new File(sourcePath);
        File desFile = new File(desPath);
        try {
            copyFileUsingJava7Files(sourceFile, desFile);
//            copyFileUsingStream(sourceFile,desFile);
            System.out.printf("Copy completed");
        } catch (IOException errException) {
            System.out.printf("Can't copy that file  ");
            System.out.printf(errException.getMessage());
        }
    }

    static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
