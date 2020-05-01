package com.mlaku.dev.kata.directorieslister;

import java.util.List;

public abstract class ModalComponent {
    abstract String rootPath();
    abstract List<ModalComponent> files();

}
