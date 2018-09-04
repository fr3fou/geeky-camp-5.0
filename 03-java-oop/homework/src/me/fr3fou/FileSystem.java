package me.fr3fou;

public class FileSystem {
    private Directory root;
    private Directory currentDir;
    private String currentPath;

    // ---------- --------------------- ----------
    // ---------- C O N S T R U C T O R ----------
    // ---------- --------------------- ----------

    public FileSystem() {
        this.root = new Directory("/", Permission.READ_WRITE);
        this.currentDir = this.root;
        this.currentPath = this.root.path;
    }

    // ---------- ------------- ----------
    // ---------- M E T H O D S ----------
    // ---------- ------------- ----------

    public void changeDir(String path) {
        if (path.startsWith("/")) {
            this.currentDir = this.root;
            path = path.substring(1);
        }
        if (path.contains("/")) {
            String[] splitDirs = path.split("/");
            for (String dir : splitDirs) {
                this.currentDir = this.currentDir.changeDir(dir);
            }
        }
    }

    public void createFolder(String path, Permission permission) {
        if (path.startsWith("/")) {
            FileSystemObject fso = new Directory(path.substring(1), permission);
            this.root.create(fso);
        } else if (path.endsWith("/")) {
            FileSystemObject fso = new Directory(path.substring(0, path.length() - 1), permission);
            this.currentDir.create(fso);
        }
    }

    public void createFile(String path, Permission permission, FileType type, String content) {
        FileSystemObject fso = new File(path, permission, type, content);
        this.root.create(fso);
    }
}
