
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
  public static void printAllGenes(String dna){
    while(true){
        Sring gene = findGene(dna);
        if (gene.isEmpty())
        { break;}
        else
        {System.out.println("Gene is" +gene);}
    }
            }
  public static int  findStopCodon(String dna, int startIndex, String stopCodon){
                int currIndex = dna.indexOf(stopCodon,startIndex+3);
                while(currIndex != -1){
                 int diff=currIndex-startIndex;
                    if(diff%3==0){
                        return currIndex;
                    }
                    else {
                        currIndex=dna.indexOf(stopCodon,currIndex+1);
                 }
                } 
                return -1;
   }
   public static void testFindStopCodon (){
        Part1 xy= new Part1();
        String a = "ATGTGCAATGATCAGTAA";
        String b = "ATGGGATATGCATATACGAA";
        String C = "ATGTACTAGCTAGCTAG";
        int value= findStopCodon(a,0,"TAG");
        //try with b and c with different value of startIndex
        System.out.println(value);
        }
        public static String findGene(String dna){
            int start= dna.indexOf("ATG");
            if (start == -1){
                return "";
            }
            // find end using findStopCodon
            int taaIndex=findStopCodon(dna, start, "TAA");
            int tagIndex=findStopCodon(dna, start, "TAG");
            int tgaIndex=findStopCodon(dna, start, "TGA");
            int minIndex=0;
            if(taaIndex==-1||(tagIndex!=-1 && tagIndex<taaIndex)){
            minIndex=tagIndex;
            } 
            else { minIndex=taaIndex;
            }
            if(minIndex==1 ||(tgaIndex!=-1 && tgaIndex<minIndex)){
            minIndex=tgaIndex;
            }
            if (minIndex==-1){
            return"";}            
            return dna.substring(start,minIndex+3);
    }
    public static void testFindGene(){
        String a="ATGGACTAGATACTGTATAG", b="ATCGTATGAGTCATGCATAGTGCTAGTCGATGT",c="CTGTCTGAATCGTATGCTGTATGC";
        System.out.println("Gene found are as :\n 1." +findGene(a));// + +"\n 3." +findGene(c));
        System.out.println(" 2." +findGene(b));
        System.out.println(" 3." +findGene(c));
    }
}
