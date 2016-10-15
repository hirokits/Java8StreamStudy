package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.*;

import org.gradle.Person;


public class Sample {

	public static void main(String[] args) {
		test3();
	}
	
	private static void test3() {
		List<Data> datas = new ArrayList<>();
		datas.add(new Data("1.1"));
		datas.add(new Data("2"));
		datas.add(new Data("3"));
		datas.add(new Data("10"));
		datas.add(new Data("2.2"));
		datas.add(new Data("3"));
		datas.add(new Data("100.1"));
		datas.stream().sorted(comparing(Data::getStr).reversed())
		.forEach(d->System.out.println(d.getStr()));
	}

	private static void test2() {
		List<Data> datas = new ArrayList<>();
		datas.add(new Data("1"));
		datas.add(new Data("2"));
		datas.add(new Data(""));
		System.out.println(datas.stream().allMatch(data->data.isValid()));
		System.out.println(datas.stream().anyMatch(data->data.isValid()));
		System.out.println(datas.stream().noneMatch(data->data.isValid()));
	}

	private static void test() {
		List<Person> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) list.add(new Person(String.format("name%s", i)));
		list.forEach(person->System.out.println(person.getName()));
		
		List<String> filteringList = list.stream()
		.filter(person->person.getName().contains("1"))
		.map(person->String.format("[%s]", person.getName()))
		.collect(Collectors.toList())
		;
		filteringList.forEach(o->System.err.println(o));
	}
	
	private static class Data {
		private String str = "";
		public Data(String str) {
			super();
			this.str = str;
		}

		public String getStr() {
			return str;
		}

		private boolean isValid() {
			return str.isEmpty();
		}
	}
}
