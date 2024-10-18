import java.util.Scanner;

public class CaesarCipher {

    // для шифрования текста
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // идем по каждому символу текста
        for (char character : text.toCharArray()) {
            // шифруем только буквы
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'а' : 'А';
                // сдвигаем символ и добавляем к результату
                character = (char) ((character - base + shift) % 32 + base);
            }
            result.append(character);
        }

        return result.toString();
    }

    // метод для расшифровки текста
    public static String decrypt(String text, int shift) {
        return encrypt(text, 32 - shift); // расшифровка - это шифрование с отрицательным сдвигом
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст для шифрования: ");
        String text = scanner.nextLine();

        System.out.print("Введите сдвиг: ");
        int shift = scanner.nextInt();

        String encryptedText = encrypt(text, shift);
        System.out.println("Зашифрованный текст: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }
}
