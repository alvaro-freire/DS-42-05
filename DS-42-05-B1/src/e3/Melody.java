package e3;

import java.util.ArrayList;
import java.util.List;

public class Melody {
    enum Notes {DO, RE, MI, FA, SOL, LA, SI}

    enum Accidentals {NATURAL, SHARP, FLAT}

    float Time;

    List<Notes> NotesList = new ArrayList<>();
    List<Accidentals> AccidentalsList = new ArrayList<>();
    List<Float> TimesList = new ArrayList<>();

    /**
     * Creates an empty Melody instance .
     */
    public Melody() {

    }

    /**
     * Add a note at the end of this melody .
     *
     * @param note       The note to add
     * @param accidental The accidental of the note
     * @param time       The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     *                                  or the time are not valid values .
     */
    public void addNote(Notes note, Accidentals accidental, float time) {

    }

    /**
     * Returns the note on the given position
     *
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Notes getNote(int index) {
        if (index > NotesList.size() || index < 1) {
            throw new IllegalArgumentException();
        }

        return NotesList.get(index);
    }

    /**
     * Returns the accidental of the note on the given position
     *
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Accidentals getAccidental(int index) {
        if (index > AccidentalsList.size() || index < 1) {
            throw new IllegalArgumentException();
        }

        return AccidentalsList.get(index);
    }

    /**
     * Returns the duration of the note on the given position
     *
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public float getTime(int index) {
        if (index > TimesList.size() || index < 1) {
            throw new IllegalArgumentException();
        }

        return TimesList.get(index);
    }

    /**
     * Returns the number of notes in this melody .
     *
     * @return The number of notes in this melody .
     */
    public int size() {
        return NotesList.size();
    }

    /**
     * Returns the duration of this melody .
     *
     * @return The duration of this melody in milliseconds .
     */
    public float getDuration() {
        float result = 0;

        for (Float aFloat : TimesList) {
            result += aFloat;
        }

        return result;
    }

    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter . Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes .
     *
     * @param o The melody to be compared with the current melody .
     * @return true if the melodies are equals , false otherwise .
     */
    @Override
    public boolean equals(Object o) {
        return true;
    }

    /**
     * Returns an integer that is a hash code representation of the melody .
     * Two melodies m1 , m2 that are equals (m1. equals (m2) == true ) must
     * have the same hash code .
     *
     * @return The hash code of this melody .
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * The string representation of this melody .
     *
     * @return The String representantion of this melody .
     */
    @Override
    public String toString() {
        return "gola";
    }
}
