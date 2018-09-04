package me.fr3fou;

public class File extends FileSystemObject {
    private FileType type;
    private String content;

    // ---------- --------------------- ----------
    // ---------- C O N S T R U C T O R ----------
    // ---------- --------------------- ----------

    public File(String path, Permission permission, FileType type, String content) {
        this.path = path;
        this.permission = permission;
        this.type = type;
        this.content = content;
        this.isOpen = false;
    }

    // ---------- ----------------- ----------
    // ---------- O V E R R I D E S ----------
    // ---------- ----------------- ----------

    @Override
    protected void create(FileSystemObject fso) {

    }

    @Override
    protected void open() {

    }

    @Override
    protected void rename(String newName) {

    }

    @Override
    protected void delete(String path) {

    }
}
