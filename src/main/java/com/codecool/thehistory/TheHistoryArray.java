package com.codecool.thehistory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] tempArr = text.trim().split("\\s+");
        String[] resultArr = new String[wordsArray.length+tempArr.length];

        System.arraycopy(wordsArray,0,resultArr,0, wordsArray.length);
        System.arraycopy(tempArr,0,resultArr,wordsArray.length, tempArr.length);
        wordsArray = resultArr;


    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        int target = 0; //How many element it will be remove

        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(wordToBeRemoved)) {
                wordsArray[i] = null;
                target += 1;
            }
        }
        String[] tempArr = new String[wordsArray.length - target];
        int count = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i] != null) {
                tempArr[count] = wordsArray[i];
                count++;
            }
        }
        wordsArray = tempArr;

    }

    @Override
    public int size() {
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)){
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
