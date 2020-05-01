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
     * <p>
     * TDD Clean code DP composite, recursion, SOLID, FIRST
     */
    @Test
    public void init() {
        assertThat(false).isFalse();
    }


    @Test
    public void returnsListedFilesOrDirectoriesFromEnteredPath() {
        File folder = new File("directoryMock");

        List<String> filenames = DirectoryHelper.fetchAllFiles(folder);
        int expectedLength = 2;

        assertThat(filenames.size()).isEqualTo(expectedLength);
    }
}
