import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTestStudent {

	@Test
    void testParameterizedConstructor() {
        Customer customer = new Customer("John Doe", 25);

        assertEquals("John Doe", customer.getName(), "Customer name should match the constructor input.");
        assertEquals(25, customer.getAge(), "Customer age should match the constructor input.");
    }

    @Test
    void testCopyConstructor() {
        Customer original = new Customer("Jane Doe", 30);
        Customer copy = new Customer(original);

        assertEquals(original.getName(), copy.getName(), "Name should match the original customer.");
        assertEquals(original.getAge(), copy.getAge(), "Age should match the original customer.");
        assertNotSame(original, copy, "The copy constructor should create a new object.");
    }

    @Test
    void testSetName() {
        Customer customer = new Customer("John Doe", 25);
        customer.setName("Jane Doe");

        assertEquals("Jane Doe", customer.getName(), "Customer name should update after calling setName.");
    }

    @Test
    void testSetAge() {
        Customer customer = new Customer("John Doe", 25);
        customer.setAge(35);

        assertEquals(35, customer.getAge(), "Customer age should update after calling setAge.");
    }

    @Test
    void testToString() {
        Customer customer = new Customer("John Doe", 25);
        String expected = "Customer[name=John Doe, age=25]";

        assertEquals(expected, customer.toString(), "toString should return the correct representation.");
    }

    @Test
    void testEquals() {
        Customer customer1 = new Customer("John Doe", 25);
        Customer customer2 = new Customer("John Doe", 25);
        Customer customer3 = new Customer("Jane Doe", 30);

        assertTrue(customer1.equals(customer2), "Customers with the same name and age should be equal.");
        assertFalse(customer1.equals(customer3), "Customers with different names or ages should not be equal.");
        assertFalse(customer1.equals(null), "Customer should not be equal to null.");
        assertFalse(customer1.equals("Not a customer"), "Customer should not be equal to an object of a different type.");
    }
}
