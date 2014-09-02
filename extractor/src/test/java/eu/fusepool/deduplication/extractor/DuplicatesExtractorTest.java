package eu.fusepool.deduplication.extractor;



import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;

import org.apache.clerezza.rdf.core.Triple;
import org.apache.clerezza.rdf.core.TripleCollection;
import org.apache.clerezza.rdf.core.UriRef;
import org.junit.Test;

public class DuplicatesExtractorTest {

	@Test
	public void testGetSubjectObject() {
		String testString = "<http://example.org/s><http://www.w3.org/2002/07/owl#sameAs><http://example.org/o>";
		DuplicatesExtractor extractor = new DuplicatesExtractor(); 
		String subject = extractor.getSubject(testString).getUnicodeString();
		String object = extractor.getObject(testString).getUnicodeString();
		assertEquals("http://example.org/s",subject);
		assertEquals("http://example.org/o",object);
		
	}
	
	@Test
	public void testParseResult() throws IOException {
		DuplicatesExtractor extractor = new DuplicatesExtractor(); 
		TripleCollection links = extractor.parseResult("src/test/resources/testlinks.nt");
		Iterator<Triple> ilinks = links.iterator();
		while(ilinks.hasNext()){
			Triple triple = ilinks.next();
			String subject = ((UriRef) triple.getSubject()).getUnicodeString();
			String object = ((UriRef) triple.getObject()).getUnicodeString();
			assertEquals("http://example.org/s",subject);
			assertEquals("http://example.org/o",object);
		}
		
	}
	
	@Test
	public void testFindDuplicates(){
		
	}

}
