package com.mikkelgud.filehandling;

import com.mikkelgud.person.InvalidPersonPropertiesException;

import java.util.List;

/**
 * Denne klassen brukes av alle objekter som skal kunne lagres til csv fil.
 * <p>
 * Det er opp til objektene som extender denne klassen å definere feltverdiene som skal med i CSV-filen via getFieldValues().
 * Det samme gjelder CSV-headeren (første rad i filen) via getDeclaredFields()-metoden.
 */
public abstract class FileObjectEntity {
    public abstract List<String> getDeclaredFields();
    public abstract List<String> getFieldValues();

    public abstract Object getObjectForString(String line) throws InvalidPersonPropertiesException;
}
