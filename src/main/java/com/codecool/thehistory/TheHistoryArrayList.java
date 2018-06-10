package com.codecool.thehistory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] fromWords = text.split("\\s+");
        for ( int i = 0; i < fromWords.length; i++){
                wordsArrayList.add(fromWords[i]);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
       List<String> listToBeRemoved = new ArrayList<>();
       listToBeRemoved.add(wordToBeRemoved);
       wordsArrayList.removeAll(listToBeRemoved);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArrayList.size(); i++){
            if (wordsArrayList.get(i).equals(from)){
                wordsArrayList.set(i,to);
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
        List<String> result = new ArrayList<>();
        int fromLastIndex = fromWords.length - 1;
        for (int i = 0; i < wordsArrayList.size(); i++) {
            if (wordsArrayList.get(i).equals(fromWords[0]) && i + fromLastIndex < wordsArrayList.size()){
                if (wordsArrayList.get(i + fromLastIndex).equals(fromWords[fromLastIndex]) &&
                        wordsArrayList.get(i + randomNum).equals(fromWords[randomNum])) {
                    for (int j = 0; j < toWords.length; j++) {
                        result.add(toWords[j]);
                        i += fromWords.length-1;
                    }
                }else {
                    result.add(wordsArrayList.get(i));
                }
            }else {
                result.add(wordsArrayList.get(i));
            }
        }
        wordsArrayList = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
