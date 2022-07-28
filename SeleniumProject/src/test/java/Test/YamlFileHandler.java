package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlFileHandler {
	
	public static String readData() throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(new File("C:\\Users\\PREKSHA\\eclipse-workspace\\SeleniumProject\\src\\main\\resources\\file.yaml"));

		Yaml yaml = new Yaml();
		Map<String, String> data = yaml.load(inputStream);
		String answer = data.get("url");
		return answer;
	}
	public static void main(String[] args) throws FileNotFoundException {

		readData();
	}
}


