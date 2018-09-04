package me.fr3fou;

public class InMemoryFileSystem {
    public static void main(String[] args) {
        // hardcoding methods
        FileSystem fs = new FileSystem();

        fs.createDir("home", Permission.READ_WRITE);
        fs.changeDir("home");

        fs.createDir("test", Permission.READ_WRITE);
        fs.changeDir("test");

        fs.createDir("asdf", Permission.READ_WRITE);
        fs.changeDir("asdf");

        fs.changeDir("../");

    }
}
