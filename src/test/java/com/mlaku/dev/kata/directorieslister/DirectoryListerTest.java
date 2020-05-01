package com.mlaku.dev.kata.directorieslister;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectoryListerTest {

    /**
     * This KATA allows you to practice TDD, SOLID principals,
     * List all files of the directories in the root path and the files of the sub directories found
     * inside the directories.
     *
     * TDD Clean code DP composite, recursion, SOLID, FIRST
     */

    @Test
    public void returnsListedFilesOrDirectoriesFromEnteredPath() {
        File folder = new File("directoryMock1");

        List<String> filenames = DirectoryHelper.fetchAllFiles(folder);
        int expectedLength = 2;

        assertThat(filenames.size()).isEqualTo(expectedLength);
    }

    @Test
    public void returnsFilesOfDirectoryAndFilesOfSubDirectory() {
        File folder = new File("directoryMock2");

        List<String> filenames = DirectoryHelper.fetchAllFiles(folder);
        int expectedLength = 4;

        assertThat(filenames.size()).isEqualTo(expectedLength);
    }

    @Test
    public void returnsFilesOfDirectoryAndFilesOfNSubDirectory() {
        File folder = new File("directory");

        List<String> filenames = DirectoryHelper.fetchAllFiles(folder);
        int expectedLength = 12;

        assertThat(filenames.size()).isEqualTo(expectedLength);
    }

    @Test
    public void returnsFourFilesEntitiesOfDirectoryAndFilesOfSubDirectory() {
        File folder = new File("directoryMock2");

        ModalComponentComposite modalComposite = new ModalComponentComposite(folder);
        List<ModalComponent> files = modalComposite.files();

        int expectedLength = 4;

        assertThat(files.size()).isEqualTo(expectedLength);
    }

    @Test
    public void returnsTwelveFilesEntitiesOfDirectoryAndFilesOfSubDirectory() {
        File folder = new File("directory");

        ModalComponentComposite modalComposite = new ModalComponentComposite(folder);
        List<ModalComponent> files = modalComposite.files();

        int expectedLength = 12;

        assertThat(files.size()).isEqualTo(expectedLength);
    }

    @Test
    public void returns4FilesEntitiesOfDirectoryAndFilesOfSubDirectory() {
        File folder = new File("directoryMock3");

        ModalComponentComposite modalComposite = new ModalComponentComposite(folder);
        modalComposite.printChildren();

    }
}
