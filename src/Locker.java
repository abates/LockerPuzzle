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

/**
 * 
 * The Locker class represents a single locker that can either be open or
 * closed.
 * 
 * @author Andrew Bates
 */
public class Locker {
    /**
     * id is an immutable integer that represents the identifier of the locker.
     * It should be unique within the hallway, although there is no way for
     * Locker to enforce that
     */
    private int id;

    /**
     * open represents the current state of the locker. If true, it indicates
     * that the door to the locker is open. Likewise, if open is false, that
     * indicates the door to the locker is closed.
     */
    private boolean open;

    /**
     * Create a locker with the given ID. The locker's door will be closed.
     * 
     * @param id
     *            the integer identifier of the locker. Typically its index in
     *            the row of lockers in the {@link Hallway}.
     */
    public Locker(int id) {
        this(id, false);
    }

    /**
     * Create a locker with the given ID and initial state.
     * 
     * @param id
     *            the integer identifier of the locker. Typically its index in
     *            the row of lockers in the {@link Hallway}
     * 
     * @param open
     *            the initial state of the locker's door. True for open and
     *            false for closed.
     */
    public Locker(int id, boolean open) {
        this.id = id;
        this.open = open;
    }

    /**
     * Toggle the door's state
     */
    public void toggle() {
        open = !open;
    }

    /**
     * Retrieve the locker's ID
     * 
     * @return an integer ID
     */
    public int getId() {
        return id;
    }

    /**
     * Determine if the locker is open
     * 
     * @return true if the door is open false if the door is closed
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Determine if the locker is closed
     * 
     * @return true if the door is closed false if the door is open
     */
    public boolean isClosed() {
        return !open;
    }
}
