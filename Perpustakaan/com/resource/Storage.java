package com.resource;
import java.util.ArrayList;

import java.io.Serializable;

public class Storage implements Serializable{
    private ArrayList<Rak> rakrak;
    private ArrayList<User> users;
    private ArrayList<Admin> admins;

    Storage(ArrayList<Rak> rakrak, ArrayList<User> users, ArrayList<Admin> admins){
        this.rakrak = rakrak;
        this.users = users;
        this.admins = admins;
    }

    protected ArrayList<Rak> getRak(){
        return rakrak;
    }
    protected ArrayList<User> getUsers(){
        return users;
    }
    protected ArrayList<Admin> getAdmins(){
        return admins;
    }
}
