package me.fr3fou;

public class File extends FileSystemObject {
    private FileType type;
    private String content;

    // ---------- --------------------- ----------
    // ---------- C O N S T R U C T O R ----------
    // ---------- --------------------- ----------

    public File(String path, Permission permission, FileType type, String content, FileSystemObject parent) {
        this.path = path;
        this.permission = permission;
        this.type = type;
        this.content = content;
        this.isOpen = false;
        this.parent = parent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }
}
