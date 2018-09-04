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

    // ---------- ------------- ----------
    // ---------- M E T H O D S ----------
    // ---------- ------------- ----------

    public Directory changeDir(String path) {
        if (this.children.containsKey(this.path + path + "/")) {
            return (Directory)this.children.get(this.path + path);
        } else {
            System.out.println("Directory doesn't exist");
        }
        
    }

    // ---------- ----------------- ----------
    // ---------- O V E R R I D E S ----------
    // ---------- ----------------- ----------

    @Override
    protected void create(FileSystemObject fso) {
        //fso.parent = this;
        this.children.put(this.path + fso.getPath() + "/", fso);
    }

    @Override
    protected void open() {

    }

    @Override
    protected void rename(String newName) {

    }

    @Override
    protected void delete() {
    }

    // ---------- --------------- ----------
    // ---------- M U T A T O R S ----------
    // ---------- --------------- ----------

}

