// Java program for the above approach
import java.util.*;

class prac2{

// Function to decrypt a monoalphabetic
// substitution cipher using the letter
// frequency attack
static void printString(String S, int N)
{

	// Stores final 5 possible deciphered
	// plaintext
	String []plaintext = new String[5];

	// Store the frequency of each letter in
	// cipher text
	int freq[] = new int[26];

	// Stores the frequency of each letter
	// in cipher text in descending order
	int freqSorted[] = new int[26];

	// Store which alphabet is used already
	int Used[] = new int[26];

	// Traverse the String S
	for (int i = 0; i < N; i++) {
		if (S.charAt(i) != ' ') {
			freq[S.charAt(i) - 'A']++;
		}
	}

	// Copy the frequency array
	for (int i = 0; i < 26; i++) {
		freqSorted[i] = freq[i];
	}

	// Stores the String formed from concatenating
	// the english letters in the decreasing frequency
	// in the english language
	String T = "ETAOINSHRDLCUMWFGYPBVKJXQZ";

	// Sort the array in descending order
	Arrays.sort(freqSorted);
	freqSorted= reverse(freqSorted);
	// Iterate over the range [0, 5]
	for (int i = 0; i < 5; i++) {

		int ch = -1;

		// Iterate over the range [0, 26]
		for (int j = 0; j < 26; j++) {

			if (freqSorted[i] == freq[j] && Used[j] == 0) {
				Used[j] = 1;
				ch = j;
				break;
			}
		}
		if (ch == -1)
			break;

		// Store the numerical equivalent of letter at
		// ith index of array letter_frequency
		int x = T.charAt(i) - 'A';
		
		// Calculate the probable shift used
		// in monoalphabetic cipher
		x = x - ch;

		// Temporary String to generate one
		// plaintext at a time
		String curr = "";

		// Generate the probable ith plaintext
		// String using the shift calculated above
		for (int k = 0; k < N; k++) {

			// Insert whitespaces as it is
			if (S.charAt(k) == ' ') {
				curr += (char)' ';
				continue;
			}

			// Shift the kth letter of the
			// cipher by x
			int y = S.charAt(k) - 'A';
			y += x;

			if (y < 0)
				y += 26;
			if (y > 25)
				y -= 26;

			// Add the kth calculated/shifted
			// letter to temporary String
			curr += (char)('A' + y);
		}

		plaintext[i] = curr;
	}

	// Print the generated 5 possible plaintexts
	for (int i = 0; i < 5; i++) {
		System.out.print(plaintext[i] +"\n");
	}
}
static int[] reverse(int a[]) {
	int i, n = a.length, t;
	for (i = 0; i < n / 2; i++) {
		t = a[i];
		a[i] = a[n - i - 1];
		a[n - i - 1] = t;
	}
	return a;
}
// Driver Code
public static void main(String[] args)
{
	// Given String
	String S = "B TJNQMF NFTTBHF";
	int N = S.length();

	// Function Call
	printString(S, N);

}
}

// This code contributed by Princi Singh
