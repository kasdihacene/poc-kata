package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileLeaf extends ModalComponent {

    public FileLeaf(File folder) {
        super(folder);
    }

    @Override
    public String rootPath() {
        return folder.getPath();
    }

    @Override
    public List<ModalComponent> files() {
        return Arrays.asList(this);
    }

    @Override
    List<ModalComponent> children() {
        System.out.println("FILES ==> "+rootPath());
        return Arrays.asList(this);
    }

    @Override
    void printChildren() {
        System.out.println("FILE ==> "+rootPath());
    }

}
