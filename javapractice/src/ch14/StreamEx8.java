package ch14;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student7[] stuArr = {
				new Student7("���ڹ�",true,1,1,300),
				new Student7("������",false,1,1,250),
				new Student7("���ڹ�",true,1,1,200),
				new Student7("������",false,1,2,150),
				new Student7("���ڹ�",true,1,2,100),
				new Student7("������",false,1,2,50),
				new Student7("Ȳ����",false,1,3,100),
				new Student7("������",false,1,3,150),
				new Student7("���ڹ�",true,1,3,200),
				
				new Student7("���ڹ�",true,2,1,300),
				new Student7("������",false,2,1,250),
				new Student7("���ڹ�",true,2,1,200),
				new Student7("������",false,2,2,150),
				new Student7("���ڹ�",true,2,2,100),
				new Student7("������",false,2,2,50),
				new Student7("Ȳ����",false,2,3,100),
				new Student7("������",false,2,3,150),
				new Student7("���ڹ�",true,2,3,200)
			};
		System.out.printf("1. �ܼ��׷�ȭ(�ݺ��� �׷�ȭ)%n");
		Map<Integer,List<Student7>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student7::getBan));
		for(List<Student7> ban:stuByBan.values()) {
			for(Student7 s:ban) {
				System.out.println(s);
			}
		}
		
		System.out.printf("%n2. �ܼ��׷�ȭ(�������� �׷�ȭ)%n");
		Map<Student7.Level,List<Student7>> stuByLevel = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
					if(s.getScore() >= 200) return Student7.Level.HIGH;
					else if(s.getScore() >= 100) return Student7.Level.MID;
					else return Student7.Level.LOW;
					}));
		
		TreeSet<Student7.Level> keySet = new TreeSet<>(stuByLevel.keySet());
		
		for(Student7.Level key:keySet) {
			System.out.println("["+key+"]");
			for(Student7 s:stuByLevel.get(key))
				System.out.println(s);
			System.out.println();
		}
		
		System.out.printf("%n3. �ܼ��׷�ȭ + ���(������ �л���)%n");
		
		Map<Student7.Level,Long> stuCntByLevel = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
					if(s.getScore()>=200) return Student7.Level.HIGH;
					else if(s.getScore() >= 100) return Student7.Level.MID;
					else return Student7.Level.LOW;
				},Collectors.counting()));
		
		for(Student7.Level key:stuCntByLevel.keySet())
			System.out.printf("[%s] - %d��, ",key,stuCntByLevel.get(key));
		System.out.println();
		
		System.out.printf("%n4. ���߱׷�ȭ(�г⺰, �ݺ�)%n");
		Map<Integer,Map<Integer,List<Student7>>> stuByHakAndBan = 
				Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student7::getHak,Collectors.groupingBy(Student7::getBan)));
		
		for(Map<Integer,List<Student7>> hak : stuByHakAndBan.values()) {
			for(List<Student7> ban:hak.values()) {
				System.out.println();
				for(Student7 s:ban)
					System.out.println(s);
			}
		}
		
		System.out.printf("%n5. ���� �׷�ȭ+���(�г⺰, �ݺ� 1��)%n");
		Map<Integer,Map<Integer,Student7>> topStuByHakAndBan=
				Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student7::getHak,
						Collectors.groupingBy(Student7::getBan,
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator.comparingInt(Student7::getScore)),Optional::get))));
		for(Map<Integer,Student7> ban:topStuByHakAndBan.values())
			for(Student7 s:ban.values())
				System.out.println(s);
		
		System.out.printf("%n6. ���߱׷�ȭ + ���(�г⺰, �ݺ� �����׷�)%n");
		
		Map<String,Set<Student7.Level>> stuByScoreGroup = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->s.getHak()+"-"+s.getBan(),
						Collectors.mapping(s->{
							if(s.getScore() >= 200) return Student7.Level.HIGH;
							else if(s.getScore() >= 100) return Student7.Level.MID;
							else return Student7.Level.LOW;
						}, Collectors.toSet())));
		
		Set<String> keySet2 = stuByScoreGroup.keySet();
		
		for(String key:keySet2)
			System.out.println("["+key+"]"+stuByScoreGroup.get(key));
	}

}
