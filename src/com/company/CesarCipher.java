package com.company;

public class CesarCipher {

    public void decipher(String text) {
        String deciperText = "";
        char[] letters = text.toCharArray();
        for(int numberOfLetters = 1; numberOfLetters <= 33; numberOfLetters++) {
            for (int i = 0; i < letters.length; i++) {
                int letterCode = serchLetterInAlphabet(letters[i]);
                if (letterCode <= 65 && letterCode >= 33) {
                    deciperText += decipherUpperCaseLetter(letterCode, numberOfLetters);
                } else {
                    if (letterCode <= 32 && letterCode >= 0) {
                        deciperText += decipherLowerCaseLetter(letterCode, numberOfLetters);
                    } else {
                        deciperText += letters[i];
                    }
                }
            }
            System.out.println(deciperText);
            System.out.println();
            deciperText = "";
        }
    }

    public String decipherLowerCaseLetter(int letter, int cipher) {
        int newLetter = letter + cipher;
        if(newLetter > 32) {
            newLetter = newLetter - 33;
        }

        return "" + RussianAlphabet.RUSSIAN_ALPHABET[newLetter];
    }

    public String decipherUpperCaseLetter(int letter, int cipher) {
        int newLetter = letter + cipher;
        if(newLetter > 65) {
            newLetter = newLetter - 66 + 33;
        }

        return "" + RussianAlphabet.RUSSIAN_ALPHABET[newLetter];
    }

    public int serchLetterInAlphabet(char letter) {
        int desiredLetterNumber = -1;
        for(int i = 0; i < RussianAlphabet.RUSSIAN_ALPHABET.length; i++) {
            if(RussianAlphabet.RUSSIAN_ALPHABET[i] == letter) {
                desiredLetterNumber = i;
            }
        }
        return desiredLetterNumber;
    }
}
