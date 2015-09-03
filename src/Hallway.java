
/**
 * Copyright 2015 Andrew Bates
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hallway represents a row of lockers that are accessible to students
 * 
 * @author abates
 *
 */
public class Hallway implements Iterable<Locker> {
    /**
     * lockers is an internal array of {@link Locker} objects ordered by their
     * ID which also represents their position in the row. For instance, a
     * {@link Locker} with an ID of 1 would be at the first position (index 0)
     * in the lockers array. Likewise, a {@link Locker} with an ID of 9 would be
     * at the ninth position (index 8) in the lockers array
     */
    private Locker[] lockers;

    /**
     * Create a Hallway instance with the given number of lockers
     * 
     * @param numLockers
     *            the number of lockers to place in the Hallway
     */
    public Hallway(int numLockers) {
        lockers = new Locker[numLockers];
        for (int lockerId = 1; lockerId <= numLockers; lockerId++) {
            lockers[lockerId - 1] = new Locker(lockerId);
        }
    }

    /**
     * Get the {@link java.util.List} of open locker IDs.
     * 
     * @return {@link java.util.List<Integer>} open locker IDs
     */
    public List<Integer> getOpenIds() {
        List<Integer> ids = new ArrayList<Integer>();
        for (Locker locker : this) {
            if (locker.isOpen()) {
                ids.add(locker.getId());
            }
        }
        return ids;
    }

    /**
     * Retrieve an iterator to navigate the internal array of lockers
     * 
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Locker> iterator() {
        return new Iterator<Locker>() {
            int current = 0;

            public boolean hasNext() {
                return current < lockers.length;
            }

            public Locker next() {
                return lockers[current++];
            }

            public void remove() {
                throw new UnsupportedOperationException("cannot remove lockers from the hallway!");
            }
        };
    }
}