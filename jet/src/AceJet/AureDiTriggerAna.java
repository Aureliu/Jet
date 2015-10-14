package AceJet;

/**
 *  This function analyse the distribution of trigger.
 *  v-mingdi October 13th, 2015
 */

import java.util.*;
import java.io.*;
import Jet.Lex.Tokenizer;
import Jet.Tipster.*;
import Jet.Zoner.SentenceSplitter;
import Jet.Zoner.SpecialZoner;

public class AureDiTriggerAna {
	
	static String textDirectory;
	static String textExtension;
	static String keyApfDirectory;
	static String keyApfExtension;
	static String outputfile;
	static Map<String,Integer> Trigger = new TreeMap<String,Integer>();
	static Span spantest;
	
	public static void main(String[] args) throws IOException {
		
		String docListFile = args[0];
		textDirectory = args[1];
		textExtension = args[2];
		keyApfDirectory = args[3];
		keyApfExtension = args[4];
		outputfile = args[5];
		
		//@AureDi: Create a new writer to write data. 
        File writename = new File(outputfile); // path + filename.
        writename.createNewFile(); // construct a new file
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
        
		BufferedReader docListReader = new BufferedReader(new FileReader (docListFile));	//	input the file
		String docName;		// equal to currentDocPath in ACE
		while ((docName = docListReader.readLine()) != null)
		{
			//docName = getFileNameNoEx(docName);	//remove the extension of the file
			processDocument (docName, out);
			//
			System.out.println(docName);
		}	
		Iterator<Map.Entry<String, Integer>> iter = Trigger.entrySet().iterator();
		while ( iter.hasNext() ){
			Map.Entry<String,Integer> TriggerTem = iter.next();
			out.write(TriggerTem.getKey().toString() + ' ' + TriggerTem.getValue().toString() + "\r\n");
		}
		out.write(Trigger.toString() + "\r\n");
        out.flush(); // write the buffer to the file.
        out.close(); // close the file  
        docListReader.close();
	}
	
	/**
	 *  This function calculate the number of triggers in each sentence.
	 *  v-mingdi September 1th, 2015
	 */
	public static void processDocument (String docName, BufferedWriter out) {
		
	// open the doc to be processed
		String textFileName = textDirectory + "/" + docName + "." + textExtension;
		Span span;
		
// process text in Tag <TEXT>.	
		ExternalDocument doc = getDoc(textFileName,"TEXT");
		Vector<Annotation> textSegments = doc.annotationsOfType ("TEXT");
		if (textSegments != null && textSegments.size() > 0)
			span = textSegments.get(0).span();	//@di ? the span of doc = text to be processed
		else
			span = doc.fullSpan();		
		if (!span.equals(spantest))
			System.out.println("Warning: ************ Span is wrong *********** ");
		//code from control.applyScript()
		
		// record the trigger in this doc
		String keyApfFileName = keyApfDirectory + "/" + docName + "." + keyApfExtension;
		AceDocument aceDoc = new AceDocument(textFileName, keyApfFileName);	
		// ^ very important.creat structure data of text based on text and annotation,
		// | traverse event in aceDoc. just event, may include multiple event mention
		for (AceEvent event : aceDoc.events) {	
			// | traverse all event mention in event
			for (AceEventMention mention : event.mentions) {
				String key = mention.anchorText + ':' + event.subtype;
				Integer freq = Trigger.get(key);
				Trigger.put(key, freq == null ? 1 : freq+1);
			}
		}
	}
	
	public static ExternalDocument getDoc (String textFileName, String Tag){
		ExternalDocument doc = new ExternalDocument("sgml", textFileName);	//creates a new external document associated with file 'fileName'.  The format of the file is given by 'format'.
		doc.setAllTags(true);
		doc.open();		
		
		// split the sentence in this doc
		Vector<Annotation> textSegments = doc.annotationsOfType (Tag);
		if (textSegments != null && textSegments.size() > 0)
			spantest = textSegments.get(0).span();	//@di ? the span of doc = text to be processed
		else
			spantest = doc.fullSpan();
		if (doc.annotationsOfType("dateline") == null && 
			    doc.annotationsOfType("textBreak") == null)
				SpecialZoner.findSpecialZones (doc);
		return doc;
	} 
	
}