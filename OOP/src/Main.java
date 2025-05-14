/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author febib
 */
import java.util.Scanner;

class NoteManager {
    private final Note[] notes;
    private int count;

    public NoteManager(int size) {
        notes = new Note[size];
        count = 0;
    }

    public void addNote(Scanner scanner) {
        if (count >= notes.length) {
            System.out.println("Penyimpanan penuh!");
            return;
        }
        System.out.print("Masukkan ID Catatan: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Isi Catatan: ");
        String content = scanner.nextLine();
        notes[count] = new Note(id, content);
        count++;
        System.out.println("Catatan ditambahkan.");
    }

    public void viewNotes() {
        if (count == 0) {
            System.out.println("Belum ada catatan.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(notes[i]);
        }
    }

    public void editNote(Scanner scanner) {
        System.out.print("Masukkan ID catatan yang ingin diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (notes[i].getId() == id) {
                System.out.print("Masukkan isi baru: ");
                String newContent = scanner.nextLine();
                notes[i].setContent(newContent);
                System.out.println("Catatan diperbarui.");
                return;
            }
        }
        System.out.println("Catatan tidak ditemukan.");
    }

    public void deleteNote(Scanner scanner) {
        System.out.print("Masukkan ID catatan yang ingin dihapus: ");
        int id = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            if (notes[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    notes[j] = notes[j + 1];
                }
                notes[count - 1] = null;
                count--;
                System.out.println("Catatan dihapus.");
                return;
            }
        }
        System.out.println("Catatan tidak ditemukan.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteManager manager = new NoteManager(100);

        while (true) {
            System.out.println("\n===== MENU APLIKASI CATATAN =====");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Lihat Catatan");
            System.out.println("3. Ubah Catatan");
            System.out.println("4. Hapus Catatan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> manager.addNote(scanner);
                case 2 -> manager.viewNotes();
                case 3 -> manager.editNote(scanner);
                case 4 -> manager.deleteNote(scanner);
                case 5 -> {
                    System.out.println("Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
