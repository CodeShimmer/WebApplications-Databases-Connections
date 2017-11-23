package kryptoline;

/**
 * @author jonna
 *
 */
public class Student {
	int rollno;
	String name;
	float fee;

	/**Using 'this' key word
	 * @param rollno
	 * @param name
	 * @param fee
	 */
	Student(int rollno, String name, float fee) {
		this.rollno = rollno;
		this.name = name;
		this.fee = fee;
	}

	/**
	 * 
	 */
	void display() {
		System.out.println(rollno + " " + name + " " + fee);
	}
}