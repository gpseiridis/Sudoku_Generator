
public class SudokuGen {

		public int [] rowArray;
		public int [][] sudokuArray;
		private String rowOrNot=" ";
		
		
		public static void main(String[] args) {
								
			SudokuGen sGen = new SudokuGen();
			sGen.genFirstRow();

		}		

		public SudokuGen() {
			rowArray = new int [9]; //has 9 elements
			sudokuArray= new int [9][9]; // 9 X 9 array
			
		
		}


		public void genFirstRow() {
			System.out.println("1st row created!");
			
			int index=0;
			
			
			//Generate unique numbers from 1 to 9
			while(index<9){			
				int j= (int)(Math.random()*9+1);			
				rowArray[index]=j;			
				
				//must not allow 2 same numbers in the array
				for(int i=0; i<index; i++){
					if(rowArray[i]==j){
						index--;
						
						
					}
						
				}
				
				
				index++;
				
			}
			
		
			
		
			printSudoku();
			
		}	
		
		public void printSudoku() {
			
			System.out.println();
			System.out.println(" ---------------------------------");
			for(int i=0; i<9; i++){
				//System.out.print(" | ");
				
				if(i>0)
					moveThree();
				
				if(i==3|| i==6 ){
					
					System.out.println(" ---------------------------------");					 
					System.out.print(" | ");
					
				}else{
					System.out.print(" | ");
				}
				
				//made this to avoid same line repeating
				if(i==3 || i == 6){
					shiftCell();
					
				}
				
				for(int j = 0; j<9; j++){
					
					sudokuArray[i][j] = rowArray[j];
					System.out.print(rowArray[j]+rowOrNot+ " ");
					if(j==1 || j==4|| j==7 ||j==-2){
						rowOrNot=" | ";
					}
					else{
						rowOrNot =" ";
					}
					
				}
				
				System.out.println();
			}
			System.out.println(" ---------------------------------");
			System.out.println();
			
			for(int i=0; i<rowArray.length; i++){
				System.out.println();
				for(int j=0; j<rowArray.length; j++){
					System.out.print(sudokuArray[i][j]);
					
				}
			}
			System.out.println();
			
		
		}//end of method print Sudoku
		
		

		public void moveThree() {
			int temp=0;
		//the temp will be the value of first index in the array (0)
			//ASCII for the first column out of 3 for each block
		// j=  0 1 2  3 4 5   6 7 8
			//|1 5 4| 8 7 3 | 2 9 6|      <--- 1st row 
			//|8 - -| 2 - - | 1 - -|      <--- 2nd row
			//for second line ASCII
			//|1 5 4| 8 7 3 | 2 9 6|      <--- 1st row 
			//|8 7 -| 2 9 - | 1 5 -|      <--- 2nd row
			//for third line ASCII
			//|1 5 4| 8 7 3 | 2 9 6|      <--- 1st row 
			//|8 7 3| 2 9 6 | 1 5 4|      <--- 2nd row
		//HOWEVER, the 4th line will be the same with the first line.
			temp = rowArray[0]; rowArray[0]=rowArray[3]; rowArray[3]= rowArray[6]; rowArray[6]= temp;
			temp = rowArray[1]; rowArray[1]=rowArray[4]; rowArray[4]= rowArray[7]; rowArray[7]= temp;
			temp = rowArray[2]; rowArray[2]=rowArray[5]; rowArray[5]= rowArray[8]; rowArray[8]= temp;

		}
		
		public void shiftCell() {
			
			int temp =0;
			//each 3 cells in the boxes get swapped-shifted
			//ASCII
			//|1 5 4| 8 7 3 | 2 9 6|   will become 
			//|5 4 1| 7 3 8 | 9 6 2|
			temp = rowArray[0]; rowArray[0]=rowArray[1]; rowArray[1]= rowArray[2]; rowArray[2]= temp;
			temp = rowArray[3]; rowArray[3]=rowArray[4]; rowArray[4]= rowArray[5]; rowArray[5]= temp;
			temp = rowArray[6]; rowArray[6]=rowArray[7]; rowArray[7]= rowArray[8]; rowArray[8]= temp;

		}


	}
