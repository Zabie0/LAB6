package org.Credits.User;

import lombok.Data;

@Data
public class biler {
    int Id = 0;
    int Id1 = 0;
    int Id2 = 0;
    int Id3 = 0;
    int Id4 = 0;
    int Id5 = 0;
    int Id6 = 0;
    int Id7 = 0;
    String name = null;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId1() {
        return Id1;
    }

    public void setId1(int id1) {
        Id1 = id1;
    }

    public int getId2() {
        return Id2;
    }

    public void setId2(int id2) {
        Id2 = id2;
    }

    public int getId3() {
        return Id3;
    }

    public void setId3(int id3) {
        Id3 = id3;
    }
}
