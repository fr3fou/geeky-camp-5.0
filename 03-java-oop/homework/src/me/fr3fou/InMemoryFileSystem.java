package me.fr3fou;

public class InMemoryFileSystem {
    public static void main(String[] args) {

        // hardcoding methods
        // /
        FileSystem fs = new FileSystem();

        // /usr/
        fs.createDir("usr", Permission.READ_WRITE);

        // /home/
        fs.createDir("home", Permission.READ_WRITE);
        fs.changeDir("home");

        // /home/test/
        fs.createDir("test", Permission.READ_WRITE);
        fs.changeDir("test");

        // /home/test/asdf/
        fs.createDir("asdf", Permission.READ_WRITE);
        fs.changeDir("asdf");

        // /home/test/
        fs.changeDir("../");

        // /usr/
        fs.changeDir("/usr/");

        // /usr/var/
        fs.createDir("var", Permission.READ_WRITE);
        fs.changeDir("var");

        // /usr/var/uwu/
        fs.createDir("uwu", Permission.READ_WRITE);
        fs.changeDir("uwu");

        // /home/test/asdf
        fs.changeDir("../../home/test/asdf");

    }
}
