import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Word {
	String correctWord; // stores the correct instance of the ordering of the characters in the word
	String randomWord; // store the randomized sequence of words to be displayed to the user
	String[] allWords; // a dictionary containing all the words available for this game
	static Set<Integer> usedIndexes = new HashSet<Integer>();

	public Word() {
		correctWord = "";
		randomWord = "";
		allWords = new String[100];
		initializeAllWords();
		
	}

	protected static String randomizeWordCharacters(String str) {

		// shuffle the characters in the word
		List<String> letters = new ArrayList<String>();
		String temp = "";

		for (int i = 0; i < str.length(); i++) {
			letters.add(String.valueOf(str.charAt(i)));
		}
		System.out.println("");

		Collections.shuffle(letters);

		for (int i = 0; i < str.length(); i++) {
			temp += letters.get(i);
		}
		return temp;
	}

	/**
	 * Generate a Random number and pick the value at that index from the
	 * dictionary. This method does not return a value that has already been used in
	 * this iteration of the game
	 */
	protected  String getRandonWordFromDictionary() {
		Random randomNumberGenerator = new Random();
		int index;
		boolean keepLooking = true;
		String currentWord = null;

		while (keepLooking) {
			index = randomNumberGenerator.nextInt(42);

			if (usedIndexes.contains(index)) {
				continue;
			} else {
				currentWord = allWords[(int) index];
				usedIndexes.add(index);
				keepLooking = false;
			}
		}
		return currentWord;
	}

	/**
	 * Adds a list of random words to the allWords Set to be used later in the
	 * program
	 */
	private void initializeAllWords() {
		allWords[0] = "Ahnaf";
		allWords[1] = "Awsaf";
		allWords[2] = "consider";
		allWords[3] = "ajraf";
		allWords[4] = "runa";
		allWords[5] = "tazrin";
		allWords[6] = "kabir";
		allWords[7] = "humayun";
		allWords[8] = "minute";
		allWords[9] = "evidence";
		allWords[10] = "practice";
		allWords[11] = "concern";
		allWords[12] = "commit";
		allWords[13] = "issue";
		allWords[14] = "approach";
		allWords[15] = "establish";
		allWords[16] = "engage";
		allWords[17] = "obtain";
		allWords[18] = "mosque";
		allWords[19] = "ramadan";
		allWords[20] = "straight";
		allWords[21] = "stock";
		allWords[22] = "property";
		allWords[23] = "building";
		allWords[24] = "concept";
		allWords[25] = "court";
		allWords[26] = "project";
		allWords[27] = "python";
		allWords[28] = "anaconda";
		allWords[29] = "america";
		allWords[30] = "level";
		allWords[31] = "generate";
		allWords[32] = "school";
		allWords[33] = "university";
		allWords[34] = "league";
		allWords[35] = "cricket";
		allWords[36] = "football";
		allWords[37] = "apocalypse";
		allWords[38] = "grant";
		allWords[39] = "confer";
		allWords[40] = "entertain";
		allWords[41] = "conversation";
		allWords[42] = "convention";
		allWords[43] = "skill";
		allWords[44] = "territory";
		allWords[45] = "undertake";
	} // end of initializeAllWords()

	public static void main(String[] args) {
		Word wrd = new Word();
		String currentWord = wrd.getRandonWordFromDictionary();
		String shuffledWord = wrd.randomizeWordCharacters(currentWord);
		System.out.println(currentWord);
		System.out.println(shuffledWord);
	}
}
