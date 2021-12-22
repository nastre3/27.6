import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class OpenException extends Exception {
    OpenException(String message) {
        super(message);
    }
}

public class Homework {
    public static void main(String[] args) {
        try {
            readingFromFile("Homework/src/test.txt");
            System.out.println("Чтение из файла успешно");
        } catch (OpenException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readingFromFile(String file) throws OpenException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (FileNotFoundException e) {
            throw new OpenException("Ошибка! Файл не найден! " + e.getMessage());
        } catch (IOException ex) {
            throw new OpenException("Возникла ошибка при открытии");
        }
    }
}
