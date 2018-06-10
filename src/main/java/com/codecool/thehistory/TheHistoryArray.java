package com.codecool.thehistory;


import java.util.concurrent.ThreadLocalRandom;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray;

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] fromWords = text.split("\\s+");
        wordsArray = new String[fromWords.length];
        wordsArray = fromWords;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        int index = 0;
        String[] result = new String[wordsArray.length];
        for (int i = 0; i < wordsArray.length; i++) {
               if (!wordsArray[i].equals( wordToBeRemoved)){
                   result[index]= wordsArray[i];
                   index++;
               }
            }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)){
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int randomNum;
        if (fromWords.length > 2) {
            randomNum = ThreadLocalRandom.current().nextInt(1, fromWords.length - 1);
        }
        else {
            randomNum = 0;
        }
        int index = 0;
        String[] result;
        result = new String[wordsArray.length+10000];
        if (fromWords.length>0) {
            for (int i = 0; i < wordsArray.length; i++) {
                if ((wordsArray[i].equals(fromWords[0]) && (i + fromWords.length - 1 < wordsArray.length))) {
                    if (wordsArray[i + fromWords.length - 1].equals(fromWords[fromWords.length - 1]) && wordsArray[i + randomNum].equals(fromWords[randomNum])) {
                        for (int j = 0; j < toWords.length; j++) {
                            result[index] = toWords[j];
                            index++;
                        }
                        i += fromWords.length - 1;
                    } else {
                        result[index] = wordsArray[i];
                        index++;
                    }
                } else {
                    result[index] = wordsArray[i];
                    index++;
                }
            }
            wordsArray = new String[index];
            for (int i = 0; i < result.length; i++) {
                if (result[i]!=null){
                    wordsArray[i]=result[i];
                }else {
                    break;
                }

            }
        }
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

