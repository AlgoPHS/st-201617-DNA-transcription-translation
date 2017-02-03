package org.phs.princetonk12.simran.projects.symboltables;

import java.util.HashMap;
import java.util.Scanner;

/*@author Simran Kaur
 * 1/30/17
 * 
 * The following program takes an input String representing a DNA sequence. This sequence is converted to an RNA sequence, which is futher converted to an amino acid protein sequence using a symbol table.
 * 
 * java org.phs.princetonk12.simran.projects.symboltables.DnaTranscriptionTranslation

 * Input:
 * AGACCTCCTCATACCGTGTGCTCCCTAGACCGGCAAATGTATCAATATCAAAAAGTATCAGA
 * CACACGGCTTCTTAGCCTGCCACGTCGGTCACCGGGCTTCCACACAGTATACCGGTCCCAAT
 * TTCAACATCCTTGTGCAACAGCTTAGGAGCCAAAAAAGGTTGTATTGGTTGTTATTTACCGC
 * ACTCTGCTTAGAGTATATGTCAACCTGCACTCCCCCCTGAGATCACAGGAAGCCACGACCAT
 * TTTTATCACTCTCGGCACTACATGAGTGCTGCCATTACCTCTGGTTAAGGTTAGATCCGGCG
 * GGTCGTGCGAATGATCTCATCGACAGTTATGCGGCTTGTTTTGCCCCGTATGTAAATTAGGT
 * TGTGTAGAGTGTGATTCAACAACCCTAAACCGAAGGTTGCTAAGCGTCATGCTCACGATGTT
 * GAGACATTAACCCCGAAAGTATTCCCTAGTGCTCAACTTCATAGTCCCTGAAATAGAGGCTT
 * CAGATAGGGCAGACCGGGATACTACGGTCCACAAGAGATCCGAGAGAGCTGGGCAATACAAT
 * GATGAGGGTAAAATAGGGATTATGAGGGGAGCGTACTAGTCAGTTCGGATCTACCACACAAC
 * GCCCTGCATCCAGGAAATTCCTGAGCCTAACGTGTTCCTGTCTAATAAACGCCACACGGCCG
 * AGACCAGTAACAGCCCCGACCCAAGCATAGTAGAGGTGTATGTCCTTCGAATCGGCTCTGGA
 * GATCTTGGTCTACCGGGCTGAGGATCGGTCGTACTTCGTAATGTACAACATTTGGATCTTAA
 * AGCTCTGTCGCCCGGAATCACTGGCCACAGCCACTAGACACCGACAGGCTCTAACGGAACCA
 * ATGGTCTTAACTAAGAATGACAATTGGTACCGTGCAATCTGTCAACGTTGAATGTCGCCGGA
 * GTTCCGTCTCTCCTAGAGAAAGAGCGGTAGCATGCAGCCAAGAGGAATAGACTGCCCATTTT
 * AGGCCCTGTTC
 * 
 * Output:
 * AGACCTCCTCATACCGTGTGCTCCCTAGACCGGCAAATGTATCAATATCAAAAAGTATCAGA
 * CACACGGCTTCTTAGCCTGCCACGTCGGTCACCGGGCTTCCACACAGTATACCGGTCCCAAT
 * TTCAACATCCTTGTGCAACAGCTTAGGAGCCAAAAAAGGTTGTATTGGTTGTTATTTACCGC
 * ACTCTGCTTAGAGTATATGTCAACCTGCACTCCCCCCTGAGATCACAGGAAGCCACGACCAT
 * TTTTATCACTCTCGGCACTACATGAGTGCTGCCATTACCTCTGGTTAAGGTTAGATCCGGCG
 * GGTCGTGCGAATGATCTCATCGACAGTTATGCGGCTTGTTTTGCCCCGTATGTAAATTAGGT
 * TGTGTAGAGTGTGATTCAACAACCCTAAACCGAAGGTTGCTAAGCGTCATGCTCACGATGTT
 * GAGACATTAACCCCGAAAGTATTCCCTAGTGCTCAACTTCATAGTCCCTGAAATAGAGGCTT
 * CAGATAGGGCAGACCGGGATACTACGGTCCACAAGAGATCCGAGAGAGCTGGGCAATACAAT
 * GATGAGGGTAAAATAGGGATTATGAGGGGAGCGTACTAGTCAGTTCGGATCTACCACACAAC
 * GCCCTGCATCCAGGAAATTCCTGAGCCTAACGTGTTCCTGTCTAATAAACGCCACACGGCCG
 * AGACCAGTAACAGCCCCGACCCAAGCATAGTAGAGGTGTATGTCCTTCGAATCGGCTCTGGA
 * GATCTTGGTCTACCGGGCTGAGGATCGGTCGTACTTCGTAATGTACAACATTTGGATCTTAA
 * AGCTCTGTCGCCCGGAATCACTGGCCACAGCCACTAGACACCGACAGGCTCTAACGGAACCA
 * ATGGTCTTAACTAAGAATGACAATTGGTACCGTGCAATCTGTCAACGTTGAATGTCGCCGGA
 * GTTCCGTCTCTCCTAGAGAAAGAGCGGTAGCATGCAGCCAAGAGGAATAGACTGCCCATTTT
 * AGGCCCTGTTC
 * The corresponding RNA sequence is: UCUGGAGGAGUAUGGCACACGAGGGAUC
 * UGGCCGUUUACAUAGUUAUAGUUUUUCAUAGUCUGUGUGCCGAAGAAUCGGACGGUGCAGCCA
 * GUGGCCCGAAGGUGUGUCAUAUGGCCAGGGUUAAAGUUGUAGGAACACGUUGUCGAAUCCUCG
 * GUUUUUUCCAACAUAACCAACAAUAAAUGGCGUGAGACGAAUCUCAUAUACAGUUGGACGUGA
 * GGGGGGACUCUAGUGUCCUUCGGUGCUGGUAAAAAUAGUGAGAGCCGUGAUGUACUCACGACG
 * GUAAUGGAGACCAAUUCCAAUCUAGGCCGCCCAGCACGCUUACUAGAGUAGCUGUCAAUACGC
 * CGAACAAAACGGGGCAUACAUUUAAUCCAACACAUCUCACACUAAGUUGUUGGGAUUUGGCUU
 * CCAACGAUUCGCAGUACGAGUGCUACAACUCUGUAAUUGGGGCUUUCAUAAGGGAUCACGAGU
 * UGAAGUAUCAGGGACUUUAUCUCCGAAGUCUAUCCCGUCUGGCCCUAUGAUGCCAGGUGUUCU
 * CUAGGCUCUCUCGACCCGUUAUGUUACUACUCCCAUUUUAUCCCUAAUACUCCCCUCGCAUGA
 * UCAGUCAAGCCUAGAUGGUGUGUUGCGGGACGUAGGUCCUUUAAGGACUCGGAUUGCACAAGG
 * ACAGAUUAUUUGCGGUGUGCCGGCUCUGGUCAUUGUCGGGGCUGGGUUCGUAUCAUCUCCACA
 * UACAGGAAGCUUAGCCGAGACCUCUAGAACCAGAUGGCCCGACUCCUAGCCAGCAUGAAGCAU
 * UACAUGUUGUAAACCUAGAAUUUCGAGACAGCGGGCCUUAGUGACCGGUGUCGGUGAUCUGUG
 * GCUGUCCGAGAUUGCCUUGGUUACCAGAAUUGAUUCUUACUGUUAACCAUGGCACGUUAGACA
 * GUUGCAACUUACAGCGGCCUCAAGGCAGAGAGGAUCUCUUUCUCGCCAUCGUACGUCGGUUCU
 * CCUUAUCUGACGGGUAAAAUCCGGGACAAG
 * The amino acids in the protein are (in the following order): 
 * methionine  -> alanine -> histidine -> glutamate -> glycine -> serine -> glycine -> arginine
 */
