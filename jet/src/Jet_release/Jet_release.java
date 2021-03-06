package Jet_release;

import java.io.IOException;
import AceJet.Ace;
import AceJet.AureDiDMCNNData;
import AceJet.AureDiTrainData;
import AceJet.AureDiTriggerAna;
import AceJet.AureDi_Test;
import AceJet.EventScorer;
import AceJet.AureDiEventTypeAnalysis;
import AceJet.AureDiSentenceAnalysis;
import AceJet.TrainEventTagger;

public class Jet_release {

    /**
     * @param args the command line arguments
     * @args[0]: train or test
     * @args[1]: property file
     * @args[2]: the list of test file
     * @args[3]: the folder of test files
     * @args[4]: the output folder
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        args = new String[5];
//        args[0] = "-train";
//        args[1] = "D:\\GitHub\\Jet\\jet\\props\\ace11chunker.properties";
//        args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\new_filelist_ACE_training";;
//        args[3] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\";
//        args[4] = "D:\\GitHub\\Jet\\jet\\Trainout\\";

    	//@AureDi args[2] specify the list of test file, we found that the name of file should include extension and not include 
    	// any path. the args[3] should specify the full path of test file.

//        args = new String[5];
//        args[0] = "-test";
//        args[1] = "D:\\GitHub\\Jet\\jet\\props\\ace11chunker.properties";
//        args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\new_filelist_ACE_test-test";
//        args[3] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\timex2norm\\";
//        args[4] = "D:\\GitHub\\Jet\\jet\\output\\";

//        args = new String[8];
//        args[0] = "-score";
//        args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\new_filelist_ACE_test-score";
//        args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\timex2norm\\";
//        args[3] = "sgm";
//        args[4] = "D:\\GitHub\\Jet\\jet\\output";
//        args[5] = "sgm.apf";      
//        args[6] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\timex2norm\\";
//        args[7] = "apf.xml";
    	
//          args = new String[5];
//          args[0] = "-test";
//          args[1] = "D:\\GitHub\\Jet\\jet\\props\\ace11chunker.properties";
//          args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\fp1\\Testfile";
//          args[3] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\fp1\\";
//          args[4] = "D:\\GitHub\\Jet\\jet\\output-fp1\\";
        
//        args = new String[8];
//        args[0] = "-score";
//        args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\fp1\\Testfile-score";
//        args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\fp1\\";
//        args[3] = "sgm";
//        args[4] = "D:\\GitHub\\Jet\\jet\\output-fp1";
//        args[5] = "sgm.apf";      
//        args[6] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\nw\\fp1\\";
//        args[7] = "apf.xml";
        
//      args = new String[6];
//      args[0] = "-EventTypeAnalysis";
//      args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\ACE_List";
//      args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//      args[3] = "sgm";    
//      args[4] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//      args[5] = "apf.xml";
        
//		args = new String[6];
//		args[0] = "-SentenceAnalysis";
//		args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\new_filelist_ACE_test";
//		args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[3] = "sgm";    
//		args[4] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[5] = "apf.xml";   
        
//		args = new String[7];
//		args[0] = "-AureDiTrainData";
//		args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\new_filelist_ACE_training_anchorwithintext";//new_filelist_ACE_test";
//		args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[3] = "sgm";    
//		args[4] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[5] = "apf.xml"; 
//		args[6] = "C:\\Users\\v-mingdi\\Desktop\\ACE_training";
		
//		args = new String[7];
//		args[0] = "-AureDiDMCNNData";
//		args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\new_filelist_ACE_training_anchorwithintext";//new_filelist_ACE_test";
//		args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[3] = "sgm";    
//		args[4] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[5] = "apf.xml"; 
//		args[6] = "C:\\Users\\v-mingdi\\Desktop\\ACE_DMCNN_training";
		
		args = new String[7];
		args[0] = "-AureDiTriggerAna";
		args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\ACE_List";//new_filelist_ACE_test";
		args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
		args[3] = "sgm";    
		args[4] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
		args[5] = "apf.xml"; 
		args[6] = "C:\\Users\\v-mingdi\\Desktop\\ACE_Trigger";
		
//		args = new String[6];
//		args[0] = "-AureDi_Test";
//		args[1] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English\\ACE_List";//test";//new_filelist_ACE_test";
//		args[2] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[3] = "sgm";    
//		args[4] = "D:\\Corpus\\LDC2006D06\\Data\\LDC2006T06_Original\\data\\English";
//		args[5] = "apf.xml"; 
        
        if (args.length != 5 && args.length != 6 && args.length != 8 && args.length != 7) {
            PrintErrMsg();
            System.exit(1);
        }
        switch (args[0]) {
            case "-train":
                //Ace.Testing = false;
                String[] train_args = new String[4];
                for (int i = 0; i < 4; i++) {
                    train_args[i] = args[i + 1];
                }
                TrainEventTagger.main(train_args);
                break;
            case "-test":
                String[] test_args = new String[4];
                for (int i = 0; i < 4; i++) {
                    test_args[i] = args[i + 1];
                }
                Ace.main(test_args);
                break;    
            case "-score":
                String[] score_args = new String[7];
                for (int i = 0; i < 7; i++) {
                    score_args[i] = args[i + 1];
                }
                EventScorer.main(score_args);
                break;
            case "-EventTypeAnalysis":
                String[] EventTypeAnalysis_args = new String[5];
                for (int i = 0; i < 5; i++) {
                	EventTypeAnalysis_args[i] = args[i + 1];
                }
                AureDiEventTypeAnalysis.main(EventTypeAnalysis_args);
                break;
            case "-SentenceAnalysis":
                String[] SentenceAnalysis_args = new String[5];
                for (int i = 0; i < 5; i++) {
                	SentenceAnalysis_args[i] = args[i + 1];
                }
                AureDiSentenceAnalysis.main(SentenceAnalysis_args);
                break;
            case "-AureDiTrainData":
                String[] AureDiTrainData_args = new String[6];
                for (int i = 0; i < 6; i++) {
                	AureDiTrainData_args[i] = args[i + 1];
                }
                AureDiTrainData.main(AureDiTrainData_args);
                break;
            case "-AureDiDMCNNData":
                String[] AureDiDMCNNData_args1 = new String[6];
                for (int i = 0; i < 6; i++) {
                	AureDiDMCNNData_args1[i] = args[i + 1];
                }
                AureDiDMCNNData.main(AureDiDMCNNData_args1);
                break;
            case "-AureDiTriggerAna":
                String[] AureDiTriggerAna_args1 = new String[6];
                for (int i = 0; i < 6; i++) {
                	AureDiTriggerAna_args1[i] = args[i + 1];
                }
                AureDiTriggerAna.main(AureDiTriggerAna_args1);
                break;
            case "-AureDi_Test":
                String[] AureDi_Test_args = new String[5];
                for (int i = 0; i < 5; i++) {
                	AureDi_Test_args[i] = args[i + 1];
                }
                AureDi_Test.main(AureDi_Test_args);
                break;
            default:
                PrintErrMsg();
                break;
        }
        
    }
    
    private static void PrintErrMsg() {
        System.err.print("Input format error!\n"
                + "\n"
                + "Correct format:\n"
                + "	JET_release -train properties trainfilelist traindocumentDir ModeloutputDir\n"
                + "or\n"
                + "	JET_release -test properties testfilelist testdocumentDir testoutputDir\n");

    }

}
