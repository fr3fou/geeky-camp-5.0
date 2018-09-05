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
        if (this.children.containsKey(this.path + path + "/")) {
            return (Directory) this.children.get(this.path + path + "/");
        } else {
            System.out.println("Directory doesn't exist");
            return new Directory(this);
        }
    }

    // ---------- ----------------- ----------
    // ---------- O V E R R I D E S ----------
    // ---------- ----------------- ----------

    public void create(FileSystemObject fso) {
        //fso.parent = this;
        String path = this.path + fso.getPath() + "/";
        fso.setPath(path);
        this.children.put(path, fso);
    }

    public String open(String path) {
        if (this.children.containsKey(path)) {
            return ((File) this.children.get(path)).getContent();
        } else {
            return "Object not found";
        }
    }

    private void rename(String newName) {

    }

    public void delete(String path) {
        if (this.children.containsKey(this.path + path + "/")) {
            this.children.remove(this.path + path + "/");
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

