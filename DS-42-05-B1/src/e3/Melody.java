package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melody {
    enum Notes {DO, RE, MI, FA, SOL, LA, SI}

    enum Accidentals {NATURAL, SHARP, FLAT}

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
        if (note == null || accidental == null || time <= 0) {
            throw new IllegalArgumentException();
        }
        NotesList.add(note);
        AccidentalsList.add(accidental);
        TimesList.add(time);
    }

    /**
     * Returns the note on the given position
     *
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Notes getNote(int index) {
        if (index > NotesList.size() - 1 || index < 0) {
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
        if (index > AccidentalsList.size() - 1 || index < 0) {
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
        if (index > TimesList.size() || index < 0) {
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
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Melody melody = (Melody) o;
        for (int i = 0; i < NotesList.size(); i++) {
            if (!Objects.equals(this.TimesList.get(i), melody.TimesList.get(i))) {
                return false;
            }
            if (!Objects.equals(this.NotesList.get(i), melody.NotesList.get(i))) {
                switch (this.NotesList.get(i)) {
                    case DO:
                        switch (this.AccidentalsList.get(i)) {
                            case NATURAL:
                                if (melody.NotesList.get(i) != Notes.SI ||
                                        melody.AccidentalsList.get(i) != Accidentals.SHARP) {
                                    return false;
                                }
                                break;
                            case SHARP:
                                if (melody.NotesList.get(i) != Notes.RE ||
                                        melody.AccidentalsList.get(i) != Accidentals.FLAT) {
                                    return false;
                                }
                                break;
                            case FLAT:
                                if (melody.NotesList.get(i) != Notes.SI ||
                                        melody.AccidentalsList.get(i) != Accidentals.NATURAL) {
                                    return false;
                                }
                                break;
                        }
                        break;
                    case RE:
                        switch (this.AccidentalsList.get(i)) {
                            case SHARP:
                                if (melody.NotesList.get(i) != Notes.MI ||
                                        melody.AccidentalsList.get(i) != Accidentals.FLAT) {
                                    return false;
                                }
                                break;
                            case FLAT:
                                if (melody.NotesList.get(i) != Notes.DO ||
                                        melody.AccidentalsList.get(i) != Accidentals.SHARP) {
                                    return false;
                                }
                                break;
                        }
                        break;
                    case MI:
                        switch (this.AccidentalsList.get(i)) {
                            case NATURAL:
                                if (melody.NotesList.get(i) != Notes.FA ||
                                        melody.AccidentalsList.get(i) != Accidentals.FLAT) {
                                    return false;
                                }
                                break;
                            case SHARP:
                                if (melody.NotesList.get(i) != Notes.FA ||
                                        melody.AccidentalsList.get(i) != Accidentals.NATURAL) {
                                    return false;
                                }
                                break;
                            case FLAT:
                                if (melody.NotesList.get(i) != Notes.RE ||
                                        melody.AccidentalsList.get(i) != Accidentals.SHARP) {
                                    return false;
                                }
                                break;
                        }
                        break;
                    case FA:
                        switch (this.AccidentalsList.get(i)) {
                            case NATURAL:
                                if (melody.NotesList.get(i) != Notes.MI ||
                                        melody.AccidentalsList.get(i) != Accidentals.SHARP) {
                                    return false;
                                }
                                break;
                            case SHARP:
                                if (melody.NotesList.get(i) != Notes.SOL ||
                                        melody.AccidentalsList.get(i) != Accidentals.FLAT) {
                                    return false;
                                }
                                break;
                            case FLAT:
                                if (melody.NotesList.get(i) != Notes.MI ||
                                        melody.AccidentalsList.get(i) != Accidentals.NATURAL) {
                                    return false;
                                }
                                break;
                        }
                        break;
                    case SOL:
                        switch (this.AccidentalsList.get(i)) {
                            case SHARP:
                                if (melody.NotesList.get(i) != Notes.LA ||
                                        melody.AccidentalsList.get(i) != Accidentals.FLAT) {
                                    return false;
                                }
                                break;
                            case FLAT:
                                if (melody.NotesList.get(i) != Notes.FA ||
                                        melody.AccidentalsList.get(i) != Accidentals.SHARP) {
                                    return false;
                                }
                                break;
                        }
                        break;
                    case LA:
                        switch (this.AccidentalsList.get(i)) {
                            case SHARP:
                                if (melody.NotesList.get(i) != Notes.SI ||
                                        melody.AccidentalsList.get(i) != Accidentals.FLAT) {
                                    return false;
                                }
                                break;
                            case FLAT:
                                if (melody.NotesList.get(i) != Notes.SOL ||
                                        melody.AccidentalsList.get(i) != Accidentals.SHARP) {
                                    return false;
                                }
                                break;
                        }
                        break;
                    case SI:
                        switch (this.AccidentalsList.get(i)) {
                            case NATURAL:
                                if (melody.NotesList.get(i) != Notes.DO ||
                                        melody.AccidentalsList.get(i) != Accidentals.FLAT) {
                                    return false;
                                }
                                break;
                            case SHARP:
                                if (melody.NotesList.get(i) != Notes.DO ||
                                        melody.AccidentalsList.get(i) != Accidentals.NATURAL) {
                                    return false;
                                }
                                break;
                            case FLAT:
                                if (melody.NotesList.get(i) != Notes.LA ||
                                        melody.AccidentalsList.get(i) != Accidentals.SHARP) {
                                    return false;
                                }
                                break;
                        }
                        break;
                }
            } else if (!Objects.equals(this.AccidentalsList.get(i), melody.AccidentalsList.get(i))) {
                return false;
            }
        }
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
        int hash = 0;

        for (int i = 0; i < NotesList.size(); i++) {
            switch (NotesList.get(i)) {
                case DO:
                    switch (this.AccidentalsList.get(i)) {
                        case NATURAL -> hash += 9;
                        case SHARP -> hash += 1;
                        case FLAT -> hash += 8;
                    }
                    break;
                case RE:
                    switch (this.AccidentalsList.get(i)) {
                        case NATURAL -> hash += NotesList.get(i).name().charAt(0) * 13;
                        case SHARP -> hash += 2;
                        case FLAT -> hash += 1;
                    }
                    break;
                case MI:
                    switch (this.AccidentalsList.get(i)) {
                        case NATURAL -> hash += 3;
                        case SHARP -> hash += 4;
                        case FLAT -> hash += 2;
                    }
                    break;
                case FA:
                    switch (this.AccidentalsList.get(i)) {
                        case NATURAL -> hash += 4;
                        case SHARP -> hash += 5;
                        case FLAT -> hash += 3;
                    }
                    break;
                case SOL:
                    switch (this.AccidentalsList.get(i)) {
                        case NATURAL -> hash += NotesList.get(i).name().charAt(0) * 13;
                        case SHARP -> hash += 6;
                        case FLAT -> hash += 5;
                    }
                    break;
                case LA:
                    switch (this.AccidentalsList.get(i)) {
                        case NATURAL -> hash += NotesList.get(i).name().charAt(0) * 13;
                        case SHARP -> hash += 7;
                        case FLAT -> hash += 6;
                    }
                    break;
                case SI:
                    switch (this.AccidentalsList.get(i)) {
                        case NATURAL -> hash += 8;
                        case SHARP -> hash += 9;
                        case FLAT -> hash += 7;
                    }
                    break;
            }
            hash += TimesList.get(i) * 13;
        }

        return hash;
    }

    /**
     * The string representation of this melody .
     *
     * @return The String representantion of this melody .
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < NotesList.size(); i++) {
            if (i != 0) {
                s = s.concat(" ");
            }
            s = s.concat(NotesList.get(i).name());
            switch (AccidentalsList.get(i)) {
                case SHARP:
                    s = s + "#";
                    break;
                case FLAT:
                    s = s + "b";
                    break;
                case NATURAL:
                    break;
            }
            s = s + "(" + TimesList.get(i).toString() + ")";
        }
        return s;
    }
}
