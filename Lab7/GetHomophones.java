// lab7
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class GetHomophones {
public static void main(String[] args) {
//OALDictionary<String, Pronunciation> PDict = new OALDictionary<String, Pronunciation>();
//Pdict
Lab7BST<String, PS7HWPronunciation> PDict = new Lab7BST<String, PS7HWPronunciation>();
// Uncomment when submitting on Vocareum and comment line below
// File file = new File("../resource/asnlib/publicdata/cmudict.0.7a.txt");
File file = new File("cmudict.0.7a.txt");
Scanner scan = new Scanner(System.in);
long start = System.currentTimeMillis();
int count = 0;
//int endVal = scan.nextInt();
String str = scan.next().toUpperCase();
try {
Scanner scanner = new Scanner(file);
while (scanner.hasNextLine()) {
String line = scanner.nextLine();
if (line.substring(0, 3).equals(";;;"))
continue; // skip comment lines
PS7HWPronunciation p = new PS7HWPronunciation(line);
PDict.insert(p.getPhonemes(), p);
}
scanner.close();
} catch (FileNotFoundException e) {
e.printStackTrace();
}
long middle = System.currentTimeMillis();
System.out.println("Loaded dictionary; elapsed time " + (middle - start));
//int count = 0;
//int max = 0;
//ArrayList<Pronunciation> homophones = new ArrayList<Pronunciation>();
//ArrayList<Pronunciation> homophoneList = new ArrayList<Pronunciation>();
//iterates through each word in the dictionary
for (PS7HWPronunciation p : PDict.values())
{
if(p.getWord().equals(str)){
//System.out.println(p);
System.out.println(PDict.findAll(p.getPhonemes()));
Iterable <PS7HWPronunciation> d = PDict.findAll(p.getPhonemes());
for(Object j : d){
    count ++;
}
System.out.println(count);
}
}
}
}
