package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {
    Staff staff;

    @BeforeEach
    void SetUp() {
        //arrange
        staff = new Staff("Paul", 111, "Password", PrivilegeLevel.Administrator);
    }

    @Test
    void testGetName() {
        //act
        String result = staff.getName();
        //assert
        assertEquals("Paul", result);
    }

    @Test
    void testGetNameCase() {
        //act
        String result = staff.getName();
        //assert
        assertEquals("paul", result);
    }

    @Test
    void testGetNameStaff() {
        //act
        String result = staff.getName();
        //assert
        assertEquals(staff, result);
    }

    @Test
    void testGetID() {
        //act
        int result = staff.getID();
        //assert
        assertEquals(111, result);
    }
    @Test
    void testGetIdDouble() {
        //act
        int result = staff.getID();
        //assert
        assertEquals(111.0, result);
    }

    @Test
    void testNotEqualGetID() {
        //act
        int result = staff.getID();
        //assert
        assertNotEquals(222, result);
    }
    @Test
    void testGetPassword() {
        //act
        String result = staff.getPassword();
        //assert
        assertEquals("Password", result);
    }

    @Test
    void testGetPasswordCase() {
        //act
        String result = staff.getPassword();
        //assert
        assertEquals("password", result);
    }
    @Test
    void testNotEqualGetPassword() {
        //act
        String result = staff.getPassword();
        //assert
        assertNotEquals(staff, result);
    }

    @Test
    void testGetPrivilegeLevel() {
        //act
        PrivilegeLevel result = staff.getPrivilegeLevel();
        //assert
        assertEquals(PrivilegeLevel.Administrator, result);
    }

    @Test
    void testNotEqualGetPrivilegeLevel() {
        //act
        PrivilegeLevel result = staff.getPrivilegeLevel();
        //assert
        assertNotEquals(PrivilegeLevel.Cashier, result);
    }
}