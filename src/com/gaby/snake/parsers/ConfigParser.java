package com.gaby.snake.parsers;

import java.io.InputStream;

import test.TestConfigParser;

import com.gaby.snake.configuration.SnakeConf;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConfigParser {

	public SnakeConf parseXMLFromStream() {

		try {
			InputStream in = (InputStream) TestConfigParser.class
					.getResourceAsStream("config.xml");
			System.out.println(in != null);
			in = (InputStream) TestConfigParser.class.getClassLoader()
					.getResourceAsStream("config.xml");

			XStream xs = new XStream(new DomDriver());
			xs.processAnnotations(SnakeConf.class);
			SnakeConf sc = (SnakeConf) xs.fromXML(in);
			return sc;

		} catch (Exception ex) {

			System.out.println(ex);
			return null;
		}

	}
}
