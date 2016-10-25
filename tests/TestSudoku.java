import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudoku {

SudokuGen mSudoku = new SudokuGen();

	
	//test 1: rows = 45
	// test 2 : columns = 45
	// test 3 : squares = 45
	// test 4 : des mhpws yparxei arithmos panw apo 9 'h katw apo 1
	//          tha borouse px na nai 11, -2 values
	// test 5: check if length is 9
	
int expectedSum = 45;	
int limit = mSudoku.sudokuArray.length;
public int testArray[][];
	

	
	//testing row length, init the actualRowLength and test it later
	@Test
	public void testRowLength() {

		int expectedLength[] = { 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		int actualRowLength[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int row = 0; row < limit; row++) {
			actualRowLength[row] = mSudoku.sudokuArray[row].length;
			assertEquals(expectedLength[row], actualRowLength[row]);

		}
	}
		
	//unique numbers will give a sum(1 to 9) = 45
	//testing if all rows will have a sum of 45
	@Test
	public void testRows(){
		
		int mockArray[]= {1,2,3,4,4,6,7,8,9}; //<--fails, actualSum = 45	
		int mockArray2[]= {12,4,3,4,4,6,-7,10,9}; // <-- passes the test of actual sum = 45
		int actualRowSum = 0;

		mSudoku.genFirstRow();
			
		for(int row=0; row<limit; row++){
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
		
	
		//testing if all collumns have sume of 45
		@Test
		public void testCollumns(){
			mSudoku.genFirstRow();
			int actualColumnSum =0;
			for(int column=0; column<limit; column++){
				
				for(int i=0; i<limit; i++){		
					
				
				actualColumnSum += mSudoku.sudokuArray[i][column]; 
				
				
				}
				System.out.println();
				System.out.println("for column: " +(column+1)+ " actual sum is: " +actualColumnSum);
				assertEquals(expectedSum,actualColumnSum);
				actualColumnSum = 0; 
			}//end for column
			
		
		
		}//end testing collumns
		
		//testing if all the boxes have a sum of 45
		@Test
		public void testBoxes(){
			mSudoku.genFirstRow();
			int actualBoxSum=0;
			System.out.println();
			
			//basically each box gets unfolded to a row. Each row is then compared to expected sum = 45
			for(int i=0; i<limit; i+=3){
				System.out.println();
				for(int j=0; j<limit; j+=3){
					System.out.println(mSudoku.sudokuArray[i][j]);
					actualBoxSum+= mSudoku.sudokuArray[i][j];
					
				}
			}			
			assertEquals(expectedSum,actualBoxSum);
			actualBoxSum = 0; 
			
		}
		
}//end of class

	
	

