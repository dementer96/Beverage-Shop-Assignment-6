public class Customer {
	private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return String.format("Customer[name=%s, age=%d]", name, age);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return age == customer.age && name.equals(customer.name);
    }
    
}
