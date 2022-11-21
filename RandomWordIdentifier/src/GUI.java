import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application {

	static int score;// holds the current score of the user
	String correctWord;
	String questionWord;
	Label scoreLbl, randomWordLbl;
	TextField answer;
	Button checkBtn;
	Word word = new Word();

	@Override
	public void start(Stage stage) throws Exception {

		initComponents(stage);

	}

	/**
	 * This function is used to initialize all the objects in the frame
	 * 
	 * @param stage
	 */
	void initComponents(Stage stage) {

		scoreLbl = new Label("Score: ");
		scoreLbl.setLayoutX(0);
		scoreLbl.setLayoutY(0);
		scoreLbl.setFont(new Font(15));

		correctWord = word.getRandonWordFromDictionary();
		questionWord = word.randomizeWordCharacters(correctWord).toUpperCase();
		randomWordLbl = new Label(questionWord);
		randomWordLbl.setLayoutX(90);
		randomWordLbl.setLayoutY(100);
		randomWordLbl.setFont(new Font(20));

		answer = new TextField();
		answer.setLayoutX(60);
		answer.setLayoutY(130);

		checkBtn = new Button("Check");
		checkBtn.setLayoutX(160);
		checkBtn.setLayoutY(157);

		//////////////////////////////////////////////////////////////////////////////
		//////////// EVENTS //////////////////////////
		//////////////////////////////////////////////////////////////////////////////
		checkBtn.setOnAction(event -> {
			String userInput = answer.getText().trim().toLowerCase();

			if (correctWord.toLowerCase().equals(userInput)) {
				score++;
				scoreLbl.setText("Score: " + score);

				playAgain();
			} else {
				score--;
				scoreLbl.setText("Score: " + score);
				displayGameOver();
			}
		});

		Group group = new Group(scoreLbl, randomWordLbl, answer, checkBtn);

		////////////////////////////////////////////////////////////////////////////////
		Scene scene = new Scene(group, 320, 240);
		stage.setScene(scene);

		stage.show();
		stage.setTitle("Random Word Finder");
	}

	void playAgain() {
		correctWord = word.getRandonWordFromDictionary();
		questionWord = word.randomizeWordCharacters(correctWord).toUpperCase();
		randomWordLbl.setText(questionWord);
		answer.clear();
	}

	void displayGameOver() {
		Alert a = new Alert(Alert.AlertType.INFORMATION);
		a.setTitle("Game Over");
		a.setContentText("You entered the wrong answer. Your Score: " + score);
		a.show();
		
		
	}

	public static void main(String[] args) {

		Application.launch();
	}

}
