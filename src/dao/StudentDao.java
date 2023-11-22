package dao;

import java.util.Scanner;

import dto.StudentDto;

// Data Access Object : 데이터를 취급하는 클래스
public class StudentDao {
	Scanner sc = new Scanner(System.in);
	
	// 학생 데이터 관리 배열
	private StudentDto student[];
	
	private int count;
	
	// 추가,삭제,검색,수정 (CRUD)
	public StudentDao() {
		count = 0;
		
		student = new StudentDto[10];   //변수만 생성     [0.1.2.3 .....]	
	}

	
	public void insert() {
		System.out.println("학생 정보 입력입니다");

		System.out.print("이름 >> ");
		String name = sc.next();

		System.out.print("나이 >> ");
		int age = sc.nextInt();

		System.out.print("신장 >> ");
		double height = sc.nextDouble();

		System.out.print("주소 >> ");
		String address = sc.next();

		System.out.print("국어 >> ");
		int kor = sc.nextInt();

		System.out.print("영어 >> ");
		int eng = sc.nextInt();

		System.out.print("수학 >> ");
		int math = sc.nextInt();
		
		student[count] = new StudentDto(name, age, height, address, kor, eng, math);	
		count++;    //배열의 다음으로 이동
	}
	public void delete() {
		System.out.print("삭제하고 싶은 학생의 이름 >> ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("학생정보를 찾을 수 없습니다 ");
			return;
		}
		student[index].setName(" ");
		student[index].setAge(0);
		student[index].setHeight(0.0);
		student[index].setAddress(" ");
		student[index].setKor(0);
		student[index].setEng(0);
		student[index].setMath(0);
		
		System.out.println(name +" 학생 데이터를 삭제하였습니다 ");
		
	}
	public void select() {
		System.out.print("검색하고 싶은 학생의 이름 >> ");
		String name = sc.next();
		
		for (int i = 0; i < student.length; i++) {
			StudentDto dto = student[i];
			if(dto != null && dto.getName().equals("")== false) {
				if(name.equals(dto.getName())) {
					dto.print();
				}
			}
		}
	}
		/*
		int index = search(name);
		
		if(index != -1) {
			System.out.println("데이터를 찾았습니다");
			System.out.println("이름:" + student[index].getName());
			System.out.println("나이:" + student[index].getAge());
			System.out.println("키:" +   student[index].getHeight());
			System.out.println("주소:" + student[index].getAddress());
			System.out.println("국어:" + student[index].getKor());
			System.out.println("영어:" + student[index].getEng());
			System.out.println("수학:" + student[index].getMath());			
		}else {
			System.out.println("학생명단에 없습니다");
		}		
		
	}*/
	public void update() {
		System.out.print("수정하고 싶은 학생의 이름 >> ");
		String name = sc.next();
		
		int index = search(name);
		 
		if(index == -1) {
			System.out.println("학생명단에 없습니다");
			return;
		}
		            // 국어, 영어, 수학 점수 수정
					System.out.println("수정할 데이터를 찾았습니다");
					
					System.out.print("국어 >> ");
					int kor = sc.nextInt();
					
					System.out.print("영어 >> ");
					int eng = sc.nextInt();
					
					System.out.print("수학 >> ");
					int math = sc.nextInt();
					
					student[index].setKor(kor);
					student[index].setEng(eng);
					student[index].setMath(math);
					
					System.out.println("성공적으로 수정되었습니다 ");
		
	}
		
	
	public int search(String name) {  //모든 경우에 검색이 들어가므로 검색 함수 생성
		int index = -1;
		for (int i = 0; i < student.length; i++) {
			StudentDto dto = student[i];
				index = i;
				if(dto != null) {
					if(name.equals(dto.getName())) {
						index = i;
						break;			
					}
			  }
		}
		return index;
	}
	
	public void allData() {
		for (int i = 0; i < student.length; i++) {
			StudentDto dto = student[i];
			if(dto != null && !dto.getName().equals("")) {
				System.out.println(dto.toString());
			}
		}
		
	}
}
