package dan.swetraining.hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

	@Test
	void test() {
		HelloWorld hw = new HelloWorld();
		
		assertEquals("HELLO WORLD", hw.returnUpper("hello world"));
	}

}
