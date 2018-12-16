package arrList;

import com.mo.arrList.SeqList;

public class Student {
	private int no;
	private String name;
	private String sex;
	private int age;
	public Student(int no,String name,String sex,int age) {
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) throws Exception {
		SeqList seqList = new SeqList(100);
		com.mo.arrList.Student s1 = new com.mo.arrList.Student(200001,"����","��",20);
		com.mo.arrList.Student s2 = new com.mo.arrList.Student(200002,"����","��",21);
		com.mo.arrList.Student s3 = new com.mo.arrList.Student(200003,"����","Ů",22);
		seqList.insert(0, s1);
		seqList.insert(1, s2);
		seqList.insert(2, s3);
		for (int i = 0; i < seqList.size(); i++) {
			com.mo.arrList.Student s = (com.mo.arrList.Student)seqList.getData(i);
			System.out.println(s.getNo() + s.getName() + s.getSex() + s.getAge());
		}
	}
}
