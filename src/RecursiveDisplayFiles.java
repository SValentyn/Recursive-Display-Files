import java.io.File;
import java.util.Scanner;

/**
 * A simple implementation of the recursive display in the form of a tree structure of
 * the names of subdirectories and files in a given path.
 *
 * @author Syniuk Valentyn
 */
public class RecursiveDisplayFiles {

    public static void main(String[] args) {
        System.out.print("Enter the full path to the file or directory: ");
        printDirectoriesAndFiles(new Scanner(System.in).nextLine(), 0);
    }

    private static void printDirectoriesAndFiles(String directory, int depth) {

        File file = new File(directory);

        if (depth > 0) {
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.print("|__");
        }

        // Print the file name
        System.out.println(file.getName());

        // Print if directory
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files != null) {
                for (File someFile : files) {
                    printDirectoriesAndFiles(someFile.getPath(), depth + 1);
                }
            }
        }
    }

}
