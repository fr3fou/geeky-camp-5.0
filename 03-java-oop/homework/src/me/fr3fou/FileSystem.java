package me.fr3fou;

public class FileSystem {
    private Directory root;
    private Directory currentDir;

    // ---------- --------------------- ----------
    // ---------- C O N S T R U C T O R ----------
    // ---------- --------------------- ----------

    public FileSystem() {
        this.root = new Directory("/", Permission.READ_WRITE);
        this.currentDir = this.root;
        System.out.println("Created file system at /");
    }

    // ---------- ------------- ----------
    // ---------- M E T H O D S ----------
    // ---------- ------------- ----------

    public void changeDir(String path) {
        // goes up a dir
        if (path.equals("..") || path.equals("../")) {
            upOneDir();
            return;
        } else if (path.startsWith("../")) {
            while (path.startsWith("../")) {
                upOneDir();
                path = path.substring(3);
            }
        }

        // goes to root dir
        if (path.equals("/")) {
            this.currentDir = this.root;
            return;
        }

        // goes to folder inside root dir
        if (path.startsWith("/")) {
            this.currentDir = this.root;
            path = path.substring(1);
        }

        // goes to a nested folder
        if (path.contains("/")) {
            String[] splitDirs = path.split("/");
            for (String dir : splitDirs) {
                this.currentDir = this.currentDir.changeDir(dir);
            }
        } else {
            // goes to folder in current dir
            this.currentDir = this.currentDir.changeDir(path);
        }
    }

    public void createDir(String path, Permission permission) {
        FileSystemObject fso;

        // creates folder in root dir
        if (path.startsWith("/")) {
            fso = new Directory(path, permission, this.currentDir);
            this.root.create(fso);
        } else {
            fso = new Directory(path, permission, this.currentDir);
        }
        this.currentDir.create(fso);
    }

    public void deleteDir(String path) {
        this.currentDir.delete(path);
    }

    public void createFile(String path, Permission permission, FileType type, String content) {
        FileSystemObject fso = new File(path, permission, type, content, this.currentDir);
        this.currentDir.create(fso);
    }

    private void upOneDir() {
        this.currentDir = (Directory) this.currentDir.getParent();
    }

    public void openFile(String path) {
        System.out.println(this.currentDir.open(this.currentDir.getPath() + path + "/"));
    }
}
