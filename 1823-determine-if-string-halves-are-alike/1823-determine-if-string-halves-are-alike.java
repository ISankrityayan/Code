class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character>vowels=new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');    vowels.add('u');

    vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');

    int vowelCount=0;
    int midIndex=s.length()/2;

    for(int i=0;i<midIndex;i++){
        char charA=s.charAt(i);
        char charB=s.charAt(midIndex+i);
        if(vowels.contains(charA)) vowelCount++;
         if(vowels.contains(charB)) vowelCount--;
    }

    return vowelCount==0;


    }
}