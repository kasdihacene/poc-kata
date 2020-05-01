package com.mlaku.dev.kata.directorieslister;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class ModalComponentComposite implements ModalComponent {

    private File folder;

    public ModalComponentComposite(File folder) {
        this.folder = folder;
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

}
