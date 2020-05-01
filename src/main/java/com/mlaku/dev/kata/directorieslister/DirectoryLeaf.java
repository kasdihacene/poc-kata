package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryLeaf extends ModalComponent {

    private final List<ModalComponent> children;

    public DirectoryLeaf(File folder) {
        super(folder);
        children = new ArrayList<>();
    }

    @Override
    public String rootPath() {
        return folder.getPath();
    }

    @Override
    public List<ModalComponent> files() {
        List<ModalComponent> collect = buildComponents().stream()
                .map(ModalComponent::files)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    List<ModalComponent> children() {
        System.out.println("DIRECTORY ==> "+rootPath());
        children.add(this);
        List<ModalComponent> collect = buildComponents().stream()
                .map(ModalComponent::children)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        children.addAll(collect);
        return children;
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
