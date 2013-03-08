package com.photoShare.message;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class MessageReader {

	public void ReadGlobalMessages() {

		Digester digester = new Digester();

		final MessagePool pool = MessagePool.getInstance();

		XMLReader reader;

		try {
			reader = digester.getXMLReader();
			reader.setContentHandler(new ContentHandler() {
				String key = "";
				Message message;

				public void startPrefixMapping(String prefix, String uri)
						throws SAXException {
					// TODO Auto-generated method stub

				}

				public void startElement(String uri, String localName,
						String qName, Attributes atts) throws SAXException {
					if (qName.equals("message")) {
						message = new Message();
						key = atts.getValue("key");
					} else if (qName.equals("property")) {
						message.putMessage(atts.getValue("name"),
								atts.getValue("value"));
					}
				}

				public void startDocument() throws SAXException {
					// TODO Auto-generated method stub

				}

				public void skippedEntity(String name) throws SAXException {
					// TODO Auto-generated method stub
					
				}

				public void setDocumentLocator(Locator locator) {
					// TODO Auto-generated method stub

				}

				public void processingInstruction(String target, String data)
						throws SAXException {
					// TODO Auto-generated method stub

				}

				public void ignorableWhitespace(char[] ch, int start, int length)
						throws SAXException {
					// TODO Auto-generated method stub

				}

				public void endPrefixMapping(String prefix) throws SAXException {
					// TODO Auto-generated method stub

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (qName.equals("message")) {
						pool.putKey(key, message);
					}
				}

				public void endDocument() throws SAXException {
					// TODO Auto-generated method stub

				}

				public void characters(char[] ch, int start, int length)
						throws SAXException {
					// TODO Auto-generated method stub

				}
			});
			File file = new File("messages.xml");
			InputStream stream = new FileInputStream(file);
			reader.parse(new InputSource(stream));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MessageReader mr = new MessageReader();
		mr.ReadGlobalMessages();
	}
}
