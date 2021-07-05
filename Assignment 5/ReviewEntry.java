public class ReviewEntry {

    //Declaring variables used throughout
    private int sentenceID;
    private int totalPhraseScore;
    private int numPhrases;

    //Zero parameter constructor
    ReviewEntry(){
        sentenceID = 0;
        totalPhraseScore = 0;
        numPhrases = 0;
    }

    //Constructor with parameters
    ReviewEntry(int sentenceID, int totalPhraseScore, int numPhrases) {
        this.sentenceID = sentenceID;
        this.totalPhraseScore = totalPhraseScore;
        this.numPhrases = numPhrases;
    }

    //To string method for debugging
    public String toString() {
        String s = this.getSentenceID() + ",  " + this.getTotalPhraseScore() + ", " + this.getNumPhrases();
        return s;
    }

    //Calculate average sentimenet for a sentence, determine pos/neut/neg, return results in string
    public String averageSentiment() {
        float avgSentiment;
        String sentimentWord;
        String returnPhrase;

        avgSentiment = (float) this.getTotalPhraseScore() / this.getNumPhrases();

        if(avgSentiment >= 0 && avgSentiment < 2.0) {
            sentimentWord = "negative";
        }
        else if(avgSentiment >= 2.0 && avgSentiment < 3.0){
            sentimentWord = "neutral";
        }
        else{
            sentimentWord = "positive";
        }

        returnPhrase = " has " + this.getNumPhrases() + " phrases with an average rating of " + avgSentiment +
                ". The overall sentiment is " + sentimentWord + ".";

        return returnPhrase;
    }

    //Setters
    public void setSentenceID(int sentenceID) {
        this.sentenceID = sentenceID;
    }
    public void setTotalPhraseScore(int totalPhraseScore) {
        this.totalPhraseScore = totalPhraseScore;
    }
    public void setNumPhrases(int numPhrases) {
        this.numPhrases = numPhrases;
    }

    //Getters
    public int getSentenceID() {
        return this.sentenceID;
    }
    public int getTotalPhraseScore() {
        return this.totalPhraseScore;
    }
    public int getNumPhrases() {
        return this.numPhrases;
    }

}
