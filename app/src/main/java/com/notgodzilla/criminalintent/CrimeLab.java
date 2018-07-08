package com.notgodzilla.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab crimeLab;

    private List<Crime> crimes;

    public static CrimeLab get(Context context) {
        if (crimeLab == null) {
            crimeLab = new CrimeLab(context);
        }

        return crimeLab;
    }

    private CrimeLab(Context context) {
        crimes = new ArrayList<>();
    }

    public List<Crime> getCrimes() {
        return this.crimes;
    }

    public Crime getCrime(UUID uuid) {
        for (Crime c : crimes) {
            if (c.getUuid().equals(uuid)) {
                return c;
            }
        }

        return null;
    }

    public void addCrime(Crime c) {
        crimes.add(c);
    }

}
