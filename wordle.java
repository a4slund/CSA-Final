/*
Andrew Forslund
This is the final project for ap csa
5/4/23 1.0.0
*/
import javax.swing.*;

public class wordle{
static Letter[] userGuess = new Letter[5];
static String secret;

public static String wordGet(){//list of words we want to use
String [] Word={"apple","beach","chair","dance","earth","flute","grape","happy","igloo","juice","karma","lemon","money","night","opera","pizza","quilt","radar","shoes","tiger"};
secret = Word[(int)(Math.random()*20)];//randomises the word each time
return secret;
}//end wordGet

public static boolean wordCheck(String input){
boolean value=true;
String specials="! @ # $ % ^ & * ( ) - _ + = [ ] { } \\ | ; : \' \" , < > ? / ` ~ ";
if(input.length()!=5)//if the word is 5 letters long and is a word
return false;

for (int i=0;i<input.length();i++){
if(specials.contains(input.charAt(i)+""))
  return false;

if(Character.isDigit(input.charAt(i)))
return false;

 }
 return true;
}//end wordCheck

public static void wordMake(String input){
String output ="";
input=input.toLowerCase();
boolean changedColor = false;

for(int i = 0; i < 5; i++){
   for(int j = 0; j < 5; j++){
      changedColor = false;
      if (input.charAt(i)==(secret.charAt(i))){
         userGuess[i] = new Letter(input.charAt(i) + "",2); changedColor = true; break;}
       else if (input.charAt(i)==(secret.charAt(j))) {
         userGuess[i] = new Letter(input.charAt(i) + "",1); changedColor = true; break;
      } 
}
if(changedColor == false){
   userGuess[i] = new Letter(input.charAt(i) + "",0);
}
}

/*for(int i=0;i<5;i++){
   changedColor = false;
   if(input.charAt(i)==(secret.charAt(i))){
      userGuess[i] = new Letter(input.charAt(i) + "",2);
      changedColor = true;
            }
      else{
         for(int j=i+1;j<5;j++){
            if(input.charAt(i)==(secret.charAt(j))){
               userGuess[i] = new Letter (input.charAt(i) + "",1);
             
               changedColor = true;
              
               }

       }//end of secret loop

    
  }//end else
  System.out.println("in for loop, changed color is " + changedColor);
  
      for(int x=0; x<4;x++){
     if(input.charAt(x)==secret.charAt(1)){
       userGuess[i] = new Letter (input.charAt(x) + "",1);
               changedColor = true;
               }
              }
              

}
}*/

}//end word compare

public static void main(String[] args){
// word test System.out.println(wordGet());
//color test   JOptionPane.showMessageDialog(null,"<html><font color=\"#851797\"> word");
  //class test  Letter[] bogus= { new Letter("A",1), new Letter("B", 2), new Letter("C",0)};
  //class test  JOptionPane.showMessageDialog(null,bogus);
int guess=0;
boolean win =false;
String input;
String output = "";
wordGet();
//System.out.println(secret);
while(win==false && guess<=5){

input=JOptionPane.showInputDialog(output +"\nEnter your guess");

/*wordCheck(input);
if(wordCheck(input)==false){
JOptionPane.showMessageDialog(null,"Please Enter a valid word the one you entered wasn't valid");
}*/


if (wordCheck(input)){
wordMake(input);
output += "\n" + userGuess[0] + "" + userGuess[1] + "" + userGuess[2] + "" + userGuess[3] + "" + userGuess[4];
JOptionPane.showMessageDialog(null,output); //userGuess[0] +""+ userGuess[1] +""+ userGuess[2] +""+ userGuess[3] +""+ userGuess[4]);


guess++;

}else
JOptionPane.showMessageDialog(null,"The guess you entered isn't valid please enter a new one");

if(input.equalsIgnoreCase(secret)){
win=true;
JOptionPane.showMessageDialog(null,"You win!!");
}//end if
}//end while
if(win==false)
JOptionPane.showMessageDialog(null,"You lost!! the word was "+secret);




}//end main
}//end wordle