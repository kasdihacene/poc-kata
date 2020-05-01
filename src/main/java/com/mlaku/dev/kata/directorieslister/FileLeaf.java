package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileLeaf extends ModalComponent {
    private File folder;

    public FileLeaf(File folder) {
        this.folder = folder;
    }

    @Override
    public String rootPath() {
        return folder.getPath();
    }

    @Override
    public List<ModalComponent> files() {
        return Arrays.asList(this);
    }

}
