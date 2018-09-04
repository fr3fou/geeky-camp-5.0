package me.fr3fou;

public class InMemoryFileSystem {
    public static void main(String[] args) {
        // hardcoding methods
        FileSystem fs = new FileSystem();

        fs.createFolder("home", Permission.READ_WRITE);
        fs.changeDir("home");
        fs.createFile("gosho", Permission.READ_WRITE, FileType.TEXT, "Gosho sucks");
        fs.createFolder("pesho", Permission.READ_WRITE);
        fs.changeDir("pesho");
    }
}
