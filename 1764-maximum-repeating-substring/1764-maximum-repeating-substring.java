class Solution {
    public int maxRepeating(String sequence, String word) {
        int count=0,beg=0;
        String wordToFind=word;


        while(true){
            int idx=sequence.substring(beg).indexOf(wordToFind);
            if(idx==-1){
                return count;
            }
            else{
                count++;
                wordToFind+=word;
                beg=idx;
            }
        }
        
    }
}