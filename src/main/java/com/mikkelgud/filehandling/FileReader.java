package com.mikkelgud.filehandling;

import javafx.collections.ObservableList;

import java.util.List;

public interface FileReader {
    public List <? extends FileObjectEntity> getObjectForString(List<String> values);
}
