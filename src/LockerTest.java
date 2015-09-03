
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
 *
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * LockerTest implements the unit tests for {@link Locker}
 * 
 * @author abates
 *
 */
public class LockerTest {
    /**
     * ID to be used when testing a Locker
     */
    private static int TEST_ID = 12345;
    /**
     * Locker to be tested
     */
    private Locker locker;

    /**
     * Fixture initialization (common initialization for all tests).
     **/
    @Before
    public void setUp() {
        locker = new Locker(TEST_ID);
    }

    /**
     * Ensure that the locker defaults to a closed state
     */
    @Test
    public void testInitialState() {
        Assert.assertFalse("lockers should be closed by default", locker.isOpen());
        locker = new Locker(TEST_ID, true);
        Assert.assertTrue("lockers should be open if specified in the single argument constructor", locker.isOpen());
    }

    /**
     * Ensure that the locker's door state can be toggled properly
     */
    @Test
    public void testToggle() {
        locker.toggle();
        Assert.assertTrue("lockers should be opened when toggling from a closed state", locker.isOpen());
        Assert.assertFalse("lockers should be opened when toggling from a closed state", locker.isClosed());

        locker.toggle();
        Assert.assertTrue("lockers should be closed when toggling from an open state", locker.isClosed());
        Assert.assertFalse("lockers should be closed when toggling from an open state", locker.isOpen());
    }

    /**
     * Ensure that the locker returns the correct ID
     */
    @Test
    public void testGetId() {
        Assert.assertEquals("getId() should return the ID set in the constructor", TEST_ID, locker.getId());
    }
}
