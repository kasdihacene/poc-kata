package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryLeaf implements ModalComponent {
    private File file;
    List<ModalComponent> directories;

    public DirectoryLeaf(File file) {
        this.file = file;
        directories = new ArrayList<>();
    }

    public File getFile() {
        return file;
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
        List<File> files = Arrays.stream(file.listFiles()).collect(Collectors.toList());
        for (int i = 0; i < files.size(); i++) {
            boolean isFile = files.get(i).isFile();
            if (isFile)
                directories.add(new FileLeaf(files.get(i)));
            else
                directories.add(new DirectoryLeaf(files.get(i)));
        }
        return directories;
    }
}
