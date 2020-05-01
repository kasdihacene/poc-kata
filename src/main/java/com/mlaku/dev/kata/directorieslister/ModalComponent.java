package com.mlaku.dev.kata.directorieslister;

import java.util.List;

public interface ModalComponent {
    String rootPath();
    List<ModalComponent> files();

}
