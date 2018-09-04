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

    private Directory(Directory dir) {
        this.path = dir.getPath();
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

    @Override
    protected void create(FileSystemObject fso) {
        //fso.parent = this;
        String path = this.path + fso.getPath() + "/";
        fso.setPath(path);
        this.children.put(path, fso);
    }

    @Override
    protected void open() {

    }

    @Override
    protected void rename(String newName) {

    }

    @Override
    protected void delete(String path) {
        if (this.children.containsKey(this.path + path + "/")) {
                this.children.remove(this.path + path + "/");
        } else {
            System.out.println("Object doesn't exist");
        }
    }

    // ---------- --------------- ----------
    // ---------- M U T A T O R S ----------
    // ---------- --------------- ----------


    private Map<String, FileSystemObject> getChildren() {
        return children;
    }
}

