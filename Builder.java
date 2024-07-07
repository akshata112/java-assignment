class Student {
    private final String firstName; 
    private final String lastName;  
    private final int age;          
    private final String email;     
    private final String phone;     

    private Student(StudentBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public static class StudentBuilder {
        private final String firstName;
        private final String lastName;

        private int age = 0;
        private String email = "";
        private String phone = "";

        public StudentBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}


public class Builder {
    public static void main(String[] args) {
        Student student1 = new Student.StudentBuilder("Akshata", "Naik")
                                .age(22)
                                .email("akshata@gmail.com")
                                .build();

        Student student2 = new Student.StudentBuilder("Aditi", "Manjunath")
                                .build();

        System.out.println("Student 1:");
        System.out.println("First Name: " + student1.getFirstName());
        System.out.println("Last Name: " + student1.getLastName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Email: " + student1.getEmail());
        System.out.println("Phone: " + student1.getPhone());

        System.out.println("\nStudent 2:");
        System.out.println("First Name: " + student2.getFirstName());
        System.out.println("Last Name: " + student2.getLastName());

    }
}


