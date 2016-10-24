import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudoku {

SudokuGen mSudoku = new SudokuGen();
	
	//test 1: rows = 45
	// test 2 : columns = 45
	// test 3 : tetragwno... TO PIO DUSKOLO
	// test 4 : des mhpws yparxei arithmos panw apo 9 'h katw apo 1
	//          tha borouse px na nai 11, -2 values
	// test 5: check if length is 9
	
int expectedSum = 45;	
	@Test
	public void testRowLength() {
		int expectedLength[] = { 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		int actualRowLength[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int row = 0; row < 9; row++) {
			actualRowLength[row] = mSudoku.sudokuArray[row].length;
			assertEquals(expectedLength[row], actualRowLength[row]);

		}
	}
		
	
	@Test
	public void testRows(){
		
		int mockArray[]= {1,2,3,4,4,6,7,8,9}; //<--fails, actualSum = 45	
		int mockArray2[]= {12,4,3,4,4,6,-7,10,9}; // <-- passes the test of actual sum = 45
		int actualRowSum = 0;

		mSudoku.genFirstRow();
		

		//unique numbers will give a sum(1 to 9) = 45
		for(int row=0; row<9; row++){
			for(int i=0; i<9; i++){				

				
				actualRowSum += mSudoku.sudokuArray[row][i]; 
				//actualSum += mockArray2[i];

			}
			System.out.println();
			System.out.println("for row: " +(row+1)+ " actual sum is: " +actualRowSum);

			assertEquals(expectedSum,actualRowSum);

			actualRowSum=0;
		
		}//end ROW for
		
	}//end testing rows
		
	
		@Test
		public void testCollumns(){
			mSudoku.genFirstRow();
			int actualColumnSum =0;
			for(int column=0; column<9; column++){
				
				for(int i=0; i<9; i++){		
					
				
				actualColumnSum += mSudoku.sudokuArray[i][column]; 
				
				
				}
				System.out.println();
				System.out.println("for column: " +(column+1)+ " actual sum is: " +actualColumnSum);
				assertEquals(expectedSum,actualColumnSum);
				actualColumnSum = 0; 
			}//end for column
			
		
		
		}//end testing collumns
		
		
}//end of class

	
	

