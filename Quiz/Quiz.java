import javax.swing.*;

public class Quiz
{
	private static int askQuestion(int q) 
	{
		String Question = "Is there a snake?"; 
		int answer = 0;
        String[] options = {"Yes", "No", "Cancel"};
		String[] pics = {"IMG_0074.jpg", "IMG_0073.jpg", "IMG_0071.jpg", "IMG_0037.jpg", "IMG_0035.jpg"};

		do 
		{
            ImageIcon icon = new ImageIcon(pics[q]);
			answer = JOptionPane.showOptionDialog(null, null, Question, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                icon, options, options[0]);
			if(answer == 2) { // if user selects "Cancel"
				int quit = JOptionPane.showConfirmDialog(null, "Would you like to quit?", "Quit", JOptionPane.YES_NO_OPTION);
				if(quit == 0)
					return -1;
				else
					continue;
			}
		} while (answer == 2); 
		
		return answer;
	}

	private static boolean isCorrect(int a, int i) 
	{
		if(a == i)
		{
			JOptionPane.showMessageDialog(null, "Correct!");
			return true;
		}
		else
		{
            if (a == 0){
                JOptionPane.showMessageDialog(null, "The correct answer is: \n Yes");
            }else {
                JOptionPane.showMessageDialog(null, "The correct answer is: \n No");
            }
			return false;
		}
	}

	public static void showScore(int c, int i)
	{
		int numberQuestions = c + i;
		String final_str = "";
		int pointsPerQuestion = 100 / numberQuestions;
		int score = c * pointsPerQuestion;
		
		final_str += "You answered " + c + " correctly and " + i + " incorrectly";
		final_str += "\nYour score is: " + score + "%";
		
		JOptionPane.showMessageDialog(null, final_str);
	}

	public static void main(String[] args)
	{
		int correct = 0;
		int incorrect = 0; 
		int response = 0;
		
		
		int[] correctAnswer = {0, 1, 0, 1, 0}; // array holding correct answers in boolean form

        for (int i = 0; i < correctAnswer.length; ++i) {
			response = askQuestion(i);
			if(response == -1)
				return;
			if(isCorrect(correctAnswer[i], response))
				correct++;
			else
				incorrect++;
        }
		
		showScore(correct, incorrect);
	}
}