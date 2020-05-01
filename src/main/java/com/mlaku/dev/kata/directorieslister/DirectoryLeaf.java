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

    @Override
    void printChildren() {
        System.out.println("FOLDER ==> " + rootPath());
        buildComponents().stream().forEach(ModalComponent::printChildren);
    }

    private List<ModalComponent> buildComponents() {
        List<ModalComponent> modalComponents = getFiles().stream()
                .map(fileLeaf -> fileLeaf.isFile() ? new FileLeaf(fileLeaf) : new DirectoryLeaf(fileLeaf))
                .collect(Collectors.toList());
        return modalComponents;
    }

    private List<File> getFiles() {
        return Arrays.stream(folder.listFiles()).collect(Collectors.toList());
    }
}
