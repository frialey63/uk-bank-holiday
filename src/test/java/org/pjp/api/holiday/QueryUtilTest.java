package org.pjp.api.holiday;

import java.time.LocalDate;

import org.pjp.api.holiday.model.Division;

import junit.framework.TestCase;

/**
 * JUnit4 test cases for class QueryUtil.
 * @author Paul
 *
 */
public class QueryUtilTest extends TestCase {

    private final QueryUtil util = QueryUtil.getInstance();

    /**
     * Test case for org.pjp.api.holiday.QueryUtil.isHoliday(Division, LocalDate).
     */
    public void testIsHoliday() {
        assertTrue(util.isHoliday(Division.ENGLAND_AND_WALES, LocalDate.of(2022, 12, 27)));
    }

    /**
     * Test case for org.pjp.api.holiday.QueryUtil.getDate(Division, int, String).
     */
    public void testGetDate() {
        util.getDate(Division.ENGLAND_AND_WALES, 2022, "Christmas Day").ifPresentOrElse(date -> assertEquals(LocalDate.of(2022, 12, 27), date), () -> fail());
    }

    /**
     * Test case for org.pjp.api.holiday.QueryUtil.getHolidays(Division, int).
     *
     * Note extra bank holiday due to death of QEII.
     */
    public void testGetHolidays() {
        assertEquals(10, util.getHolidays(Division.ENGLAND_AND_WALES, 2022).size());
    }

}
