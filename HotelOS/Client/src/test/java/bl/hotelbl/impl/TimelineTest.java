package bl.hotelbl.impl;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/12/10.
 */
public class TimelineTest {
    Timeline tested;

    @Before
    public void setUp() throws Exception {
        tested = new Timeline(50);
    }

    @Test
    public void addPeriod() throws Exception {
        tested.addPeriod(LocalDateTime.now(), LocalDateTime.now().plusDays(2), 3);
        tested.addPeriod(LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(3), 4);
    }

}