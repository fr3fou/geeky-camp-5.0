package me.fr3fou;

import java.util.HashMap;
import java.util.Map;

public class Directory extends FileSystemObject {
    private Map<String, FileSystemObject> children;

    // ---------- --------------------- ----------
    // ---------- C O N S T R U C T O R ----------
    // ---------- --------------------- ----------

    public Directory(String path, Permission permission) {
        this.path = path;
        this.permission = permission;
        this.children = new HashMap();
    }

    public Directory(String path, Permission permission, FileSystemObject parent) {
        this.path = path;
        this.parent = parent;
        this.permission = permission;
        this.children = new HashMap();
    }

    private Directory(Directory dir) {
        this.path = dir.getPath();
        this.parent = dir.parent;
        this.permission = dir.getPermission();
        this.children = dir.getChildren();
    }

    // ---------- ------------- ----------
    // ---------- M E T H O D S ----------
    // ---------- ------------- ----------

    public Directory changeDir(String path) {
        String fullPath = this.path + path + "/";

        if (this.children.containsKey(fullPath)) {
            System.out.println("Changed to " + fullPath);
            return (Directory) this.children.get(fullPath);
        } else {
            System.out.println("Directory doesn't exist");
            return new Directory(this);
        }
    }

    public void create(FileSystemObject fso) {
        String path = this.path + fso.getPath() + "/";
        fso.setPath(path);
        this.children.put(path, fso);
        System.out.println("Created " + fso.getPath());
    }

    public String open(String path) {
        if (this.children.containsKey(path)) {
            System.out.println("Opened " + path);
            return ((File) this.children.get(path)).getContent();
        } else {
            return "Object not found";
        }
    }

    private void rename(String newName) {

    }

    public void delete(String path) {
        String fullPath = this.path + path + "/";

        if (this.children.containsKey(fullPath)) {
            this.children.remove(fullPath);
            System.out.println("Deleted " + path);
        } else {
            System.out.println("Object doesn't exist");
        }
    }

    // ---------- --------------- ----------
    // ---------- M U T A T O R S ----------
    // ---------- --------------- ----------

    public FileSystemObject getParent() {
        return this.parent;
    }

    private Map<String, FileSystemObject> getChildren() {
        return this.children;
    }
}

