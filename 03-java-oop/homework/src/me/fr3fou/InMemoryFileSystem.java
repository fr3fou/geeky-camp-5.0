package me.fr3fou;

public class InMemoryFileSystem {
    public static void main(String[] args) {

        // hardcoding methods
        // /
        FileSystem fs = new FileSystem();

        // mkdir /usr/
        fs.createDir("usr", Permission.READ_WRITE);

        // mkdir & cd/home/
        fs.createDir("home", Permission.READ_WRITE);
        fs.changeDir("home");

        // mkdir & cd /home/test/
        fs.createDir("test", Permission.READ_WRITE);
        fs.changeDir("test");

        // mkdir & cd /home/test/asdf/
        fs.createDir("asdf", Permission.READ_WRITE);
        fs.changeDir("asdf");

        // cd ../ (/home/test/)
        fs.changeDir("../");

        // cd /usr/
        fs.changeDir("/usr/");

        // mkdir & cd /usr/var/
        fs.createDir("var", Permission.READ_WRITE);
        fs.changeDir("var");

        // mkdir & cd /usr/var/uwu/
        fs.createDir("uwu", Permission.READ_WRITE);
        fs.changeDir("uwu");

        // cd ../../../home/test/asdf (/home/test/asdf)
        fs.changeDir("../../../home/test/asdf");

        // cd ../ (/home/test/)
        fs.changeDir("../");

        // delete asdf
        fs.deleteDir("asdf");

        // touch readme
        fs.createFile("readme", Permission.READ_WRITE, FileType.TEXT, "this is an example");
        fs.openFile("readme");

    }
}
