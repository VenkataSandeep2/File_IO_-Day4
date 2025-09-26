import java.io.*;
import java.util.Scanner;
class Day4

{
	private static final String FILE_NAME = "notes.txt";
    	private static Scanner sc = new Scanner(System.in);

    	public static void main(String[] args) {
        boolean running = true;

        while (running) {
            	System.out.println("\n=== Notes App (File I/O) ===");
        	System.out.println("1. Add Note");
            	System.out.println("2. View Notes");
            	System.out.println("3. Exit");
            	System.out.print("Choose an option: ");

            	int choice = sc.nextInt();
            	sc.nextLine(); // consume newline
		switch (choice) {
                case 1 -> addNote();
                case 2 -> viewNotes();
                case 3 -> 
			{
                    	running = false;
                    	System.out.println("👋 Exiting Notes App. Goodbye!");
                }
                default -> System.out.println("⚠ Invalid choice! Try again.");
            }	
        }
}
private static void addNote() 
{
        System.out.print("Enter your note: ");
	String note = sc.nextLine();

        try (FileWriter fw = new FileWriter(FILE_NAME, true);
        BufferedWriter bw = new BufferedWriter(fw)) 
		{

            	bw.write(note);
            	bw.newLine();
            	System.out.println("✅ Note saved successfully!");

        	}
		 catch (IOException e) 
			{
            		System.out.println("⚠ Error writing to file: " + e.getMessage());
        		}
}
 	private static void viewNotes() 
	{
        File file = new File(FILE_NAME);

        if (!file.exists()) 
	{
            System.out.println("⚠ No notes found. Add a note first!");
            return;
        }

        System.out.println("\n--- Your Notes ---");
        	try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) 
	{
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) 
	 {
                System.out.println(count++ + ". " + line);
         }

        }
	 catch (IOException e) 
	{
            System.out.println("⚠ Error reading from file: " + e.getMessage());
        }
        }
}

