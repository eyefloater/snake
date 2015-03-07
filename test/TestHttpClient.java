import org.junit.Test;

import com.gaby.snake.HttpCommunicator;

public class TestHttpClient {

private HttpCommunicator httpcommunicator;

	@Test
	public void test() {
		httpcommunicator = new HttpCommunicator();
		String response = httpcommunicator.get("test");
		int k = 0;
	}
}