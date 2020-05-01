package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryLeaf extends ModalComponent {
    private File file;
    List<ModalComponent> directories;

    public DirectoryLeaf(File file) {
        this.file = file;
        directories = new ArrayList<>();
    }

    @Override
    public String rootPath() {
        return file.getPath();
    }

    @Override
    public List<ModalComponent> files() {
        return buildComponents().stream()
                .map(ModalComponent::files)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<ModalComponent> buildComponents() {
        return getFiles().stream()
                .map(file1 -> file1.isFile() ? new FileLeaf(file1) : new DirectoryLeaf(file1))
                .collect(Collectors.toList());
    }

    private List<File> getFiles() {
        return Arrays.stream(file.listFiles()).collect(Collectors.toList());
    }
}
