package ch14;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = {"aaa","bbb","ccc"};
		Stream<String> strStream = Stream.of(strArr);
		
		String result = strStream.collect(new ConcatCollector());
		System.out.println("result="+result);
	}

}

class ConcatCollector implements Collector<String,StringBuilder,String>{

	@Override
	public Supplier<StringBuilder> supplier() {
		// TODO Auto-generated method stub
		return ()->new StringBuilder();
	}

	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
		// TODO Auto-generated method stub
		return (sb,s)->sb.append(s);
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		// TODO Auto-generated method stub
		return (sb,sb2)->sb.append(sb2);
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		// TODO Auto-generated method stub
		return sb->sb.toString();
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}
	
}