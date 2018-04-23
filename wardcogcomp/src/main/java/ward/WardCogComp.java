package ward;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation;
import edu.illinois.cs.cogcomp.core.utilities.configuration.ResourceManager;
import edu.illinois.cs.cogcomp.nlp.utility.TokenizerTextAnnotationBuilder;
import edu.illinois.cs.cogcomp.annotation.TextAnnotationBuilder;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.ner.NERAnnotator;
import edu.illinois.cs.cogcomp.nlp.tokenizer.IllinoisTokenizer;
import edu.illinois.cs.cogcomp.ner.LbjTagger.*;
import java.io.IOException;

import java.util.Properties;
public class WardCogComp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String text1 = "Good afternoon, gentlemen. I am a HAL-9000 "
	            + "computer. I was born in Urbana, Il. in 1992";

	        String corpus = "2001_ODYSSEY";
	        String textId = "001";

	        // Create a TextAnnotation using the LBJ sentence splitter
	        // and tokenizers.
	        TextAnnotationBuilder tab;
	        tab = new TokenizerTextAnnotationBuilder(new IllinoisTokenizer());

	        TextAnnotation ta = tab.createTextAnnotation(corpus, textId, text1);

	        NERAnnotator co = new NERAnnotator(ViewNames.NER_CONLL);
	        co.doInitialize();

	        co.addView(ta);

	        System.out.println(ta.getView(ViewNames.NER_CONLL));
	}

}
