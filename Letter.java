/*

This is a class that can store letters and give them value
5/12/2023
*/

public class Letter{
 private String character;
 private int color;

 
 public Letter(){
 character="";
 color=0;
 }
 
 public Letter(String C, int c){
 character=C;
 color=c;
    //System.out.println("Hey I just added a "+character);
 }
 
public String toString(){
String output = "";
//System.out.println("In the toString method color is "+color);
switch(color){
case 0: output = "<html><font color=\"#000000\"> "+character;break;
case 1: output ="<html><font color=\"#D4C813\"> " +character ; break;
case 2: output = "<html><font color=\"#4FC44A\"> " +character ;break;
}
return output;
}//end to string
 
}//end letter