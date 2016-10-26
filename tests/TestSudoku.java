import static org.junit.Assert.*;

import org.hamcrest.core.IsNot;
import org.junit.Test;

public class TestSudoku {

SudokuGen mSudoku = new SudokuGen();



int expectedSum = 45;	//<--unique numbers will give a sum(1 to 9) = 45	
int limit = mSudoku.sudokuArray.length;
int mockArray[]= {1,2,3,4,4,6,7,8,9}; //<--fails, actualSum = 45	
int mockArray2[]= {12,4,3,4,4,6,-7,10,9}; // <-- passes the test of actual sum = 45
int mockArray3[]= {1,2,3,4,5,6,7,8,0};  // <-- has 0


	
	//test1:  each row should not have length bigger than 9
	@Test
	public void testRowLength() {	
		mSudoku.genFirstRow();
		int expectedLength[] = { 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		int actualRowLength[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int row = 0; row < limit; row++) {
			actualRowLength[row] = mSudoku.sudokuArray[row].length;
			assertEquals(expectedLength[row], actualRowLength[row]);

		}
	}
	
	//test2: no value should be bigger than 9 or less than 1
	@Test
	public void testInvalidValues() {	
		mSudoku.genFirstRow();
		boolean isValidValue = false;
		
		for (int row = 0; row < limit; row++) {
			for (int column = 0; column < limit; column++) {
				//testing this test case using mock arrays
				//	if(mockArray2[row]<=9 && mockArray2[row]>0){ <-- will fail, since there are bigger than 9 and negatives
				//if(mockArray[row]<=9 && mockArray[row]>0){  <-- passes, since there is no invalid number
					
				if(mSudoku.sudokuArray[row][column]<=9 && mSudoku.sudokuArray[row][column]>0){
					isValidValue= true;
				}else{
					isValidValue= false;
				}
				assertTrue(isValidValue);
			}

		}
		
	}


	
	//test 3: sum of all rows should be equal to 45
	@Test
	public void testRows(){
		
		
		int actualRowSum = 0;

		mSudoku.genFirstRow();
			
		for(int row=0; row<limit; row++){
			for(int column=0; column<9; column++){				

				
			actualRowSum += mSudoku.sudokuArray[row][column]; 
				
				//actualSum += mockArray2[i];    <--- this will pass

			}
			System.out.println();
			System.out.println("for row: " +(row+1)+ " actual sum is: " +actualRowSum);

			assertEquals(expectedSum,actualRowSum);

			actualRowSum=0;
		
		}//end ROW for
		
	}//end testing rows
		
	
	//test 4: sum of all columns should be equal to 45
	@Test
	public void testCollumns(){
		mSudoku.genFirstRow();
		int actualColumnSum =0;
		for(int column=0; column<limit; column++){

			for(int row=0; row<limit; row++){		


				actualColumnSum += mSudoku.sudokuArray[row][column]; 


			}
			System.out.println();
			System.out.println("for column: " +(column+1)+ " actual sum is: " +actualColumnSum);
			assertEquals(expectedSum,actualColumnSum);
			actualColumnSum = 0; 
		}//end for column



	}//end testing collumns

	//test 5: sum of all boxes should be equal to 45 
	@Test
	public void testBoxes(){
		mSudoku.genFirstRow();
		int actualBoxSum=0;
		System.out.println();

		//basically each box gets unfolded to a row. Each row is then compared to expected sum = 45
		for(int row=0; row<limit; row+=3){
			System.out.println();
			for(int column=0; column<limit; column+=3){
				System.out.println(mSudoku.sudokuArray[row][column]);
				actualBoxSum+= mSudoku.sudokuArray[row][column];

			}
		}			
		assertEquals(expectedSum,actualBoxSum);
		actualBoxSum = 0; 

	}

}//end of class

	
	

