package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryLeaf extends ModalComponent {

    public DirectoryLeaf(File folder) {
        super(folder);
    }

    @Override
    public String rootPath() {
        return folder.getPath();
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
                .map(fileLeaf -> fileLeaf.isFile() ? new FileLeaf(fileLeaf) : new DirectoryLeaf(fileLeaf))
                .collect(Collectors.toList());
    }

    private List<File> getFiles() {
        return Arrays.stream(folder.listFiles()).collect(Collectors.toList());
    }
}
