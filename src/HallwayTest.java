
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

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HallwayTest {
    private static final int TEST_SIZE = 10;
    private Hallway hallway;

    @Before
    public void setUp() throws Exception {
        hallway = new Hallway(TEST_SIZE);
    }

    @Test
    public void testIterator() {
        int expectedId = 1;
        for (Locker locker : hallway) {
            Assert.assertEquals("The locker ID was invalid", expectedId++, locker.getId());
        }
    }

    @Test
    public void testDefaultState() {
        List<Integer> openIds = hallway.getOpenIds();
        Assert.assertEquals("There should be no open lockers", 0, openIds.size());
    }

    @Test
    public void testAllOpenLockers() {
        for (Locker locker : hallway) {
            locker.toggle();
        }

        List<Integer> openIds = hallway.getOpenIds();
        for (int i = 1; i <= TEST_SIZE; i++) {
            Assert.assertEquals("There should be no closed lockers", Integer.valueOf(i), openIds.get(i - 1));
        }
    }
}