public class DnaTranscriptionTranslation {

	//Symbol Table of Codons and corresponding amino acids
	private static HashMap<String, String> codonToAminoAcidSymbolTable = new HashMap<>();
	
	static {
	  codonToAminoAcidSymbolTable.put("GC",  "alanine");
	  codonToAminoAcidSymbolTable.put("UUU", "phenylalanine"); 
      codonToAminoAcidSymbolTable.put("UUC", "phenylalanine");
      codonToAminoAcidSymbolTable.put("UUA", "leucine");
      codonToAminoAcidSymbolTable.put("UUG", "leucine"); 
      codonToAminoAcidSymbolTable.put("CU",  "leucine");
      codonToAminoAcidSymbolTable.put("CC",  "proline"); 
      codonToAminoAcidSymbolTable.put("UUA", "threonine"); 
      codonToAminoAcidSymbolTable.put("GG", "glycine");
      codonToAminoAcidSymbolTable.put("UC", "serine");
      codonToAminoAcidSymbolTable.put("UAU", "tyrosine");
      codonToAminoAcidSymbolTable.put("UAC", "tyrosine"); 
      codonToAminoAcidSymbolTable.put("UAA", "stop"); 
      codonToAminoAcidSymbolTable.put("UGU", "cysteine"); 
      codonToAminoAcidSymbolTable.put("UGC", "cysteine"); 
      codonToAminoAcidSymbolTable.put("UGA", "stop");
      codonToAminoAcidSymbolTable.put("UGG", "tryptophan"); 
      codonToAminoAcidSymbolTable.put("CAU", "histidine"); 
      codonToAminoAcidSymbolTable.put("CAC", "histidine"); 
      codonToAminoAcidSymbolTable.put("CAA", "glutamine");
      codonToAminoAcidSymbolTable.put("CAG", "glutamine");
      codonToAminoAcidSymbolTable.put("CG", "arginine");
      codonToAminoAcidSymbolTable.put("AUU", "isoleucine"); 
      codonToAminoAcidSymbolTable.put("AUC", "isoleucine");
      codonToAminoAcidSymbolTable.put("AUA", "isoleucine"); 
      codonToAminoAcidSymbolTable.put("AUG", "methionine"); 
      codonToAminoAcidSymbolTable.put("AAU", "asparagine"); 
      codonToAminoAcidSymbolTable.put("AAC", "asparagine");
      codonToAminoAcidSymbolTable.put("AAA", "lysine");
      codonToAminoAcidSymbolTable.put("AAG", "lysine"); 
      codonToAminoAcidSymbolTable.put("AGU", "serine"); 
      codonToAminoAcidSymbolTable.put("AGC", "serine"); 
      codonToAminoAcidSymbolTable.put("AGA", "arginine");
      codonToAminoAcidSymbolTable.put("GU", "valine");
      codonToAminoAcidSymbolTable.put("GAU", "aspartate"); 
      codonToAminoAcidSymbolTable.put("GAC", "aspartate"); 
      codonToAminoAcidSymbolTable.put("GAA", "glutamate");
      codonToAminoAcidSymbolTable.put("GAG", "glutamate"); 
	}
	
