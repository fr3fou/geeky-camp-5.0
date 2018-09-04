package me.fr3fou;

public abstract class FileSystemObject {
    protected Permission permission = Permission.READ_ONLY;
    //protected FileSystemObject parent;

    protected String path;

    protected boolean isOpen = false;

    protected abstract void create(FileSystemObject fso);
    protected abstract void open();
    protected abstract void rename(String newName);
    protected abstract void delete();

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
