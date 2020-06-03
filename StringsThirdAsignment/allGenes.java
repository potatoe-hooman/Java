
//Example: Collections.binarySearch
//Project: ngkonstantinidis/Java_Programming-_Solving_Problems_with_Software-Duke_University
//File name: week2/allGenes.java
/**
 * Write a description of class allGenes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;

public class allGenes {
  /**
   * A method that finds all genes in a dna strand strarting with ATG coden and ending with TAG, TGA
   * or TAA coden.
   *
   * @param dna The dna strand to search for genes.
   * @return all found genes in StorageResource datatype.
   */
  public StorageResource storeAll(String dna) {
    StorageResource sr = new StorageResource();
    int start = 0;
    int stop = 0;
    int loc = 0;

    String dna1 = dna.toUpperCase();
    // System.out.println(dna1);

    while (true) {
      loc = dna1.indexOf("ATG", start);
      if (loc == -1) break;
      int sloc = stopIndex(dna1, loc + 3);
      if (sloc > dna.length()) {
        // continue;
        // System.out.println("");
      } else {
        sr.add(dna.substring(loc, sloc));
        // System.out.println(dna.substring(loc,sloc));
        loc = sloc - 3;
      }
      // System.out.println(loc);
      start = loc + 3;
    }
    return sr;
  }
  /**
   * A method that indicates the end of a gene, which is found in a dna.
   *
   * @param dna The dna strand to search for gene's end.
   * @param startIndex The index of the searching start.
   * @return The index of end.
   */
  public int stopIndex(String dna, int startIndex) {
    int stopTAG = dna.indexOf("TAG", startIndex);
    if (stopTAG == -1 || (stopTAG - startIndex) % 3 != 0) stopTAG = dna.length();

    int stopTGA = dna.indexOf("TGA", startIndex);
    if (stopTGA == -1 || (stopTGA - startIndex) % 3 != 0) stopTGA = dna.length();

    int stopTAA = dna.indexOf("TAA", startIndex);
    if (stopTAA == -1 || (stopTAA - startIndex) % 3 != 0) stopTAA = dna.length();

    return Math.min(stopTAG + 3, Math.min(stopTGA + 3, stopTAA + 3));
  }
  /**
   * A method that calculates the CG ratio.
   *
   * @param dna The dna strand to search for genes.
   * @return The CG Ratio.
   */
  public float cgRatio(String dna) {
    dna = dna.toUpperCase();
    int i = 0, counter = 0;
    while (true) {
      int cid = dna.indexOf("C", i);
      if (cid == -1) cid = dna.length() + 1;

      int gid = dna.indexOf("G", i);
      if (gid == -1) gid = dna.length() + 1;

      int pos = Math.min(cid, gid);

      if (pos == dna.length() + 1) break;
      else counter++;

      i = pos + 1;
    }

    return (float) counter / dna.length();
  }
  /**
   * A method that calculates how many times the CTG codon is appeared.
   *
   * @param dna The dna strand to search for genes.
   * @return The Counter.
   */
  public int ctgCounter(String dna) {
    dna = dna.toUpperCase();
    int i = 0, counter = 0, pos = 0;
    while (true) {
      pos = dna.indexOf("CTG", i);

      if (pos == -1) break;
      else counter++;

      i = pos + 1;
    }

    return counter;
  }
  /**
   * A method that find the length of longest gene.
   *
   * @param genes The genes of a dna strand.
   * @return The Length of longer gene.
   */
  public int longestGene(StorageResource sr) {
    int maxlength = 0;
    for (String a : sr.data()) {
      maxlength = Math.max(a.length(), maxlength);
    }
    return maxlength;
  }

  public void printGenes(StorageResource sr) {
    int counter60 = 0;
    int counter035 = 0;
    for (String a : sr.data()) {
      if (a.length() > 60) {
        System.out.println("String length longer than 60 : " + a);
        counter60++;
      }
      if (cgRatio(a) > 0.35) {
        System.out.println("CG Ratio greater than 0.35 : " + a);
        counter035++;
      }
    }
    System.out.println("Number of elements with length greater than 60 : " + counter60);
    System.out.println("Number of elements with CG ratio greater than 0.35 : " + counter035);
  }

  public void testStorageFinder() {
    String dnaString = "";
    //FileResource dna = new FileResource("brca1line.fa");
    FileResource dna = new FileResource("GRch38dnapart.fa");
    dnaString = dna.asString();
    // String dnaString="ATGCCATAG";
    StorageResource sr = storeAll(dnaString);
    printGenes(sr);
    System.out.println("Number of genes: " + sr.size());
    System.out.println("Number of CTG : " + ctgCounter(dnaString));
    System.out.println("The length of longer gene is : " + longestGene(sr));
  }
}