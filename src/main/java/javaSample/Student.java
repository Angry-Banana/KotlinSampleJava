package javaSample;

public class Student {

    private int id;
    private String name;
    private String phoneNum;
    private String address;
    private String grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student(id=" + this.id + ", name=" + this.name + ", phoneNum=" + this.phoneNum + ", address=" + this.address + ", grade=" + this.grade + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Student) {
                Student student = (Student) obj;
                if (this.id == student.getId()
                        && this.name.equals(student.name)
                        && this.phoneNum.equals(student.phoneNum)
                        && this.address.equals(student.address)
                        && this.grade.equals(student.grade)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
