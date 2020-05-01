package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.List;

public abstract class ModalComponent {

    protected File folder;

    public ModalComponent(File folder) {
        this.folder = folder;
    }

    abstract String rootPath();
    abstract List<ModalComponent> files();
    abstract void printChildren();

}
