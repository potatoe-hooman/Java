	public static void main(String [] args) {

	    int trials = 100;

	    String textfile = "data/warAndPeace.txt";
		
		int increment = 10000;

		int numSteps = 20;
		
		int start = 10000;
		
		System.out.println("Number of Chars\t"+"BasicTime\t"+"EfficientTime");
		for (int numToCheck = start; numToCheck < numSteps*increment + start; 
				numToCheck += increment)
		{  			
			String in = getStringFromFile(textfile,numToCheck);

			BasicDocument d = new BasicDocument(in); 
			EfficientDocument ed = new EfficientDocument(in); 
      
      // initialising document before looping each time will make this run faster
      // probablty the bug I didn't understood yesterady.
      
			System.out.print(numToCheck + "\t");
       // how to calculate time
			Long startW = System.nanoTime(); 
			for(int i=0;i<trials;i++) {
			d.getFleschScore();
			}
			long end= System.nanoTime();
			long elapsed = end-startW;
			Double bDT= elapsed/1000000000.0;
			System.out.print(bDT +"\t");
						
		
			 startW = System.nanoTime(); 
			for(int i=0;i<trials;i++) {
			ed.getFleschScore();
			}
			 end= System.nanoTime();
			 elapsed = end-startW;
			 bDT= elapsed/1000000000.0;
			System.out.print(bDT +"\n");
		}
	
	}
