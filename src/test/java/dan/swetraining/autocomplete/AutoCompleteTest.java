package dan.swetraining.autocomplete;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AutoCompleteTest {

	@Test
	public void testDictionaryImport() {
		AutoComplete a = new AutoComplete();
		
		List<String> input = Arrays.asList(new String[] {"aaa", "aab", "aac", "aba", "aca", "baa", "caa"});
		
		a.importDictionary(input);
		
		assertEquals(a.dic.get(3), input.get(3));
		assertEquals(a.dic.size(), input.size());
	}
	
	@Test
	public void testDictionaryQuery() {
		AutoComplete a = new AutoComplete();
		
		List<String> input = Arrays.asList(new String[] {"aaa", "aab", "aac", "aba", "aca", "baa", "caa"});
		
		a.importDictionary(input);
		

		assertEquals(Arrays.asList(new String[] {"aaa", "aab", "aac", "aba", "aca"}),a.query("a", 5));
		assertEquals(Arrays.asList(new String[] {"aaa", "aab", "aac"}),a.query("aa", 5));
		assertEquals(Arrays.asList(new String[] {"aac"}),a.query("aac", 5));
		assertEquals(Arrays.asList(new String[] {}),a.query("invalid", 5));
		
		assertEquals(Arrays.asList(new String[] {"aaa"}),a.query("a", 1));

	}
}
