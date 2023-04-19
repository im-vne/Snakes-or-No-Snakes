import javax.swing.*;

public class Quiz
{
	private static int askQuestion(int q) 
	{
		String Question = "Is there a snake?"; 
		int answer = 0;
        String[] options = {"Yes", "No", "Cancel"};
		String[] pics = {"LPS_Snakes-KSF12-IMG_6448.jpg", "FL_Snakes-RF13-IMG_2877.jpg", "FL_empty-RF10-IMG_0171.jpg", "LPS_Snakes-SSF6-IMG_5403.jpg", "FL_empty-WF7-IMG_0247.jpg", "FL_empty-WF2-IMG_4933.jpg"};

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
		float numberQuestions = c + i;
		String final_str = "";
		float pointsPerQuestion = 100 / numberQuestions;
		float score = c * pointsPerQuestion;
		
		final_str += "You answered " + c + " correctly and " + i + " incorrectly";
		final_str += "\nYour accuracy is: " + score + "%";
		
		JOptionPane.showMessageDialog(null, final_str);
	}

	public static void main(String[] args)
	{
		int correct = 0;
		int incorrect = 0; 
		int response = 0;
		
		
		int[] correctAnswer = {0, 0, 1, 0, 1, 1}; // array holding correct answers in boolean form

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