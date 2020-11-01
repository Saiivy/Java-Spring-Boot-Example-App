package ca.sheridancollege.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.SquareMatrix;
import ca.sheridancollege.beans.StringForm;

@Controller
public class HomeController {
	private char[][] matrix;
	private int inLegthOfMatrix;

	@GetMapping("/")
	public String goMatrixForm(Model model)
	{
		model.addAttribute("squareMatrix", new SquareMatrix());
		return "form.html";
	}
	
	@GetMapping("/matrixFormResults")
	public String populateMatrix(Model model, @ModelAttribute SquareMatrix squareMatrix)
	{
		inLegthOfMatrix = squareMatrix.getLength();
		matrix = new char[squareMatrix.getLength()][squareMatrix.getLength()];
		Random rand = new Random();
		for (int i=0;i<matrix.length;i++)
		{
			for (int j=0;j<matrix.length;j++)
			{
				matrix[i][j]=(char)(rand.nextInt(26)+97);
			}
		}
		
		model.addAttribute("matrix",matrix);
		model.addAttribute("stringForm", new StringForm());
		
		return "display.html";
	}
	
	@GetMapping("/stringFormResults")
	public String searchString(Model model, @ModelAttribute SquareMatrix squareMatrix, @ModelAttribute StringForm stringForm) {
	    
		//Length of matrix
		System.out.println("Length of matrix " +inLegthOfMatrix);				

		//Entered String by the user.
		String enteredString = stringForm.getString();
		
		//Converting the array to string
		String convertedArray = charToString(matrix);
		
		//Printing String
		System.out.println("String:" +enteredString);
		
		//COnverted array
		System.out.println("Matrix:" +convertedArray);
		
		//Condition if the string exists on principal diagonal.
	    if(checkPrincipalDiagonal(matrix,inLegthOfMatrix)||(checkSecondaryDiagonal(matrix,inLegthOfMatrix))||convertedArray.contains(enteredString)) {
		System.out.println("YES Entered String exists!");
	}
		else {
			System.out.println("The String Is Incorrect!");
		}
		return "display.html";
	}
	
	
	/**
	 * Converts a char 2d array to string.
	 * @param matrix
	 * @return Converted String
	 */
	public String charToString(char[][] matrix) {
	    String s = "";
	    for (int i=0; i < matrix.length; i++) {
	        for (int j=0; j < matrix[i].length; j++) {
	            s += matrix[i][j];
	        }
	        // uncomment next line if you want the maze to have rows
	        // s += "\n";
	    }
	    return s.toString();
	}
	
	/**
	 * checks if the inserted string matches the principal diagonal of square matrix.
	 * @param matrix: Matrix of specified length
	 * @param length: length of the matrix
	 * @return
	 */
	private static boolean checkPrincipalDiagonal(char mat[][], int length) {
        System.out.print("Principal Diagonal: ");
 
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
 
                // Condition for principal diagonal
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }
    
	/**
	 * checks if the inserted string matches the principal diagonal of square matrix.
	 * @param matrix: Matrix of specified length
	 * @param length: length of the matrix
	 * @return
	 */
    private static boolean checkSecondaryDiagonal(char matrix[][], int length)
    {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // Condition for secondary diagonal
                if ((i + j) == (length - 1)) {
                    return true;
                }
            }
        }
        return false;
    }
	
	}

