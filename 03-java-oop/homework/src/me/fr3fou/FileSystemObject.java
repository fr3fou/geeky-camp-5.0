package me.fr3fou;

public abstract class FileSystemObject {
    protected Permission permission = Permission.READ_ONLY;
    //protected FileSystemObject parent;

    protected String path;

    protected boolean isOpen = false;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Permission getPermission() {
        return permission;
    }
}
