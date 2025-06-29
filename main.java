import java.io.*;
import java.util.*;


class FileOps {
    public static void main(String[] args) {
        System.out.println("File Operations Demo");
        System.out.println("===================");
        
        try {
            writeToFile(); // write 

            readFromFile(); // read

            modifyFile(); // modify
            
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
    
    // Create a file and write some text to it
    static void writeToFile() throws IOException {
        System.out.println("\n1. Writing to file...");
        
        FileWriter fw = new FileWriter("data.txt");
        fw.write("Hello World!\n");
        fw.write("This is line 2\n");
        fw.write("Some numbers: 10, 20, 30\n");
        fw.write("End of file\n");
        fw.close();
        
        System.out.println("Done writing to data.txt");
    }
    
    // Read the file line by line
    static void readFromFile() throws IOException {
        System.out.println("\n2. Reading from file...");
        
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;
        
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
    
    // Modify the file content
    static void modifyFile() throws IOException {
        System.out.println("\n3. Modifying file...");
        
        // Read all lines first
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;
        
        while ((line = br.readLine()) != null) {
            if (line.contains("numbers")) {
                line = line.replace("10, 20, 30", "100, 200, 300");
            }
            lines.add(line);
        }
        br.close();
        
        lines.add("Modified on " + new Date());
        
        FileWriter fw = new FileWriter("data_modified.txt");
        for (String l : lines) {
            fw.write(l + "\n");
        }
        fw.close();
        
        System.out.println("Created data_modified.txt");
    }
    
    static void appendToFile() throws IOException {
        System.out.println("\n5. Appending to file...");
        
        FileWriter fw = new FileWriter("data.txt", true); // true = append mode
        fw.write("\n--- APPENDED CONTENT ---\n");
        fw.write("This was added later\n");
        fw.close();
        
        System.out.println("Appended content to data.txt");
        
        // Show the result
        System.out.println("\nFinal content of data.txt:");
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}