	private Scanner scanner;

    // inputted DNA Sequence
    private String dnaSequence;
    
    // RNA sequence based on DNA Sequence
    private StringBuilder rnaSequence;
    
    // Amino acid sequence in protein
    private StringBuilder aminoAcidSequence;
	
	
	public DnaTranscriptionTranslation() {
		scanner = new Scanner(System.in);
		rnaSequence = new StringBuilder();
		aminoAcidSequence = new StringBuilder();
	}

	//Get the DNA sequence input
	public void getUserInput() {
		System.out.println("Enter the bases (A, C, G, T) in a DNA sequence: ");
		dnaSequence = scanner.next();
	}

	// process of transcribing the RNA from the DNA
	public void doTranscribe() {
		int index = 0;
		char ch;

		// clear rnaSequence
		rnaSequence.delete(0, rnaSequence.length());

		while (index < dnaSequence.length()) {
			ch = dnaSequence.charAt(index);
			switch (ch) {
			case 'A':
				rnaSequence.append("U");
				break;
			case 'C':
				rnaSequence.append("G");
				break;
			case 'G':
				rnaSequence.append("C");
				break;
			case 'T':
				rnaSequence.append("A");
				break;
			default:
				System.out.println("\n Invalid base. Only A, C, G, T are allowed");
				System.exit(1);
				break;
			}
			index++;
		}
		System.out.println("\nThe corresponding RNA sequence is: " + rnaSequence);
	}

	// get the Amino Acid coded by the given codon
	private String getAminoAcidFromSymbolTable(String codon) {
		
		String aminoAcid = codonToAminoAcidSymbolTable.get(codon);
		if (aminoAcid != null) return aminoAcid;
		
		for (int i=0; i < codon.length(); i++) {
		  String token = codon.substring(0, i+1);
		  
		  aminoAcid = codonToAminoAcidSymbolTable.get(token);
	      if (aminoAcid != null) return aminoAcid;
		}
		
		System.out.println("Error: Amino Acid not found for codon" + codon);
		return null;
	}

	// finds the sequence of Amino Acids that make up the protein
	// Start Codon : AUG, Stop codon : UUA, UAG, UUA
	public void doTranslate() {
		int codonLength = 3; // codon had 3 char
		boolean stopCodonFound = false;

		// clear protein sequence
		aminoAcidSequence.delete(0, aminoAcidSequence.length());

		// find the start codon "AUG"
		int index = rnaSequence.indexOf("AUG");
		if (index != -1) {
			// get protein for start codon "AUG"
			aminoAcidSequence.append(getAminoAcidFromSymbolTable("AUG"));
			aminoAcidSequence.append(" ");
		} else {
			System.out.println("Starting codon AUG not found ");
			System.exit(1);
		}

		// find the remaining codons till stop codon is found
		do {
			// get index of next codon
			index += codonLength;

			if (index + codonLength <= rnaSequence.length()) {
				// get next codon and determine if it is stop codon
				String codon = rnaSequence.substring(index, index + codonLength);
				stopCodonFound = (codon.equals("UUA") || codon.equals("UAG") || codon.equals("UGA"));
				// get amino acid coded by its codon and add it to StringBuilder
				// protein
				if (!stopCodonFound) {
					aminoAcidSequence.append(" -> " + getAminoAcidFromSymbolTable(codon));
				}
			} else {
				System.out.println("Stop Codon UUA, UAG or UGA not found");
				System.exit(1);

			}
		} while (!stopCodonFound);

		System.out.println("The amino acids in the protein are (in the following order): " + aminoAcidSequence);
	}

	public static void main(String[] args) {
		DnaTranscriptionTranslation getProteinSequence = new DnaTranscriptionTranslation();
		
		getProteinSequence.getUserInput();
		
		getProteinSequence.doTranscribe();
		getProteinSequence.doTranslate();
	}
}