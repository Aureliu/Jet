package AceJet;

/**
 *  This function calculate the number of triggers in each sentence.
 *  v-mingdi September 28th, 2015
 */


import java.util.*;
import java.io.*;
import Jet.Tipster.*;
import Jet.Zoner.SentenceSplitter;
import Jet.Zoner.SpecialZoner;

public class AureDi_Test{
	
	static String textDirectory;
	static String textExtension;
	static String keyApfDirectory;
	static String keyApfExtension;
	static Map<Integer, Integer> store_corpus = new HashMap<Integer, Integer> ();
	static Map<Integer, Integer> store_doc = new HashMap<Integer, Integer> ();
	
	public static void main(String[] args) throws IOException {
		
		String docListFile = args[0];
		textDirectory = args[1];
		textExtension = args[2];
		keyApfDirectory = args[3];
		keyApfExtension = args[4];
		
        File writename = new File("C:\\Users\\v-mingdi\\Desktop\\Test-all"); // path + filename.
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
        out.flush(); // write the buffer to the file.
        out.close(); // close the file  
        docListReader.close();
	}
	
	/**
	 *  This function calculate the number of triggers in each sentence.
	 *  v-mingdi September 1th, 2015
	 */
	public static void processDocument (String docName, BufferedWriter out) {
				
		int NumTrigger = 0;	// Record the number of triggers in this document.
		
		// open the doc to be processed
		String textFileName = textDirectory + "/" + docName + "." + textExtension;
		ExternalDocument doc = new ExternalDocument("sgml", textFileName);	//creates a new external document associated with file 'fileName'.  The format of the file is given by 'format'.
		doc.setAllTags(true);
		doc.open();		
		
		// split the sentence in this doc
		Vector<Annotation> textSegments = doc.annotationsOfType ("TEXT");
		Span span;
		if (textSegments != null && textSegments.size() > 0)
			span = textSegments.get(0).span();	//@di ? the span of doc = text to be processed
		else
			span = doc.fullSpan();
		if (doc.annotationsOfType("dateline") == null && 
			    doc.annotationsOfType("textBreak") == null)
				SpecialZoner.findSpecialZones (doc);
		//code from control.applyScript()
		SentenceSplitter.split(doc, span);
		Vector zones = doc.annotationsOfType("sentence", span);		
		
		// record the trigger in this doc
		Map<Integer, Span> store_trigger= new HashMap<Integer, Span> ();
		String keyApfFileName = keyApfDirectory + "/" + docName + "." + keyApfExtension;
		// ^ very important.creat structure data of text based on text and annotation,
		// | traverse event in aceDoc. just event, may include multiple event mention
		
		//@AureDI  Write the text to the file.
		int start = ((Annotation) zones.get(0)).span().start();
		int end = ((Annotation) zones.get(0)).span().end();
		try {		
			String text = doc.text().substring(start, end);
			StringBuffer Text = new StringBuffer(text); 	
			for( int j = 0; j < text.length(); j++){
        		if (text.charAt(j) == '\n'){       			
        			Text.deleteCharAt(j);
        			Text.insert(j, ' ');
        		}
			}
			out.write(docName + "****" + Text.toString() + "_$_NoEvent" + "\r\n");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static String getFileNameNoEx(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length()))) {   
                return filename.substring(0, dot);   
            }   
        }   
        return filename;   
    } 
}
