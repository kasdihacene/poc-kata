package com.mlaku.dev.kata.directorieslister;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class ModalComponentComposite extends ModalComponent {

    public ModalComponentComposite(File folder) {
        super(folder);
    }

    @Override
    public String rootPath() {
        return folder.getPath();
    }

    @Autowired
    public List<ModalComponent> files() {

        ModalComponent directoryLeaf = new DirectoryLeaf(this.folder);
        return directoryLeaf.files();

    }

    @Override
    List<ModalComponent> children() {
        return new DirectoryLeaf(this.folder).children();
    }

    @Override
    void printChildren() {
        new DirectoryLeaf(this.folder).printChildren();
    }

}
